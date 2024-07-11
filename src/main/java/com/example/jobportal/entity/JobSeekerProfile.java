package com.example.jobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "job_seeker_profile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobSeekerProfile {

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

    private String resume;

    private String workAuthorization;

    private String employmentType;

    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL,
            mappedBy = "jobSeekerProfile")
    private List<Skills> skills;

    public JobSeekerProfile(Users user) {
        this.userId = user;
    }
}
