package com.exp.managementapps.healthmedicine.business.actuator;

import com.exp.managementapps.healthmedicine.persistence.dto.actuator.config.PropertiesFileDto;
import com.exp.managementapps.healthmedicine.persistence.dto.actuator.config.PropertiesResponseDto;
import com.exp.managementapps.healthmedicine.persistence.dto.actuator.config.PropertyDto;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ActuatorConfigService {

    private final ConfigurableEnvironment env;

    private List<PropertiesFileDto> propertiesResponseList;

    @Autowired
    public ActuatorConfigService(ConfigurableEnvironment env) {
        this.env = env;
    }

    /**
     * Gets the config
     *
     * @return the config
     */
    public PropertiesResponseDto getConfig() {
        log.debug("Get Yml properties");

        propertiesResponseList = new ArrayList<>();

        PropertiesResponseDto propertiesResponseDto = new PropertiesResponseDto();

        getPropertiesForFile("application.yml", propertiesResponseDto);

        return propertiesResponseDto;
    }

    /**
     * Gets the properties for file
     *
     * @param propertyFilename the property file name
     * @param propertiesResponse the properties response
     * @return the properties for file
     */
    private PropertiesResponseDto getPropertiesForFile(
            String propertyFilename, PropertiesResponseDto propertiesResponse) {

        // Get propertyName of config files
        String[] listProperties =
                ((EnumerablePropertySource<?>) env.getPropertySources().get(propertyFilename))
                        .getPropertyNames();

        // Return properties if file found
        if (listProperties.length == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "the config file " + propertyFilename + "has not been found");
        } else {
            PropertiesFileDto propertiesFile = new PropertiesFileDto();
            List<PropertyDto> propertiesList = new ArrayList<>();

            for (String key : listProperties) {
                PropertyDto property = new PropertyDto();
                property.setKey(key);
                property.setValue(env.getProperty(key));
                propertiesList.add(property);
            }

            propertiesFile.setFilename(propertyFilename);
            propertiesFile.setPropertiesList(propertiesList);

            propertiesResponseList.add(propertiesFile);
            propertiesResponse.setPropertiesFileList(propertiesResponseList);

            return propertiesResponse;
        }
    }
}
