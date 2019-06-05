package com.guleni.project.service.impl;

import com.guleni.project.entity.User;
import com.guleni.project.repository.UserRepository;
import com.guleni.project.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllIssuePageable(Pageable page) {
        return userRepository.findAll(page);
    }
}
