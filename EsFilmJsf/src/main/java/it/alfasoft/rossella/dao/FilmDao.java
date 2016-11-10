package it.alfasoft.rossella.dao;

import java.util.List;

import hibernateUtil.HibernateUtil;
import it.alfasoft.rossella.Film;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilmDao {
	
	//create
	public boolean createFilm(Film f) {

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
	
	//leggi tutte le voci
	@SuppressWarnings("unchecked")
	public List<Film> readTuttiFilm(){
		
		List<Film> lista=null;
		
		Session session = HibernateUtil.openSession();

		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();
			

			Query query = session.createQuery("from Film");

			lista = (List<Film>) query.list();

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {

			session.close();

		}
		
		return lista;
		
		
	}
	//2)Leggi un film
	
			public Film readFilmConId(long idFilm) {

				Film f = null;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					Query query = session.createQuery("from Film where idFilm=:idInserito");
					query.setLong("idInserito", idFilm);
					f = (Film) query.uniqueResult();
					
					tx.commit();

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return f;

			}
			// 4- Update

			public boolean updateFilm(Film f) {

				boolean res = false;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					session.update(f);

					tx.commit();

					res = true;

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return res;

			}
		//Delete
			public boolean deleteFilm(Film f) {

				boolean res = false;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					session.delete(f);

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



