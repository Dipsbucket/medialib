package com.application.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.server.data.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByLogin(String login);
}