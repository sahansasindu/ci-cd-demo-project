package com.cicd_sample_project.ci_cd_demo_project.service.impl;

import com.cicd_sample_project.ci_cd_demo_project.dto.user.UserReqDto;
import com.cicd_sample_project.ci_cd_demo_project.entity.User;
import com.cicd_sample_project.ci_cd_demo_project.enums.ActiveStatus;
import com.cicd_sample_project.ci_cd_demo_project.exception.dto.CustomServiceException;
import com.cicd_sample_project.ci_cd_demo_project.repository.UserRepository;
import com.cicd_sample_project.ci_cd_demo_project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public void addNewUser(UserReqDto userDto) {
        try {
            log.info("start method addNewUser : {}", userDto);
            User user = modelMapper.map(userDto, User.class);
            user.setCreated(new Date());
            user.setUpdated(new Date());
            user.setStatus(ActiveStatus.ACTIVE);

            userRepository.save(user);
        } catch (Exception e) {
            log.error("error : method : addNewUser", e);
            throw new CustomServiceException("Oops! Something went wrong");
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            log.info("start method getAllUsers");
            return userRepository.findAll();
        } catch (Exception e) {
            log.error("error : method : getAllUsers", e);
            throw new CustomServiceException("Oops! Something went wrong");
        }
    }
}
