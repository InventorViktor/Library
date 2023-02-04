package com.cartoon.mappers;

public interface IMap<Entity, Dto> {

    Entity map(Dto dto);
}
