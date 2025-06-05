package com.soil.mapper;

import com.soil.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper接口
 */
@Mapper
public interface UserMapper {

    /**
     * 添加用户
     */
    int insert(User user);

    /**
     * 更新用户
     */
    int update(User user);

    /**
     * 根据ID删除用户
     */
    int deleteById(Long id);

    /**
     * 根据ID查询用户
     */
    User selectById(Long id);

    /**
     * 根据用户名查询用户
     */
    User selectByUsername(String username);

    /**
     * 查询所有用户
     */
    List<User> selectList();

    /**
     * 根据条件查询用户列表
     */
    List<User> selectListByCondition(User user);

    /**
     * 根据用户名和密码查询用户（用于登录）
     */
    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
} 