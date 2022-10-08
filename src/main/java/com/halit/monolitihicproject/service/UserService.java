package com.halit.monolitihicproject.service;

import com.halit.monolitihicproject.dto.request.UserCreateRequestDto;
import com.halit.monolitihicproject.dto.response.UserCreateResponseDto;
import com.halit.monolitihicproject.mapper.UserMapper;
import com.halit.monolitihicproject.repository.IUserRepository;
import com.halit.monolitihicproject.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserCreateResponseDto saveDto(User user) {
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserCreateResponseDto(user);
    }



    public UserCreateResponseDto saveWithRequestDto(UserCreateRequestDto dto) {
        User user = UserMapper.INSTANCE.toUser(dto);
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserCreateResponseDto(user);


    }

    public Optional<User> login(String email, String password) {
        Optional<User> user = userRepository.findOptionalByEmailAndPassword(email, password);
        if (user.isEmpty()) {
            System.out.println("Kullanıcı Bulunamadı");
            return Optional.ofNullable(null);
        }
        return user;
    }

    public Optional<User> findOptionalByEmailAndPassword(String email, String password){
        return userRepository.findOptionalByEmailAndPassword(email, password);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findOptionalById(id);
    }
}