package com.guleni.project.service;

import com.guleni.project.entity.Issue;
import com.guleni.project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user);
    User getById(Long id);
    Page<User> getAllIssuePageable(Pageable page);
}
