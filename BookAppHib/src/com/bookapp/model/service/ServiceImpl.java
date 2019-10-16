package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.persistence.Book;
import com.bookapp.model.persistence.BookDao;
import com.bookapp.model.persistence.BookDaoImpl;

public class ServiceImpl implements BookService{

	private BookDao dao;
	
	public  ServiceImpl() {
		dao= new BookDaoImpl();
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

	@Override
	public Book getBookById(int bookId) {
		Book book = dao.getBookById(bookId);
		if(book==null)
			throw new BookNotFoundExce("Book with id" + bookId +"is not found");
		return book;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return dao.updateBook(book);
	}

	@Override
	public Book removeBook(int bookId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bookId);
	}

}
