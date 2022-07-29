package com.anisa.model.service;

import com.anisa.model.da.UserDa;
import com.anisa.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private UserDa userDa;

    public UserService() {

        userDa=new UserDa();
    }

    public void inserUser(User user)
    {
        userDa.insertUser(user);
    }

    public List<User> showUser(){
        List<User> users=userDa.getUser();
        return  users.stream().collect(Collectors.toList());
    }

    public List<User> showMan(){
        List<User> users=userDa.getMan();
        return users.stream().collect(Collectors.toList());
    }


}
