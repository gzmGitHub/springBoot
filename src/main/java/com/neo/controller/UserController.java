package com.neo.controller;

import com.neo.Properties.ApplicationProperties;
import com.neo.model.User;
import com.neo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String index(User user, ModelMap map){
        user = userService.getUser1(user);
        if (user == null) {
            return "index";
        } else {
            map.put("user",user);
            return "welcome";
        }
    }

    @ResponseBody
	@RequestMapping("/getUser")
	public User getUser() {
	    User user = new User();
        user.setUserId("28948");
        user.setId("1");
        //多数据源
		User user11=userService.getUser1(user);
        User user22=userService.getUser2(user);
        User userOut = new User();
        userOut.setUserName(user11.getUserName());
        userOut.setName(user22.getName());
        userOut.setWoCd(user11.getWoCd());
        System.out.println(userOut);
        //日志
        log.warn("输出日志级别");
        //配置文件属性值dfsdf
        log.warn(applicationProperties.getSchemaCrm());
        log.warn(applicationProperties.getModelMap().get("name"));
		return userOut;
	}
}