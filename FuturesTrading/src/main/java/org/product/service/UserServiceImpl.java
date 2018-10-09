package org.product.service;

import org.product.dao.UserDao;
import org.product.domain.User;
import org.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List findAll() {
        return userDao.findAll();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Object findById(String phone) {
        return userDao.findById(phone);
    }
}
