package jp.co.axiz.web.dao;

import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.entity.UserInfo;

public interface UserInfoDao {
public UserInfo find(LoginForm form);
public UserInfo findMax();
public void register(LoginForm form);
}
