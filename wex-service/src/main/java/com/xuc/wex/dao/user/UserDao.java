package com.xuc.wex.dao.user;

import com.xuc.wex.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service
public interface UserDao {
    public int insertUser(User user);
    public int updateUserByIdcardno(User user);
    public User findUserByIdcardno(User user);
    public List<User> findUserList(User user);
}
