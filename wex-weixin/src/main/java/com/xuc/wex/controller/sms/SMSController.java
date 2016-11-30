package com.xuc.wex.controller.sms;

import com.xuc.wex.common.controller.BaseController;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/wx/sms")
public class SMSController extends BaseController {
    @RequestMapping("smsNotification")
    public void smsNotification(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                                @RequestParam(value = "time", required = false, defaultValue = "") String time,
                                @RequestParam(value = "coachname", required = false, defaultValue = "") String coachname,
                                @RequestParam(value = "mobile", required = false, defaultValue = "") String mobile, HttpServletResponse response, HttpServletRequest request){
        String s = sms(username,time,coachname,mobile);
        outWriteUTF8(response, s);
        return;
    }


   public String sms(String username,String time,String coachname,String mobile){
       String host = "http://sms.market.alicloudapi.com";
       String path = "/singleSendSms";
       String method = "GET";
       Map<String, String> headers = new HashMap<String, String>();
       //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
       headers.put("Authorization", "APPCODE 01babe7ba287450fbbe7b1e2205d9c8d");
       Map<String, String> querys = new HashMap<String, String>();
       querys.put("ParamString", "{\"name\":\""+username+"\",\"time\":\""+time+"\",\"coach\":\""+coachname+"\"}");
       querys.put("RecNum", mobile);
       querys.put("SignName", "教练通知");
       querys.put("TemplateCode", "SMS_30040231");
       try {
           HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
           System.out.println(response.toString());
           //获取response的body
           System.out.println(EntityUtils.toString(response.getEntity()));
           return EntityUtils.toString(response.getEntity());
       } catch (Exception e) {
           e.printStackTrace();
       }
            return "null";
   }
}
