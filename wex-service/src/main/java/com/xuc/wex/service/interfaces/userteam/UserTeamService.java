package com.xuc.wex.service.interfaces.userteam;

import com.xuc.wex.model.userteam.UserTeam;
import org.springframework.stereotype.Service;

/**
 * Created by XCG on 2016/11/26.
 */
@Service
public interface UserTeamService {
    public int insertUserTeam(UserTeam userTeam);
}
