package com.xuc.wex.service.interfaces.team;

import com.xuc.wex.model.team.Team;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XCG on 2016/11/26.
 */
@Service
public interface TeamService {
    public List<Team> findTeamList(Team team);
}
