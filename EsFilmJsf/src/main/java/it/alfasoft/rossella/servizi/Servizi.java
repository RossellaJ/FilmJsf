package it.alfasoft.rossella.servizi;


import it.alfasoft.rossella.Film;
import it.alfasoft.rossella.dao.FilmDao;

public class Servizi {
	
	FilmDao fDao = new FilmDao();
	
	public boolean registraFilm(Film f){
		boolean res=false;
		res= fDao.aggiungiFilm(f);
		return res;
	}

}
