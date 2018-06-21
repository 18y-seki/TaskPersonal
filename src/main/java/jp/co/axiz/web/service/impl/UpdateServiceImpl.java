package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.ReviewDao;
import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	ReviewDao rd;

	@Override
	public void update(Review review) {
		rd.update(review);

	}

}
