package com.application.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractJpaRepository<T> extends JpaRepository<T, Integer> {

}
