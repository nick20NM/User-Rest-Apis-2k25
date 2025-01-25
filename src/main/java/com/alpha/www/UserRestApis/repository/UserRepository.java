package com.alpha.www.UserRestApis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.www.UserRestApis.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
