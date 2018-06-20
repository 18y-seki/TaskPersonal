package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.ReviewDao;
import jp.co.axiz.web.entity.InsertForm;
import jp.co.axiz.web.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

	@Autowired
	ReviewDao rd;

	@Override
	public void insert(InsertForm form) {
		rd.post(form);
	}

}
