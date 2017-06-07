package com.eyric.app.dao.impl;


import com.eyric.app.dao.UserDao;
import com.eyric.base.dao.impl.BaseDaoImpl;
import com.eyric.app.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

}
