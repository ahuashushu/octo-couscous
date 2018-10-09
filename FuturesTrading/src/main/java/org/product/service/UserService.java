package org.product.service;

import org.product.domain.User;

import java.util.List;

public interface UserService {

    List findAll();
    int addUser(User user);
    Object findById(String phone);
}
