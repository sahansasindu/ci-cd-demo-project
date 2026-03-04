package com.cicd_sample_project.ci_cd_demo_project.controller;

import com.cicd_sample_project.ci_cd_demo_project.dto.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/application")
@RequiredArgsConstructor
@Log4j2
public class AppController {

    @Value("${appVersion}")
    private String appVersion;


    @GetMapping(value = "/version")
    public ResponseEntity<?> getAppVersion() {
        log.info("start method getAppVersion");
        return ResponseEntity.ok(new CommonResponse<>(true, "application version",appVersion));
    }

}

