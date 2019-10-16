package com.bookapp.model.service;

public class BookNotFoundExce extends RuntimeException{
	public BookNotFoundExce(String message){
		System.out.println(message);
	}

}
