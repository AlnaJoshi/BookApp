package com.bookapp.model.persistence;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl2 implements BookDao {
	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("from Book").list();
	}

	@Override
	public Book getBookById(int bookId) {
		return (Book) getSession().get(Book.class, bookId);
	}

	@Override
	public Book addBook(Book book) {
		getSession().save(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		getSession().update(book);
		return book;
	}

	@Override
	public Book removeBook(int bookId) {
		Book bookToBeDeleted = getBookById(bookId);
		getSession().delete(bookToBeDeleted);
		return bookToBeDeleted;
	}

}
