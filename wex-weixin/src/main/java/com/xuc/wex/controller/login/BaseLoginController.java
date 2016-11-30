package com.xuc.wex.controller.login;


import com.xuc.wex.controller.BaseAdminController;
import com.xuc.wex.service.interfaces.coach.CoachService;
import com.xuc.wex.service.interfaces.login.LoginService;
import com.xuc.wex.service.interfaces.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseLoginController extends BaseAdminController {
    @Autowired
    protected LoginService loginService;
    @Autowired
    protected TeamService teamService;
    @Autowired
    protected CoachService coachService;

}
