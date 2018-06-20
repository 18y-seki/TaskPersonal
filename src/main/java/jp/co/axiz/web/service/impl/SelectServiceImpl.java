package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.ReviewDao;
import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService{
	@Autowired
	ReviewDao rd;

	@Override
	public List<Review> find(SelectForm form) {

		return rd.find(form);

	}

	@Override
	public Review findById(Integer id) {
		return rd.findById(id);
	}

	@Override
	public void delete(Integer id) {
		rd.delete(id);
	}
}
