package com.eyric.app.service;


import com.eyric.app.entity.User;
import com.eyric.base.service.BaseService;

import java.util.Date;
import java.util.List;

public interface UserService extends BaseService<User,Long>{
    User findUserByUname(String uname);
    List<User> findUserByBirth(Date birth);

    Boolean saveUser(User user);
}
