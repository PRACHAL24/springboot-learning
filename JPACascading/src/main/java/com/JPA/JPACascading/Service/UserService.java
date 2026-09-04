package com.JPA.JPACascading.Service;

import com.JPA.JPACascading.Entity.Student;
import com.JPA.JPACascading.Entity.User;
import com.JPA.JPACascading.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void create(User user){
        userRepository.save(user);
    }

    @Transactional
    public List<User> sortedstudents(){
        Sort sort=Sort.by("age").ascending();
        return userRepository.findAll(sort);

    }
    @Transactional
    public Page<User> pagingstudent(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);

    }
}
