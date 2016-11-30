package com.xuc.wex.controller.coach;

import com.xuc.wex.controller.BaseAdminController;
import com.xuc.wex.service.interfaces.coach.CoachService;
import com.xuc.wex.service.interfaces.user.UserService;
import com.xuc.wex.service.interfaces.usercoach.UserCoachService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by XCG on 2016/11/28.
 */
public class BaseCoachController extends BaseAdminController {
    @Autowired
   protected CoachService coachService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected UserCoachService userCoachService;
}
