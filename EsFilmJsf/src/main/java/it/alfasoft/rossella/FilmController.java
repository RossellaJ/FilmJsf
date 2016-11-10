package it.alfasoft.rossella;

import it.alfasoft.rossella.servizi.Servizi;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "filmController",eager=true)
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Film> listaFilm;
	private Servizi s;
	private Film f;
	
	
	public FilmController() {
		//inizializza la lista con servizi che a sua volta fa read da dao
		s= new Servizi();
		this.listaFilm= s.leggiTuttiFilm(); 
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

	
	//metodo che verrà richiamato in validazione del Codice film
		public void validazioneCodiceFilm(FacesContext context,
								UIComponent component,
								Object value)throws ValidatorException{
			if(value==null){
				return;
			}
			String dato = value.toString();
			if(!dato.startsWith("mov")){
				FacesMessage msg = new FacesMessage("Codice del Film non è corretto!");
				throw new ValidatorException(msg);
			}
		}
		
	//metodo per registrare nuovo film in database
		
		public String aggiungiFilm(Film f){
			s.registraFilm(f);
			return "TabellaHome?faces-redirect=true";
		}
		
	//modifica film dell'edit
		 public String modificaFilm(long idFilm){
			 
			 Film f=s.leggiFilm(idFilm);
			 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			 Map<String, Object> requestMap = externalContext.getRequestMap();
			 requestMap.put("film", f);
			 return "ModificaFilm";
		 }
		 
		 
			 
		 public String aggiornaFilm(Film f){
				s.modificaFilm(f);
				return "TabellaHome?faces-redirect=true";
			}
		
	//elimina film
		 
		 public String eliminaFilm(Film f){
			 s.eliminaFilm(f);
			 return "TabellaHome?faces-redirect=true";
		 }
			 
			

	

}
