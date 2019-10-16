package com.bookapp.model.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessonFactory {

	public HibernateSessonFactory() {}

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static SessionFactory getSessionFactory() {

		return factory;
	}

}
