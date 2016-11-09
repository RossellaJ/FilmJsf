package it.alfasoft.rossella.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.rossella.Film;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilmDao {
	
	//create
	public boolean aggiungiFilm(Film f) {

		boolean res = false;

		Session session = HibernateUtil.openSession();

		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			session.persist(f);

			tx.commit();

			res = true;

		} catch (Exception ex) {

			tx.rollback();

		} finally {

			session.close();

		}

		return res;

	}
	

}
