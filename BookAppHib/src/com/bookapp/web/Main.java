package com.bookapp.web;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.persistence.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.ServiceImpl;

public class Main {
public static void main(String[] args) {
	ApplicationContext ctx =new ClassPathXmlApplicationContext("Beans.xml");
	BookService bookService = (BookService) ctx.getBean("bs");
	List<Book> books = bookService.getAllBooks();
	for(Book book:books){
		System.out.println(book);
	}
	
	Book book1 = bookService.getBookById(2);
	System.out.println(book1);
	
	Book book2 =bookService.removeBook(3);
	System.out.println(book2);
	
	
	
	/*
	for(Book book:books){
		System.out.println(book);
	}*/
	
	
	
	/*BookService bookService = new ServiceImpl();
	Book book = new Book("A23", "Java", "alea", 450);
	bookService.addBook(book);
	System.out.println("Book is added");
	
	Book bookToBeSearched =bookService.getBookById(1);
	System.out.println(bookToBeSearched);*/
	
}
}
