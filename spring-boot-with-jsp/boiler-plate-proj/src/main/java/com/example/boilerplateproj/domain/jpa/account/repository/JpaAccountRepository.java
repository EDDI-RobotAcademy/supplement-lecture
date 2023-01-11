package com.example.boilerplateproj.domain.jpa.account.repository;

import com.example.boilerplateproj.domain.jpa.account.entity.JpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<JpaAccount, Long> {
}
