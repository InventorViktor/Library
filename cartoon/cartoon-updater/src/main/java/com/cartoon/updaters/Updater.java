package com.cartoon.updaters;

import com.cartoon.client.CartoonClient;
import com.cartoon.dto.*;
import com.cartoon.dto.pageResoults.PagedResult;
import com.cartoon.mappers.IMap;
import com.cartoon.mappers.collector.ICollectMappers;
import com.cartoon.models.Character;
import com.cartoon.models.Episode;
import com.cartoon.models.IHaveSourceId;
import com.cartoon.models.Location;
import com.cartoon.repositories.catalogs.RepositoryCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class Updater {

    private final CartoonClient client;
    private final RepositoryCollector repositories;
    private final ICollectMappers mappers;

    @Scheduled(fixedDelay = 1200000)
    public void update() {

        List<CharacterDto> characterDtos = getAllDtos(client::getPageCharacters);
        List<LocationDto> locationsDto = getAllDtos(client::getPageLocations);
        List<EpisodeDto> episodesDto = getAllDtos(client::getPageEpisodes);

        //You only need it if database is blank. You can also put yourself that entity in database. Then you can delete this method.
        saveUnknownIfDoesntExist();

        saveNew(characterDtos, mappers.getCharacterMapper(), repositories.getCharacterRepository());
        saveNew(locationsDto, mappers.getLocationMapper(), repositories.getLocationRepository());
        saveNew(episodesDto, mappers.getEpisodeMapper(), repositories.getEpisodeRepository());

        updateEntities(characterDtos, locationsDto);
    }

    private void saveUnknownIfDoesntExist() {
        int amountOfLocations = repositories.getLocationRepository().findAll().size();
        if (amountOfLocations == 0) {
            Location unknownLocation = new Location();
            unknownLocation.setName("unknown");
            unknownLocation.setDimension("unknown");
            unknownLocation.setType("unknown");
            repositories.getLocationRepository().save(unknownLocation);
        }
    }

    private void updateEntities(List<CharacterDto> characterDtos, List<LocationDto> locationsDto) {
        List<Character> allCharacters = repositories.getCharacterRepository().findAll();
        List<Location> allLocations = repositories.getLocationRepository().findAll();
        List<Episode> allEpisodes = repositories.getEpisodeRepository().findAll();

        allCharacters.forEach(character -> {
            CharacterDto updatedCharacter = characterDtos.stream()
                    .filter(characterDto -> characterDto.getId() == character.getSourceId())
                    .findFirst()
                    .get();

            Location newLocation = allLocations.stream()
                    .filter(location -> location.getName().equals(updatedCharacter.getLocation().getName()))
                    .findFirst()
                    .get();

            Location newOrigin = allLocations.stream()
                    .filter(location -> location.getName().equals(updatedCharacter.getOrigin().getName()))
                    .findFirst()
                    .get();

            List<Integer> episodeSourceId = updatedCharacter.getEpisodeURL().stream()
                    .map(url -> Integer.parseInt(url.substring(url.lastIndexOf("/") + 1)))
                    .toList();

            List<Episode> episodes = allEpisodes.stream()
                    .filter(episode -> episodeSourceId.contains(episode.getSourceId()))
                    .toList();


            character.setName(updatedCharacter.getName());
            character.setSpecies(updatedCharacter.getSpecies());
            character.setGender(updatedCharacter.getGender());
            character.setStatus(updatedCharacter.getStatus());
            character.setLocation(newLocation);
            character.setOrigin(newOrigin);
            character.addAllEpisodes(episodes);
            repositories.getCharacterRepository().save(character);
        });


        allLocations.forEach(location -> {

            if (location.getName().equals("unknown")) return;

            LocationDto sameLocationDto = locationsDto.stream()
                    .filter(locationDto -> locationDto.getId() == location.getSourceId())
                    .findFirst()
                    .get();

            List<Integer> residentsSourceIds = sameLocationDto.getResidentsURL().stream()
                    .map(url -> Integer.parseInt(url.substring(url.lastIndexOf("/") + 1)))
                    .toList();

            List<Character> residents = allCharacters.stream()
                    .filter(character -> residentsSourceIds.contains(character.getSourceId()))
                    .toList();

            location.setResidents(residents);
            repositories.getLocationRepository().save(location);
        });
    }

    private <Entity extends IHaveSourceId, Dto> void saveNew(List<Dto> list, IMap<Entity, Dto> mapper, JpaRepository<Entity, Long> repository) {

        List<Entity> entities = list.stream()
                .map(mapper::map)
                .toList();

        List<Integer> entitiesSourceIds = repository.findAll().stream()
                .map(IHaveSourceId::getSourceId)
                .toList();

        List<Entity> entitiesToSave = entities.stream()
                .filter(Predicate.not(entity -> entitiesSourceIds.contains(entity.getSourceId())))
                .toList();

        repository.saveAll(entitiesToSave);
    }

    private <TPage extends PagedResult<InfoDto, TDto>, TDto> List<TDto> getAllDtos(Function<Integer, TPage> action) {

        int page = 1;
        TPage tPage = action.apply(page);
        List<TDto> charactersDto = new ArrayList<>();

        int amountOfPages = tPage.getInfo().getPages();

        while (page <= amountOfPages) {

            tPage = action.apply(page);
            charactersDto.addAll(tPage.getResults());
            page++;
        }
        return charactersDto;
    }
}
