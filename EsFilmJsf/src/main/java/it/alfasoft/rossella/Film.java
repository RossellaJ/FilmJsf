package it.alfasoft.rossella;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="film",eager=true)
public class Film implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String titolo;
	private Integer dataUscita;
	private String regista;
	private String genere;
	private String codiceFilm;
	
	private List<String> listaGeneri;
	
	


	public Film() {
		
		listaGeneri = new ArrayList<String>();
		
		listaGeneri.add("Drammatico");
		listaGeneri.add("Romantico");
		listaGeneri.add("Fantasy");
		listaGeneri.add("thriller");
		
	}


	public Film(String titolo, Integer dataUscita, String regista,
			String genere, String codiceFilm) {
	
		this.titolo = titolo;
		this.dataUscita = dataUscita;
		this.regista = regista;
		this.genere = genere;
		this.codiceFilm = codiceFilm;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public Integer getDataUscita() {
		return dataUscita;
	}


	public void setDataUscita(Integer dataUscita) {
		this.dataUscita = dataUscita;
	}


	public String getRegista() {
		return regista;
	}


	public void setRegista(String regista) {
		this.regista = regista;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public String getCodiceFilm() {
		return codiceFilm;
	}


	public void setCodiceFilm(String codiceFilm) {
		this.codiceFilm = codiceFilm;
	}
	
	
	public List<String> getListaGeneri() {
		return listaGeneri;
	}
	
	
	public void setListaGeneri(List<String> listaGeneri) {
		this.listaGeneri = listaGeneri;
	}
}
