package com.xuc.wex.service.impl.team;

import com.xuc.wex.dao.team.TeamDao;
import com.xuc.wex.model.team.Team;
import com.xuc.wex.service.interfaces.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamDao teamDao;

    @Override
    public List<Team> findTeamList(Team team) {
        return teamDao.findTeamList(team);
    }
}
