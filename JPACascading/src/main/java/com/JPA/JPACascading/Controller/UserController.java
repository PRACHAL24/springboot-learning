package com.JPA.JPACascading.Controller;

import com.JPA.JPACascading.Entity.Student;
import com.JPA.JPACascading.Entity.User;
import com.JPA.JPACascading.Service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String>craeteuser(@RequestBody User user){
        userService.create(user);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/sorted")
    public List<User> getsortedstudent(){
        return userService.sortedstudents();
    }

    @GetMapping("/page")
    public Page<User> getpagingstudent(@RequestParam int page,
                                          @RequestParam int size){
        return userService.pagingstudent(page, size);
    }
}
