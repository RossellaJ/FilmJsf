package it.alfasoft.rossella;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "filmController",eager=true)
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Film> listaFilm;

	
	
	public FilmController() {
		//inizializza la lista con servizi che a sua volta fa read da dao
		
		this.listaFilm= new ArrayList<Film>();
	}

	
	
	
	public List<Film> getListaFilm() {
		return listaFilm;
	}

	public void setListaFilm(List<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
