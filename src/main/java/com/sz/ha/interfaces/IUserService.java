package com.sz.ha.interfaces;

import com.sz.ha.models.User;

import java.util.List;

/**
 * Created by lenovo on 03.05.2018.
 */
public interface IUserService {
    User create(User user);
    User read(Long id);
    List<User> getAll();
    void delete(Long id);
}
