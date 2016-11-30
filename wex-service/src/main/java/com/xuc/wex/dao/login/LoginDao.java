package com.xuc.wex.dao.login;

import com.xuc.wex.model.user.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginDao {
    public User findUser(User user);

}
