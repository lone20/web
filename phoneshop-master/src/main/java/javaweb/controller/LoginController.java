package javaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javaweb.Entity.Account;
import javaweb.services.inter.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
    LoginService loginService;

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Request Login.");
        ModelAndView view = new ModelAndView("login/login");
        Account loginBean = new Account();
        view.addObject("loginBean", loginBean);
        logger.info("Open login page.");
        return view;
    }
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("loginBean") Account loginBean) {
        ModelAndView view = null;
        if (loginService.isUser(loginBean.getUsername(), loginBean.getPassword())) {
            request.setAttribute("loggedInUser", loginBean.getUsername());
            view = new ModelAndView("home/index");
        }else if(loginService.isAdmin(loginBean.getUsername(), loginBean.getPassword())) {
        	request.setAttribute("loggedInUser", loginBean.getUsername());
            view = new ModelAndView("admin/admin");
        }else {
            request.setAttribute("message", "Tài khoản hoặc mật khẩu không hợp lệ!");
            view = new ModelAndView("login/login");
        }
        return view;
    }
}
