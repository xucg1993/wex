package com.xuc.wex.service.interfaces.login;

import com.xuc.wex.model.user.User;
import org.springframework.stereotype.Service;

/**
 * Created by XCG on 2016/11/26.
 */
@Service
public interface LoginService {
    public User findUser(User user);
}
