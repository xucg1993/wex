package com.xuc.wex.controller;


import com.xuc.wex.common.controller.BaseController;
import com.xuc.wex.common.util.constant.Constant;
import com.xuc.wex.common.util.encode.EncodeUtil;
import com.xuc.wex.common.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseAdminController extends BaseController {
    @Autowired
    protected Properties systemConfig;
    public String getUserToken(String userId) {
        return EncodeUtil.getMD5For32(userId + Constant.TOKEN_SIGN);
    }

    public String getUserToken(int userId) {
        return getUserToken(String.valueOf(userId));
    }

    public String getConfigProperty(String key, String defaultValue) {
        return systemConfig.getProperty(key, defaultValue);
    }
    public ModelAndView ajaxDoneSuccess(String message) {
        return ajaxDone(200, message, "", "", "");
    }

    public ModelAndView ajaxDoneSuccess(String message, String navTabId) {
        return ajaxDone(200, message, navTabId, "", "");
    }

    public ModelAndView ajaxDoneSuccessAndUrl(String message, String url) {
        return ajaxDone(200, message, "", url, "forward");
    }

    public ModelAndView ajaxDoneSuccessAndUrl(String message, String navTabId, String url) {
        return ajaxDone(200, message, navTabId, url, "forward");
    }

    public ModelAndView ajaxDoneSuccessClose(String message) {
        return ajaxDone(200, message, "", "", "closeCurrent");
    }

    public ModelAndView ajaxDoneSuccessCloseAndNavTabId(String message, String navTabId) {
        return ajaxDone(200, message, navTabId, "", "closeCurrent");
    }

    public ModelAndView ajaxDoneSuccessAndNavTabId(String message, String navTabId){
        return ajaxDone(200, message, navTabId, "", "");
    }

    public ModelAndView ajaxDoneSuccessCloseAndUrl(String message, String url) {
        return ajaxDone(200, message, "", url, "closeCurrent");
    }

    public ModelAndView ajaxDoneError(String message) {
        return ajaxDone(300, message, "", "", "");
    }

    public ModelAndView ajaxDone(int statusCode, String message, String navTabId, String forwardUrl, String callbackType) {
        ModelAndView model = new ModelAndView("ajaxDone");
        model.addObject("statusCode", statusCode);
        model.addObject("message", message);
        model.addObject("navTabId", navTabId);
        model.addObject("forwardUrl", forwardUrl);
        model.addObject("callbackType", callbackType);
        return model;
    }


    protected ModelAndView ajaxDoneAuto(String message) {
        if (StringUtil.isContains(message, "success"))
            return ajaxDoneSuccess(systemConfig.getProperty(message));
        else
            return ajaxDoneError(systemConfig.getProperty(message));
    }

    protected String getImagePrefixPath(){
        return getProperty("portal.image.path");
    }

    protected String getImagePrefixUrl(){
        return getProperty("portal.image.url");
    }

    public String getProperty(String key){
        return systemConfig.getProperty(key);
    }

    public boolean checkImageName(String imageName){
        if (imageName.length() < 5) return false;
        String suffix = imageName.substring(imageName.length() - 3);
        if (suffix.equals("PNG") || suffix.equals("png") || suffix.equals("JPG") || suffix.equals("jpg")) {
            return true;
        }
        return false;
    }
    // 多个根目录，用逗号隔开
    public String getRootDepts() {
        return getProperty(Constant.DEPT_ID);
    }

}
