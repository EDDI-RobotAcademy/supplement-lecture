package com.example.boilerplateproj.domain.jpa.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JpaAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_account_seq_gen")
    @SequenceGenerator(sequenceName = "jpa_account_seq", name = "jpa_account_seq_gen", allocationSize = 1)
    @Column(name = "jpa_account_id")
    private Long id;

    private String email;

    public JpaAccount(String email) {
        System.out.println("예제이므로 유효성 검사 생략");

        this.email = email;
    }
}
