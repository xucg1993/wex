package com.xuc.wex.service.interfaces.usercoach;

import com.xuc.wex.dao.usercoach.UserCoachDao;
import com.xuc.wex.model.usercoach.UserCoach;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service
public interface UserCoachService {

    public int insertUserCoach(UserCoach userCoach);

    public List<UserCoach> findUserCoachList(UserCoach userCoach);
}
