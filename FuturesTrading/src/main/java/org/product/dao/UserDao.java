package org.product.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.product.domain.User;

import java.util.List;
public interface UserDao {
    List findAll();
    Object findById(@Param("phone") String phone);
    int addUser(@Param("User") User user);
}
