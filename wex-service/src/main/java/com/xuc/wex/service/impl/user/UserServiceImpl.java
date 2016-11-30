package com.xuc.wex.service.impl.user;

import com.xuc.wex.dao.user.UserDao;
import com.xuc.wex.model.user.User;
import com.xuc.wex.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUserByIdcardno(User user) {
        return userDao.updateUserByIdcardno(user);
    }

    @Override
    public User findUserByIdcardno(User user) {
        return userDao.findUserByIdcardno(user);
    }

    @Override
    public List<User> findUserList(User user) {
        return userDao.findUserList(user);
    }
}
