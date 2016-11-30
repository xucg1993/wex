package com.xuc.wex.service.impl.login;

import com.xuc.wex.dao.login.LoginDao;
import com.xuc.wex.model.user.User;
import com.xuc.wex.service.interfaces.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XCG on 2016/11/26.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;
    @Override
    public User findUser(User user) {
        return loginDao.findUser(user);
    }
}
