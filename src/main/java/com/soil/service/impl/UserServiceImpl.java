package com.soil.service.impl;

import com.soil.entity.User;
import com.soil.mapper.UserMapper;
import com.soil.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean add(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> list() {
        return userMapper.selectList();
    }

    @Override
    public List<User> listByCondition(User user) {
        return userMapper.selectListByCondition(user);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.selectByUsernameAndPassword(username, password);
    }
} 