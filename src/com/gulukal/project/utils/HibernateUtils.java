package com.gulukal.project.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gulukal.project.entity.GenreEntity;
import com.gulukal.project.entity.LinkEntity;
import com.gulukal.project.entity.MovieEntity;
import com.gulukal.project.entity.TagEntity;
import com.gulukal.project.entity.UserEntity;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = sessionFactory();

	private static SessionFactory sessionFactory() {
		try {
			Configuration configuration = new Configuration();

// entity class'larımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(MovieEntity.class);
			configuration.addAnnotatedClass(UserEntity.class);
			configuration.addAnnotatedClass(LinkEntity.class);
			configuration.addAnnotatedClass(TagEntity.class);
			configuration.addAnnotatedClass(GenreEntity.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}