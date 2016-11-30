package com.xuc.wex.dao.usercoach;

import com.xuc.wex.model.usercoach.UserCoach;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service
public interface UserCoachDao {
    public int insertUserCoach(UserCoach userCoach);
    public List<UserCoach> findUserCoachList(UserCoach userCoach);
}
