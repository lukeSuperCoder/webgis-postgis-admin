package com.soil.service;

import com.soil.entity.User;
import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {

    /**
     * 添加用户
     */
    boolean add(User user);

    /**
     * 更新用户
     */
    boolean update(User user);

    /**
     * 根据ID删除用户
     */
    boolean delete(Long id);

    /**
     * 根据ID查询用户
     */
    User getById(Long id);

    /**
     * 根据用户名查询用户
     */
    User getByUsername(String username);

    /**
     * 查询所有用户
     */
    List<User> list();

    /**
     * 根据条件查询用户列表
     */
    List<User> listByCondition(User user);

    /**
     * 用户登录
     */
    User login(String username, String password);
} 