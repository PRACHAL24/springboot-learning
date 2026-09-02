package com.JPARelationship.JPA.Relationship.controller;

import com.JPARelationship.JPA.Relationship.model.Profile;
import com.JPARelationship.JPA.Relationship.model.User;
import com.JPARelationship.JPA.Relationship.service.ProfileService;
import com.JPARelationship.JPA.Relationship.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private ProfileService profileService;

    public UserController(UserService userService,ProfileService profileService) {
        this.userService = userService;
        this.profileService= profileService;
    }

    @PostMapping
    public ResponseEntity<String>createUser(@RequestBody User user, @RequestParam int profile_id){
     Profile profile= profileService.findbyid(profile_id);
     user.setProfile(profile);
     userService.createuser(user);
     return ResponseEntity.ok("DONE");
    }
}
