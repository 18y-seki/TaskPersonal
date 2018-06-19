package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.entity.UserInfo;

public interface LoginService {
	public UserInfo find(LoginForm form);
	public UserInfo register(LoginForm form);
}
