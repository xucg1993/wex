package com.xuc.wex.service.impl.coach;

import com.xuc.wex.dao.coach.CoachDao;
import com.xuc.wex.model.coach.Coach;
import com.xuc.wex.service.interfaces.coach.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service("coachService")
public class CoachServiceImpl implements CoachService {
    @Autowired
    CoachDao coachDao;
    @Override
    public List<Coach> findCoachList(Coach coach) {
        return coachDao.findCoachList(coach);
    }
}
