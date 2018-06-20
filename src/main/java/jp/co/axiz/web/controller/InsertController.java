package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.InsertForm;
import jp.co.axiz.web.service.InsertService;

@Controller
public class InsertController {

	@Autowired
	InsertService is;

	@RequestMapping(value="/insert", method =RequestMethod.GET)
	public String insert(@ModelAttribute("insertForm") InsertForm form, Model model) {
		return "insert";
	}

	@RequestMapping(value="/insert", method =RequestMethod.POST)
	public String insertInput(@ModelAttribute("insertForm") InsertForm form, Model model) {
		String book = form.getBookName();
		String author= form.getBookAuthor();
		String text = form.getReviewText();
		if(("".equals(book)) || ("".equals(author)) || ("".equals(text))) {
			model.addAttribute("msg", "必須項目を入力してください");
			return "insert";
		}
		model.addAttribute("form", form);
		return "insertConfirm";
	}

	@RequestMapping(value="/insertConfirm", method =RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("insertForm") InsertForm form, Model model, HttpSession session) {
		String user = (String)session.getAttribute("login");
		form.setReviewUser(user);
		is.insert(form);
		return "insertResult";
	}

}
