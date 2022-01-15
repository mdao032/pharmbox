package com.exp.managementapps.healthmedicine.persistence.dto.actuator.config;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertiesFileDto {

    private String filename;
    private List<PropertyDto> propertiesList;
}
