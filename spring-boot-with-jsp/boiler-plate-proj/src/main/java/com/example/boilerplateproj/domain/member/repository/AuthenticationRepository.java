package com.example.boilerplateproj.domain.member.repository;

import com.example.boilerplateproj.domain.member.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
}
