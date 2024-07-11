package com.example.jobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recruiter_profile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecruiterProfile {

    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String city;

    private String company;

    private String country;

    private String firstName;

    private String lastName;

    @Column(nullable = true, length = 64)
    private String profilePhoto;

    private String state;

    public RecruiterProfile(Users user) {
        this.userId = user;
    }
}

