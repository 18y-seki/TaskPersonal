package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {
	@Autowired
	UpdateService us;

	@RequestMapping(value="/update", method =RequestMethod.GET)
	public String update(@ModelAttribute("updateForm") Review review, Model model, HttpSession session) {
		Review rereview = (Review)session.getAttribute("review");

		review.setReviewId(rereview.getReviewId());
		review.setBookName(rereview.getBookName());
		review.setBookAuthor(rereview.getBookAuthor());
		review.setReviewText(rereview.getReviewText());

		return "updateInput";
	}

	@RequestMapping(value="/updateInput", method =RequestMethod.POST)
	public String updateInput(@ModelAttribute("updateForm") Review review, Model model, HttpSession session) {

		return "updateConfirm";
	}

	@RequestMapping(value="/updateResult", method =RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("updateForm") Review review, Model model, HttpSession session) {

		us.update(review);
		session.removeAttribute("review");
		return "updateResult";
	}
}
