package com.cicd_sample_project.ci_cd_demo_project.service;

import com.cicd_sample_project.ci_cd_demo_project.dto.user.UserReqDto;
import com.cicd_sample_project.ci_cd_demo_project.entity.User;

import java.util.List;

public interface UserService {
    void addNewUser(UserReqDto userReqDto);

    List<User> getAllUsers();
}
