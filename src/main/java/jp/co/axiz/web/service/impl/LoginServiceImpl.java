package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserInfoDao ud;

	public UserInfo find(LoginForm form) {
		return ud.find(form);
	}

	public UserInfo register(LoginForm form) {
		ud.register(form);

		return ud.findMax();
	}
}
