package com.xuc.wex.dao.coach;

import com.xuc.wex.model.coach.Coach;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
public interface CoachDao {
    public List<Coach> findCoachList(Coach coach);
}
