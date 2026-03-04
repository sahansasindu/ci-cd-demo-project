package com.cicd_sample_project.ci_cd_demo_project.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
}
