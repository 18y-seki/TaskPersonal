package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.entity.SelectForm;

public interface SelectService {
	public List<Review> find(SelectForm form);
	public Review findById(Integer id);
	public void delete(Integer id);
}
