package com.xuc.wex.controller.user;

import com.xuc.wex.common.util.date.DateUtil;
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

/**
 * Created by XCG on 2016/11/26.
 */
@Controller
@RequestMapping("/wx/user")
public class ModifyUserController extends BaseUserController {

}
