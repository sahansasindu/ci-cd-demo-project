package com.cicd_sample_project.ci_cd_demo_project.controller;

import com.cicd_sample_project.ci_cd_demo_project.dto.common.CommonResponse;
import com.cicd_sample_project.ci_cd_demo_project.dto.user.UserReqDto;
import com.cicd_sample_project.ci_cd_demo_project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {


    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> addNewUser(@RequestBody UserReqDto userReqDto) {
        userService.addNewUser(userReqDto);
        System.out.println("Hellow111");
        return ResponseEntity.ok(new CommonResponse<>(true, "User added successfully"));
    }

}

