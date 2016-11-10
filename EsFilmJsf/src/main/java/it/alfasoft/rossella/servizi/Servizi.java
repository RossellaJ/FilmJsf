package it.alfasoft.rossella.servizi;


import java.util.List;


import it.alfasoft.rossella.Film;
import it.alfasoft.rossella.dao.FilmDao;

public class Servizi {
	
	FilmDao fDao = new FilmDao();
	
	//REGISTRA
	public boolean registraFilm(Film f){
		boolean res=false;
		res= fDao.createFilm(f);
		return res;
	}
	
	//LEGGI LISTA
	public List<Film> leggiTuttiFilm(){
		return fDao.readTuttiFilm();
	}
	
	//OTTENGO DI RITORNO UN FILM
	public Film leggiFilm(long idFilm){
		Film f = fDao.readFilmConId(idFilm);
		return f;
	}
	
	//UPDATE
	public boolean modificaFilm(Film f){
		boolean res=false;
		res= fDao.updateFilm(f);
		return res;
	}
	
	
	//DELETE
	public boolean eliminaFilm(Film f){
		boolean res=false;
		res= fDao.deleteFilm(f);
		return res;
	}
	

	
	
	
}

