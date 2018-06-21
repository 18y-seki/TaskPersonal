package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.ReviewDao;
import jp.co.axiz.web.entity.InsertForm;
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

	private static final String SQL_SELECT_ID = "SELECT * FROM review WHERE review_id = ?";

	private static final String SQL_INSERT = "INSERT INTO review (review_user, book_name, book_author, review_text) VALUES (?, ?, ?, ?);";

	private static final String SQL_UPDATE = "UPDATE review SET book_name = ?, book_author = ?, review_text = ? WHERE review_id = ?";

	private static final String SQL_DELETE = "DELETE FROM review WHERE review_id = ?";

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
	public Review findById(Integer id) {
		List<Review> list = jdbcTemplate.query(SQL_SELECT_ID,
				new BeanPropertyRowMapper<Review>(Review.class),
				id);

		return list.get(0);
	}

	@Override
	public void post(InsertForm form) {
		jdbcTemplate.update(SQL_INSERT,
				form.getReviewUser(),
				form.getBookName(),
				form.getBookAuthor(),
				form.getReviewText());

	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update(SQL_DELETE,
				id);
	}

	@Override
	public void update(Review review) {
		jdbcTemplate.update(SQL_UPDATE,
				review.getBookName(),
				review.getBookAuthor(),
				review.getReviewText(),
				review.getReviewId());
	}

}
