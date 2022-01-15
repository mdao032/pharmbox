package com.exp.managementapps.healthmedicine.controller;

import com.exp.managementapps.healthmedicine.business.service.PharmboxServiceExample;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** The class Pharmbox Controller */
@Tag(name = "Pharmbox", description = "Pharmbox controller example")
@RestController
public class PharmboxControllerExample {

    private final PharmboxServiceExample pharmboxServiceExample;

    @Autowired
    public PharmboxControllerExample(PharmboxServiceExample pharmboxServiceExample) {
        this.pharmboxServiceExample = pharmboxServiceExample;
    }

    /** method to print a string as example */
    @Operation(summary = "Print a string", description = "Print the Hello world message")
    @GetMapping(value = "/print-string")
    public ResponseEntity<Void> printString() {

        pharmboxServiceExample.printString();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
