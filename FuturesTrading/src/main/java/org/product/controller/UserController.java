package org.product.controller;

import org.product.domain.User;
import org.product.reg.GetMessage;
import org.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final String LOGIN="login";
    private static final String REGISTER="register";
    private static final String JUMP="jump";
    private static final String OK="productList";

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session){

        String passwd=request.getParameter("passwd");
        String phone=request.getParameter("phone");
        Object o=userService.findById(phone);
        if (o instanceof User){
            if (((User) o).getPhone().equals(phone.trim()) && ((User) o).getPasswd().equals(passwd.trim())){
                session.setAttribute("str","true");
                return OK;
            }else {
                session.setAttribute("str","false");
            }
        }else {
           session.setAttribute("str","null");
        }
        return LOGIN;
    }

    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request, HttpSession session){

        String phone=request.getParameter("phone");
        String passwd=request.getParameter("passwd");
        String name=request.getParameter("name");
        boolean b=GetMessage.decide(phone);
        if (b) {
            User user=new User();
            user.setPasswd(passwd.trim());
            user.setPhone(phone.trim());
            user.setUsername(name.trim());
            int count=userService.addUser(user);
            if (1==count){
                session.setAttribute("name",name);
                return OK;
            }
        }
         session.setAttribute("str","false");
         return REGISTER;
    }

    @RequestMapping(value = "/getmessage")
    public String message(@RequestParam(value = "phone")String phone,ModelMap map){
        Object o=userService.findById(phone);
        if(o==null){
            String s=GetMessage.getResult(phone);
            map.addAttribute("str","true");
            return REGISTER;
        }
        map.addAttribute("str","false");
        return REGISTER;
    }
}
