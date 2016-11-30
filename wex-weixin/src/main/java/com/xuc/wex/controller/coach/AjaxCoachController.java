package com.xuc.wex.controller.coach;

import com.xuc.wex.common.util.Json.JsonUtil;
import com.xuc.wex.controller.user.ModifyUserController;
import com.xuc.wex.model.user.User;
import com.xuc.wex.model.usercoach.UserCoach;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by XCG on 2016/11/28.
 */
@Controller
@RequestMapping("/wx/coach")
public class AjaxCoachController extends BaseCoachController {
    private Logger log = Logger.getLogger(AjaxCoachController.class);
    @RequestMapping("findUserCoachList")
    public void findUserCoachList(@ModelAttribute UserCoach userCoach, HttpServletRequest request, HttpServletResponse response){
        userCoach.setCid(1);
        List<UserCoach> userCoachList = userCoachService.findUserCoachList(userCoach);
        ModelAndView model = new ModelAndView("user/user_list");
        model.addObject("userlist",userCoachList);
        log.info("userCoach地址:"+userCoachList);
        outWriteUTF8(response, JsonUtil.toJson(userCoachList));
    }
}
