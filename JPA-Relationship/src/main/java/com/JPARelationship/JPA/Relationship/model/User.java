package com.JPARelationship.JPA.Relationship.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    @JoinColumn(name ="Profile_id",
    referencedColumnName ="id")
    private Profile profile;

    public User(Integer id, String name, Profile profile) {
        this.id = id;
        this.name = name;
        this.profile = profile;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
