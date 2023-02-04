package com.cartoon.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ShortLocationDto {

    private String name;
    private String url;
}
