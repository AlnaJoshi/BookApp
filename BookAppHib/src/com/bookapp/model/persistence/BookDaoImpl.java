package com.bookapp.model.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDaoImpl implements BookDao {
	private SessionFactory factory;
	
	 public BookDaoImpl() {
		// TODO Auto-generated constructor stub
		factory =HibernateSessonFactory.getSessionFactory();
	}

	@Override
	public List<Book> getAllBooks() {
		Session session = factory.openSession();
		List<Book> books= session.createQuery("from Book").list();
		session.close();
		
		
		return books;
	}

	@Override
	public Book getBookById(int bookId) {
		
		Session session = factory.openSession();
		Book book = (Book) session.get(Book.class, bookId);
		session.close();
		return book;
	}

	@Override
	public Book addBook(Book book) {
		Session session = factory.openSession();
		Transaction tx= session.getTransaction();
		try{
			tx.begin();
			session.save(book);
			tx.commit();
			
		}catch(HibernateException e){
			tx.rollback();
		}finally {
			session.close();
		}
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		
		Session session = factory.openSession();
		Transaction tx= session.getTransaction();
		try{
			tx.begin();
			session.update(book);
			tx.commit();
			
		}catch(HibernateException e){
			tx.rollback();
		}finally {
			session.close();
		}
		return book;
	}

	@Override
	public Book removeBook(int bookId) {
		
		Session session = factory.openSession();
		Transaction tx= session.getTransaction();
		Book bookToBeDeleted=null;
		try{
			tx.begin();
			bookToBeDeleted=getBookById(bookId);
			session.delete(bookToBeDeleted);
			tx.commit();
			
		}catch(HibernateException e){
			tx.rollback();
		}finally {
			session.close();
		}
		return bookToBeDeleted;
	}

}
