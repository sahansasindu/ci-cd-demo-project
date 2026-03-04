package com.cicd_sample_project.ci_cd_demo_project.service;

import com.cicd_sample_project.ci_cd_demo_project.dto.user.UserReqDto;

public interface UserService {
    void addNewUser(UserReqDto userReqDto);
}
