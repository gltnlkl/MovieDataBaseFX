package com.gulukal.project.control;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.gulukal.project.entity.MovieEntity;

public class MovieEntityController implements Controllable<MovieEntity>{
	
	@Override
	public void create(MovieEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamd�r" + Controllable.class);
		} catch (Exception e) {
			System.out.println("ekleme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	// silmek
	@Override
	public void delete(MovieEntity entity) {
		
		try {
			MovieEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + MovieEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		
	}
	
	// g�ncellemek
	@Override
	public void update(MovieEntity entity) {
		try {
			MovieEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				findEntity.setYear(entity.getYear());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("G�ncelleme Ba�ar�l� " + MovieEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("g�ncelleme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<MovieEntity> list() {
		
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulamas� yani java class�na g�re
		// �a��raca��z.
		
//		String hql = "from MovieEntity";
		
		String hql = "select str from MovieEntity as str where str.id>=:key";
		TypedQuery<MovieEntity> typedQuery = session.createQuery(hql, MovieEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<MovieEntity> arrayList = (ArrayList<MovieEntity>) typedQuery.getResultList();
		System.out.println("listelendi " + MovieEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public MovieEntity find(long id) {
		Session session = databaseConnectionHibernate();
		MovieEntity entity;
		try {
			entity = session.find(MovieEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Arad���n�z kriterde sonu�lar bulunamad� ...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kay�t gonder
	@Override
	public MovieEntity singleResult(long id) {
		return Controllable.super.singleResult(id);
	}

}