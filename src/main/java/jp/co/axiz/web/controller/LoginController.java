package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService ls;

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String index(@ModelAttribute("loginForm") LoginForm form, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model, HttpSession session) {
//		String id =form.getUserName();
//		String pass =form.getPassword();

		UserInfo u = ls.find(form);
		if(u==null) {
			model.addAttribute("msg", "IDまたはPASSが間違っています");
		return "login";
		}

		String login = u.getUserName();
		session.setAttribute("login", login);
		return "menu";
	}

	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String register(@ModelAttribute("loginForm") LoginForm form, Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String registerInput(@ModelAttribute("loginForm") LoginForm form, Model model, HttpSession session) {
		String name =form.getUserName();
		String pass =form.getPassword();

		if("".equals(name) ||name==null ||"".equals(pass) ||pass==null) {
			model.addAttribute("msg", "IDまたはPASSが間違っています");
		return "register";
		}

		UserInfo u = ls.register(form);

		String login = u.getUserName();
		session.setAttribute("login", login);
		return "menu";
	}



	@RequestMapping(value = "/logout", method=RequestMethod.POST)
	public String logout(@ModelAttribute("loginForm") LoginForm form, Model model, HttpSession session) {

		session.invalidate();
		return "logout";
	}

}
