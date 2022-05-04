package com.mvs.usersystem.service;

import com.mvs.usersystem.entity.UserEntity;
import com.mvs.usersystem.model.User;
import com.mvs.usersystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        var userEntities = userRepository.findAll();
        List<User> users = userEntities
                    .stream()
                    .map(userEntity -> new User(
                            userEntity.getId(),
                            userEntity.getFirstName(),
                            userEntity.getLastName(),
                            userEntity.getEmail()
                    ))
                    .collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserById(Long id) {
        var userEntity =userRepository.findById(id).get();
        var user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        var user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);
        return user;
    }
}
