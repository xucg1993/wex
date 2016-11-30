package com.xuc.wex.controller.user;

import com.xuc.wex.controller.BaseAdminController;
import com.xuc.wex.service.interfaces.coach.CoachService;
import com.xuc.wex.service.interfaces.team.TeamService;
import com.xuc.wex.service.interfaces.user.UserService;
import com.xuc.wex.service.interfaces.usercoach.UserCoachService;
import com.xuc.wex.service.interfaces.userteam.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by XCG on 2016/11/26.
 */
public class BaseUserController extends BaseAdminController {
    @Autowired
   protected UserService userService;
    @Autowired
    protected CoachService coachService;
    @Autowired
    protected UserCoachService userCoachService;
    @Autowired
    protected UserTeamService userTeamService;
    @Autowired
    protected TeamService teamService;
}
