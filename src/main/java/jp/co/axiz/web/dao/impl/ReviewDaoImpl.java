package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.ReviewDao;
import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.entity.SelectForm;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SQL_SELECT_ALL = "SELECT * FROM review ORDER BY review_id";
	private static final String SQL_SELECT_BOOK = "SELECT * FROM review WHERE book_name = ?";
	private static final String SQL_SELECT_AUTHOR = "SELECT * FROM review WHERE book_author = ?";
	private static final String SQL_SELECT_USER = "SELECT * FROM review WHERE review_user = ?";
	private static final String SQL_SELECT_BOOK_AUTHOR = "SELECT * FROM review WHERE book_name = ? AND book_author = ?";
	private static final String SQL_SELECT_BOOK_USER = "SELECT * FROM review WHERE book_name = ? AND review_user = ?";
	private static final String SQL_SELECT_AUTHOR_USER = "SELECT * FROM review WHERE book_author = ? AND review_user = ?";
	private static final String SQL_SELECT_BOOK_AUTHOR_USER = "SELECT * FROM review WHERE book_name = ? AND book_author = ? AND review_user = ?";


	@Override
	public List<Review> findAll() {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_ALL,
				new BeanPropertyRowMapper<Review>(Review.class));

		return list;
	}

	@Override
	public List<Review> find(SelectForm form) {
		String book = form.getBookName();
		String author = form.getBookAuthor();
		String user = form.getReviewUser();

		boolean isBook = !("".equals(book));
		boolean isAuthor = !("".equals(author));
		boolean isUser = !("".equals(user));

		List<Review> list = new ArrayList<Review>();
		if(isBook && isAuthor && isUser) {
			list = findByBookAuthorUser(book, author, user);
		}else if(isBook && isAuthor) {
			list = findByBookAuthor(book, author);
		}else if(isBook && isUser) {
			list = findByBookUser(book, user);
		}else if(isAuthor && isUser) {
			list = findByAuthorUser(author, user);
		}else if(isBook) {
			list = findByBook(book);
		}else if(isAuthor) {
			list = findByAuthor(author);
		}else if(isUser) {
			list = findByUser(user);
		}else {
			list = findAll();
		}

		return list;
	}

	@Override
	public List<Review> findByBook(String book) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_BOOK,
				new BeanPropertyRowMapper<Review>(Review.class),
				book);

		return list;
	}

	@Override
	public List<Review> findByAuthor(String author) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_AUTHOR,
				new BeanPropertyRowMapper<Review>(Review.class),
				author);

		return list;
	}

	@Override
	public List<Review> findByUser(String user) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_USER,
				new BeanPropertyRowMapper<Review>(Review.class),
				user);

		return list;
	}

	@Override
	public List<Review> findByBookAuthor(String book, String author) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_BOOK_AUTHOR,
				new BeanPropertyRowMapper<Review>(Review.class),
				book, author);

		return list;
	}

	@Override
	public List<Review> findByBookUser(String book, String user) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_BOOK_USER,
				new BeanPropertyRowMapper<Review>(Review.class),
				book, user);

		return list;
	}

	@Override
	public List<Review> findByAuthorUser(String author, String user) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_AUTHOR_USER,
				new BeanPropertyRowMapper<Review>(Review.class),
				author, user);

		return list;
	}

	@Override
	public List<Review> findByBookAuthorUser(String book, String author, String user) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_BOOK_AUTHOR_USER,
				new BeanPropertyRowMapper<Review>(Review.class),
				book, author, user);

		return list;
	}

	@Override
	public void post(SelectForm form) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
