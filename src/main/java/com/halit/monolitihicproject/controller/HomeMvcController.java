package com.halit.monolitihicproject.controller;

import com.halit.monolitihicproject.repository.entity.HomeModel;
import com.halit.monolitihicproject.repository.entity.User;
import com.halit.monolitihicproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Optional;

import static com.halit.monolitihicproject.constants.EndPoints.*;

@Controller
@RequestMapping(VERSION+API+WEB+HOME)
@RequiredArgsConstructor
public class HomeMvcController {
    private final UserService userService;
    @GetMapping(HOMEPAGEMALE)
    public ModelAndView home1(Long id) {
        Optional<User> user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        HomeModel homeModel = HomeModel.builder()
                .photoList(Arrays.asList(
                        "https://images.unsplash.com/photo-1523264629844-40dd6bf17c2b?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=c7ff0286ae72f4dfed2bfee5fc8a53fe&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1494719019271-7bfff81660d2?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=74496a215491b1529d6702f146901970&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523359366921-4c14294ff5bd?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6010b5b8bc1f6916d652fb48b9e039a6&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523282310917-57c94215f54f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=9562049492c4c1c28014be6b4d372fa8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523279719030-9806e8392152?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=83ec2854d04d0f08312dec44bf645e2d&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523264629844-40dd6bf17c2b?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=c7ff0286ae72f4dfed2bfee5fc8a53fe&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523133892278-d324fa6b326b?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=1ba6e3178a138e7dcbdd241499378449&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523326350151-473dc3e5215b?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=aa765415933dbcd55bc27e0726bfd1f5&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1523086686757-5cda47c78492?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=0da31c54dc3e5fd28da519b2cde2c98d&auto=format&fit=crop&w=500&q=60"
                        ))
                .nameSurname(user.get().getName()+" "+user.get().getSurname())
                .backgroundColor("background:lightblue")
                .build();
        modelAndView.addObject("model",homeModel);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @GetMapping(HOMEPAGEFEMALE)
    public ModelAndView home2(Long id) {
        Optional<User> user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        HomeModel homeModel = HomeModel.builder()
                .photoList(Arrays.asList(
                        "https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/87452/flowers-background-butterflies-beautiful-87452.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/46216/sunflower-flowers-bright-yellow-46216.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/39517/rose-flower-blossom-bloom-39517.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/1408221/pexels-photo-1408221.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/268261/pexels-photo-268261.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/67857/daisy-flower-spring-marguerite-67857.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/992734/pexels-photo-992734.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60",
                        "https://images.pexels.com/photos/158063/bellingrath-gardens-alabama-landscape-scenic-158063.jpeg?auto=compress&cs=tinysrgb&w=1600auto=format&fit=crop&w=500&q=60"
                ))
                .nameSurname(user.get().getName()+" "+user.get().getSurname())
                .backgroundColor("background:pink")
                .build();
        modelAndView.addObject("model",homeModel);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @GetMapping("/homepage")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
