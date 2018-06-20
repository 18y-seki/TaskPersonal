package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.Review;
import jp.co.axiz.web.entity.SelectForm;

public interface ReviewDao {
	public List<Review> findAll();

	public List<Review> find(SelectForm form);

	public List<Review> findByBook(String book);
	public List<Review> findByAuthor(String author);
	public List<Review> findByUser(String user);
	public List<Review> findByBookAuthor(String book, String author);
	public List<Review> findByBookUser(String book, String user);
	public List<Review> findByAuthorUser(String author, String user);
	public List<Review> findByBookAuthorUser(String book, String author, String user);


	public void post(SelectForm form);
}
