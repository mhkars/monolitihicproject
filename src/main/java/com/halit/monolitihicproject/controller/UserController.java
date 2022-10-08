package com.halit.monolitihicproject.controller;

import com.halit.monolitihicproject.dto.request.UserCreateRequestDto;
import com.halit.monolitihicproject.dto.response.UserCreateResponseDto;
import com.halit.monolitihicproject.repository.entity.User;
import com.halit.monolitihicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.halit.monolitihicproject.constants.EndPoints.*;

@Controller
@RequestMapping(VERSION+API+WEB+USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;



    @GetMapping(SAVEWITHREQUEST)
    public ResponseEntity<UserCreateResponseDto> save(UserCreateRequestDto dto){

        return ResponseEntity.ok(userService.saveWithRequestDto(dto));



    }
    @GetMapping(LOGIN)
    public ResponseEntity<Optional<User>> login(String email, String password){
        return  ResponseEntity.ok(userService.login(email,password));
    }

}
