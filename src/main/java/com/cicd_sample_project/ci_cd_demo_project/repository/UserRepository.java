package com.cicd_sample_project.ci_cd_demo_project.repository;


import com.cicd_sample_project.ci_cd_demo_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
