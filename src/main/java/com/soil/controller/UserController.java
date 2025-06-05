package com.soil.controller;

import com.soil.common.Result;
import com.soil.entity.User;
import com.soil.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 添加用户
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody User user) {
        return Result.success(userService.add(user));
    }

    /**
     * 更新用户
     */
    @PutMapping("/update")
    public Result<Boolean> update(@RequestBody User user) {
        return Result.success(userService.update(user));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(userService.delete(id));
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/get/{id}")
    public Result<User> get(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/list")
    public Result<List<User>> list() {
        return Result.success(userService.list());
    }
    
    /**
     * 根据条件查询用户列表
     */
    @GetMapping("/listByCondition")
    public Result<List<User>> listByCondition(User user) {
        return Result.success(userService.listByCondition(user));
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户名或密码错误");
    }
} 