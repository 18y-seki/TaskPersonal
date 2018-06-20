package jp.co.axiz.web.controller;

import java.util.List;

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
public class SelectController {

	@Autowired
	SelectService ss;

	@RequestMapping(value="/select", method =RequestMethod.GET)
	public String select(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "select";
	}

	@RequestMapping(value="/list", method =RequestMethod.GET)
	public String list(@ModelAttribute("selectForm") SelectForm form, Model model) {
		List<Review> list = ss.find(form);

		if(list.size()==0) {
			model.addAttribute("msg", "入力されたデータは存在しませんでした");
			return "select";
		}

		model.addAttribute("reviewList", list);
		return "selectResult";
	}

	@RequestMapping(value="/review", method =RequestMethod.GET)
	public String review(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "review";
	}
}
