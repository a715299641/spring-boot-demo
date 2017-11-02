package com.example.ceshi.ceshi01.controller;



import com.example.ceshi.ceshi01.entity.User;
import com.example.ceshi.ceshi01.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class UserController  {

    @Autowired
    private UserService userService;
//
//    @Autowired
//    private MovieService movieService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @ApiOperation(value = "demo01获取用户", httpMethod = "GET", tags = {"user"})
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query",dataType = "Integer")
    })
    @GetMapping(value = "/ceshi01/user")
    public User getUserById(@RequestParam("id") Integer id){
        User user = userService.getUserById(id);

        return user;
    }
}
