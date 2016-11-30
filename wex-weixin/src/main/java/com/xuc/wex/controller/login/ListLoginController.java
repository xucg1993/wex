package com.xuc.wex.controller.login;

import com.xuc.wex.common.util.encode.EncodeUtil;
import com.xuc.wex.common.util.request.RequestUtil;
import com.xuc.wex.common.util.string.StringUtil;
import com.xuc.wex.model.coach.Coach;
import com.xuc.wex.model.team.Team;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xuc.wex.model.user.User;

import java.util.List;

@Controller
@RequestMapping("/wx/user")
public class ListLoginController extends BaseLoginController {
    private Logger log = Logger.getLogger(ListLoginController.class);

    @RequestMapping("userLogin")
    public ModelAndView userLogin(@ModelAttribute User user, HttpSession session,
                                  HttpServletRequest request, HttpServletResponse response) {
        User ur = loginService.findUser(user);
        if (ur!=null){
        if (isPasswordLogin(ur, user)) {
            setUserToCookie(response, ur.getUid(), ur.getUsername(), RequestUtil.getDomain(request));
            setTokenToCookie(response, getUserToken(ur.getUid()), RequestUtil.getDomain(request));
            log.info("login:userid=" + ur.getUid() + ",username=" + ur.getUsername());
            ModelAndView model = new ModelAndView("redirect:/index.jsp");
//            List<Team> teamList = teamService.findTeamList(new Team());
//            session.setAttribute("teamlist",teamList);
            List<Coach> coachList = coachService.findCoachList(new Coach());
            session.setAttribute("coachlist",coachList);
            session.setAttribute("user",ur);
            return model;
        }
        }
        return new ModelAndView("redirect:/error.jsp");
    }

    @RequestMapping("loginNotice")
    public void loginNotice(@ModelAttribute HttpServletResponse response, HttpServletRequest request){

    }

    @RequestMapping("userLoginOut")
    public ModelAndView userLoginOut(HttpServletRequest request, HttpServletResponse response) {
        clearCookieAdminUser(response, RequestUtil.getDomain(request));
        return new ModelAndView("redirect:/login.jsp");
    }


    private boolean isCookieLogin(int userId, String userName) {
        return userId > 0 && !StringUtil.isNullorEmpty(userName);
    }

    private boolean isPasswordLogin(User ur, User user) {
        if (ur == null || StringUtil.isNullorEmpty(ur.getPassword())) return false;
        return ur.getPassword().equals(EncodeUtil.getMD5For32(user.getPassword()));
    }

    @RequestMapping("findUserForUpdate")
    public ModelAndView findUserForUpdate() {
        int userId = 1;
        return new ModelAndView("login/login_update").addObject("id", userId);
    }
}