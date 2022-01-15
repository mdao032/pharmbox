package com.exp.managementapps.healthmedicine.controller.actuator;

import com.exp.managementapps.healthmedicine.business.actuator.ActuatorConfigService;
import com.exp.managementapps.healthmedicine.persistence.dto.actuator.config.PropertiesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator/config")
@Endpoint(id = "config")
public class ActuatorConfigEndpoint {

    private final ActuatorConfigService actuatorConfigService;

    @Autowired
    public ActuatorConfigEndpoint(ActuatorConfigService actuatorConfigService) {
        this.actuatorConfigService = actuatorConfigService;
    }

    @GetMapping
    @ReadOperation
    public PropertiesResponseDto config() {
        return actuatorConfigService.getConfig();
    }
}
