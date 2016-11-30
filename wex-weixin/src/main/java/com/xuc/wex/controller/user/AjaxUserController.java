package com.xuc.wex.controller.user;

import com.xuc.wex.common.util.encode.EncodeUtil;
import com.xuc.wex.model.coach.Coach;
import com.xuc.wex.model.team.Team;
import com.xuc.wex.model.user.User;
import com.xuc.wex.model.usercoach.UserCoach;
import com.xuc.wex.model.userteam.UserTeam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wx/user")
public class AjaxUserController extends BaseUserController {
    private Logger log = Logger.getLogger(AjaxUserController.class);

    @RequestMapping("forInsertUser")
    public ModelAndView forInsertUser(@ModelAttribute User user) {
        return new ModelAndView("redirect:/register.jsp");
    }

    @RequestMapping("insertUser")
    public void insertUser(@ModelAttribute User user, HttpServletResponse response, HttpServletRequest request) {
//        user.setUsername(EncodeUtil.decodeStr(user.getUsername()));
        log.info("解码前："+user.getUsername());
        try {
            user.setUsername(URLDecoder.decode(user.getUsername(),"UTF-8"));
            log.info("解码结果："+user.getUsername());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setStatus(User.STATUS_NOT_EXIST);
        user.setPassword(EncodeUtil.getMD5For32(user.getPassword()));
        user.setSubject1(User.SUBJECT_STATUS_NOT_EXIST);
        user.setSubject2(User.SUBJECT_STATUS_NOT_EXIST);
        user.setSubject3(User.SUBJECT_STATUS_NOT_EXIST);
        user.setSubject4(User.SUBJECT_STATUS_NOT_EXIST);
        int i = userService.insertUser(user);
        String s = "";
        if (i == 1) {
            s = "{\"status\":1,\"message\":\"注册成功\"}";
            log.info("注册成功");
            outWriteUTF8(response, s);
            return;
        } else {
            s = "{\"status\":2,\"message\":\"注册失败,请认真填写注册信息\"}";
            log.info("注册失败");
            outWriteUTF8(response, s);
            return;
        }
    }

    @RequestMapping("forUpdateUserBytime")
    public ModelAndView forUpdateUserBytime(@RequestParam(value = "idcardno", required = false, defaultValue = "") String idcardno,
                                            Coach coach, Team team, HttpServletResponse response, HttpServletRequest request) {
        List<Coach> list = coachService.findCoachList(coach);
        List<Team> teamList = teamService.findTeamList(team);
        ModelAndView model = new ModelAndView("class/class");
        model.addObject("idno", idcardno);
        model.addObject("clist", list);
        model.addObject("tlist", teamList);
        return model;
    }

    @RequestMapping("forUpdateUserBytimetab")
    public ModelAndView forUpdateUserBytimetab(@RequestParam(value = "idcardno", required = false, defaultValue = "") String idcardno,
                                            Coach coach, Team team, HttpServletResponse response, HttpServletRequest request) {
        List<Coach> list = coachService.findCoachList(coach);
        List<Team> teamList = teamService.findTeamList(team);
        ModelAndView model = new ModelAndView("class/class_tab");
        model.addObject("clist", list);
        model.addObject("tlist", teamList);
        return model;
    }

    @RequestMapping("updateUserBytime")
    public void updateUserBytime(@RequestParam(value = "time", required = false, defaultValue = "") String time,
                                 User user, Coach coach, Team team, HttpServletResponse response, HttpServletRequest request) {
        User user1 = userService.findUserByIdcardno(user);
        if (user1 != null) {

            UserTeam userTeam = new UserTeam();
            userTeam.setUid(user1.getUid());
            userTeam.setTid(team.getTid());
            int j = userTeamService.insertUserTeam(userTeam);
            log.info("ok1");

            UserCoach userCoach = new UserCoach();
            userCoach.setUid(user1.getUid());
            userCoach.setCid(coach.getCid());

            int i = userCoachService.insertUserCoach(userCoach);
            log.info("ok2");

            int n = 0;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = format.parse(time);
                long ti = date.getTime() / 1000;
                user.setEntrydate(ti);
                user.setStatus(User.STATUS_EXIST);
                n = userService.updateUserByIdcardno(user);
                log.info("ok3");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String s = "";
            if (i == 1 && j == 1 && n == 1) {
                s = "{\"status\":1,\"message\":\"绑定完成\"}";
                log.info("绑定成功");
                outWriteUTF8(response, s);
                return;
            } else {
                s = "{\"status\":2,\"message\":\"绑定失败,请认真填写信息\"}";
                log.info("绑定失败");
                outWriteUTF8(response, s);
                return;
            }
        }
    }
}