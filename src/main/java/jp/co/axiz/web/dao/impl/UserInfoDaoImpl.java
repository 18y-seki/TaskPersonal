package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.entity.UserInfoMax;

@Repository
public class UserInfoDaoImpl implements UserInfoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_SELECT_ID = "SELECT * FROM user_info WHERE user_id = ?";
	private final String SQL_SELECT_NAME_PASS = "SELECT * FROM user_info WHERE user_name = ? AND password = ?";

	private static final String SQL_SELECT_MAX = "SELECT MAX(user_id) FROM user_info";

	private final String SQL_INSERT = "INSERT INTO user_info(user_name, password) VALUES(?, ?)";

	@Override
	public UserInfo find(LoginForm form) {
		List<UserInfo> list = jdbcTemplate.query(SQL_SELECT_NAME_PASS,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				form.getUserName(),
				form.getPassword());

		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public UserInfo findMax() {
		List<UserInfoMax> list = jdbcTemplate.query(SQL_SELECT_MAX,
				new BeanPropertyRowMapper<UserInfoMax>(UserInfoMax.class));
		UserInfoMax um = list.get(0);

		List<UserInfo> l = jdbcTemplate.query(SQL_SELECT_ID,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
				um.getMax());

		return l.get(0);
	}

	public void register(LoginForm form) {
		jdbcTemplate.update(SQL_INSERT,
				form.getUserName(),
				form.getPassword());
	}
}
