package com.base.issueManagement.service.impl;

import com.base.issueManagement.repository.UserRepository;
import com.base.issueManagement.service.UserService;
import com.base.issueManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    private  final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User save(User user) {
        if(user.getEmail()==null){
           new IllegalArgumentException("user email cannot be null");
        }
        user=userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUserName(username);
    }


}
