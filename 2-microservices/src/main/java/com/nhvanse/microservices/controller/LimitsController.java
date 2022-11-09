package com.nhvanse.microservices.controller;

import com.nhvanse.microservices.bean.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @GetMapping("/limits")
    public Limits retrieveLimits() {

        return new Limits(1, 1000);
    }
}
