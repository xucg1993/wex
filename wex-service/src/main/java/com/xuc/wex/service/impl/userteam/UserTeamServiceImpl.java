package com.xuc.wex.service.impl.userteam;

import com.xuc.wex.dao.userteam.UserTeamDao;
import com.xuc.wex.model.userteam.UserTeam;
import com.xuc.wex.service.interfaces.userteam.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XCG on 2016/11/26.
 */
@Service("userTeamService")
public class UserTeamServiceImpl implements UserTeamService {
    @Autowired
    UserTeamDao userTeamDao;

    @Override
    public int insertUserTeam(UserTeam userTeam) {
        return userTeamDao.insertUserTeam(userTeam);
    }
}
