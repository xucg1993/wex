package com.xuc.wex.service.impl.usercoach;

import com.xuc.wex.dao.usercoach.UserCoachDao;
import com.xuc.wex.model.usercoach.UserCoach;
import com.xuc.wex.service.interfaces.usercoach.UserCoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service("userCoachService")
public class UserCoachServiceImpl implements UserCoachService {
    @Autowired
    UserCoachDao userCoachDao;
    @Override
    public int insertUserCoach(UserCoach userCoach) {
        return userCoachDao.insertUserCoach(userCoach);
    }

    @Override
    public List<UserCoach> findUserCoachList(UserCoach userCoach) {
        return userCoachDao.findUserCoachList(userCoach);
    }
}
