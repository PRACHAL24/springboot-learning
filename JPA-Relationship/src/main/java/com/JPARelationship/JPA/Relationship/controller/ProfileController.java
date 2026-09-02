package com.JPARelationship.JPA.Relationship.controller;

import com.JPARelationship.JPA.Relationship.model.Department;
import com.JPARelationship.JPA.Relationship.model.Profile;
import com.JPARelationship.JPA.Relationship.model.User;
import com.JPARelationship.JPA.Relationship.service.ProfileService;
import com.JPARelationship.JPA.Relationship.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
private ProfileService profileService;
private UserService userService;

    public ProfileController(ProfileService profileService,UserService userService) {
        this.profileService = profileService;
        this.userService=userService;
    }
@PostMapping
    public ResponseEntity<String>createprofile(@RequestBody Profile profile){
        profileService.createprofile(profile);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/new")
    public ResponseEntity<String>createprofile(@RequestBody Profile profile,@RequestParam String username){

        // 1. Save Profile first
        profileService.createprofile(profile);

        // 2. Create User
        User user = new User();
        user.setName(username);

        // 3. Connect User with Profile
        user.setProfile(profile);
        profile.setUser(user);

        // 4. Save User
        userService.createuser(user);
        return ResponseEntity.ok("DONE");
    }
}
