package com.eyric.app.service.impl;


import com.eyric.app.dao.UserDao;
import com.eyric.app.entity.User;
import com.eyric.app.service.UserService;
import com.eyric.base.Filter;
import com.eyric.base.dao.BaseDao;
import com.eyric.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("userServiceImpl")

public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Resource(name = "userDaoImpl")
    public void setBaseDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }

    public User findUserByUname(String uname) {
        if (uname == null || "".equals(uname)) {
            return null;
        }

        List<User> users = userDao.findList(null, null, Arrays.asList(Filter.eq("uname", uname)), null);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public List<User> findUserByBirth(Date birth) {
        if (birth == null || "".equals(birth)) {
            return null;
        }
        List<User> users = userDao.findList(null, null, Arrays.asList(Filter.eq("birth", birth)), null);
        if (users.size() > 0) {
            return users;
        }
        return null;
    }

    @Transactional
    public Boolean saveUser(User user) {
        userDao.persist(user);
        userDao.flush();
        List<User> users = userDao.findList(null, null, Arrays.asList(Filter.eq("uname", user.getUname())), null);
        return users.size() > 0;
    }


}
