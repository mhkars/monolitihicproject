package com.halit.monolitihicproject.controller;

import com.halit.monolitihicproject.dto.request.UserCreateRequestDto;
import com.halit.monolitihicproject.repository.entity.EGender;
import com.halit.monolitihicproject.repository.entity.HomeModel;
import com.halit.monolitihicproject.repository.entity.User;
import com.halit.monolitihicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static com.halit.monolitihicproject.constants.EndPoints.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(VERSION+API+WEB+LOGIN)
public class LoginMvcController {

    private  final UserService userService;

    @GetMapping(LOGINPAGE)
    public ModelAndView login(){
        String email= "email";
        String password= "password";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("email",email);
        modelAndView.addObject("password",password);
        return modelAndView;
    }

    @PostMapping(DOLOGIN)
    public ModelAndView doLogin(String email,String password){
        Optional<User> user = userService.findOptionalByEmailAndPassword(email,password);
        ModelAndView modelAndView = new ModelAndView();
        if(user.isPresent()){
            if (user.get().getGender().equals(EGender.MALE)){
                System.out.println("Kullanıcıadı veya şifre doğru");
                modelAndView.addObject("id", user.get().getId());
                modelAndView.setViewName("redirect:/mkv/api/web/home/homepagemale");
                return modelAndView;

            }else{
                System.out.println("Kullanıcıadı veya şifre doğru");
                modelAndView.addObject("id", user.get().getId());
                modelAndView.setViewName("redirect:/mkv/api/web/home/homepagefemale");
                return modelAndView;
            }
        }else{
            System.out.println("Kullanıcıadı veya şifre hatalı");
        }
        return null;
    }


    @GetMapping(REGISTERPAGE)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping(DOREGISTER)
    public ModelAndView doRegister(String name, String surname,
                                   String email, String phoneNumber,
                                   String city, String gender, String birthDate,
                                   String password){
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= null;
        try {
            date1 = formatter1.parse(birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        userService.saveWithRequestDto(
                UserCreateRequestDto.builder()
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .phoneNumber(phoneNumber)
                        .city(city)
                        .birthDate(date1)
                        .gender(gendering(gender))
                        .password(password)
                        .build()
        );
        return new ModelAndView("redirect:loginpage");
    }
    public EGender gendering(String gender){
        if(gender.equals("Male")){
            return EGender.MALE;
        }else{
            return EGender.FEMALE;
        }
    }
    public String dating(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String newDate = dateFormat.format(date);
        return newDate;
    }

}