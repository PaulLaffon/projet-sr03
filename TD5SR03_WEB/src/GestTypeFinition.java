import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

@ManagedBean
@ViewScoped
public class GestTypeFinition {
	
	// ENFAITE FAUT PAS FAIRE CA JE PENSE, CAR LES listes déroulantes seront pas indépendant et le prix total non plus, donc il faudrait tout faire à partir d'une meme classe Gest ? (je me comprend car sinon comment faire pour que par exemple afficher que les moteurs dispo parmis ceux associé aux types de finitions
	
	private String typefinitionnamecourant;
	private List<TypeFinitionTemplate> typefinitons;
	
	@PostConstruct
	public void init()
	{		
		this.typefinitons = new ArrayList<TypeFinitionTemplate>();
		
		
		Client client = ClientBuilder.newClient();
		
		this.typefinitons = client.target("http://localhost:8080/TD5SR03_REST/voiture/finitions")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient résultat sous forme de JSON
				.get(new GenericType<List<TypeFinitionTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate
	}
	
	public String getTypefinitionnamecourant() {
		return typefinitionnamecourant;
	}

	public void setTypefinitionnamecourant(String typefinitionnamecourant) {
		this.typefinitionnamecourant = typefinitionnamecourant;
	}
	
	public List<TypeFinitionTemplate> getTypefinitons() {
		return typefinitons;
	}

	public void setTypefinitons(List<TypeFinitionTemplate> typefinitons) {
		this.typefinitons = typefinitons;
	}

	public List<String> getTypefinitonsNames() {
		List<String> typefinitonsNames = new ArrayList<String>();
		for (TypeFinitionTemplate x : getTypefinitons()) {
			typefinitonsNames.add(x.getType());
		}
		return typefinitonsNames;
	}


}