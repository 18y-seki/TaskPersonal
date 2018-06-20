package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.service.SelectService;

@Controller
public class DeleteController {

	@Autowired
	SelectService ss;

	@RequestMapping(value="/delete", method =RequestMethod.GET)
	public String delete(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "delete";
	}

	@RequestMapping(value="/delete", method =RequestMethod.POST)
	public String deleteResult(@ModelAttribute("selectForm") SelectForm form, Model model, HttpSession session) {
		Review review = (Review)session.getAttribute("review");
		Integer id = review.getReviewId();

		ss.delete(id);
		session.removeAttribute("review");
		return "deleteResult";
	}
}
