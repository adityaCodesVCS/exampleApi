package com.exampleApi.repository;

import com.exampleApi.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}