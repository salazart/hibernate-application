package com.sz.ha.interfaces;

import com.sz.ha.models.User;

/**
 * Created by lenovo on 03.05.2018.
 */
public interface IUser {
    User create(User user);
    User read(Long id);

    void delete(User user);
}
