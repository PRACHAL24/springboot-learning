package com.JPARelationship.JPA.Relationship.service;

import com.JPARelationship.JPA.Relationship.model.Profile;
import com.JPARelationship.JPA.Relationship.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    @Transactional
    public Profile createprofile(Profile profile){
        return profileRepository.save(profile);
    }

    @Transactional
    public Profile findbyid(int profile_id){
        return profileRepository.find(profile_id);
    }
}
