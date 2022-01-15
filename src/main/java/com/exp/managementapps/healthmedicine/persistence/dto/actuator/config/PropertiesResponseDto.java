package com.exp.managementapps.healthmedicine.persistence.dto.actuator.config;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertiesResponseDto {

    private List<PropertiesFileDto> propertiesFileList;
}
