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
public class GestVoiture {
	
	private List<VoitureTemplate> voitureTemplate;
	
	@PostConstruct
	public void init()
	{		
		this.voitureTemplate = new ArrayList<VoitureTemplate>();
		
		
		Client client = ClientBuilder.newClient();
		
		this.voitureTemplate = client.target("http://localhost:8080/TD5SR03_REST/voiture/voituresByColor")  //Appel du Web Service
				.queryParam("couleur", "rouge")  //Avec ces paramètres
				.request(MediaType.APPLICATION_JSON)  //On obtient résultat sous forme de JSON
				.get(new GenericType<List<VoitureTemplate>>() {});  //On transfert le JSON dans l'objet VoitureTemplate		
	}

	public List<VoitureTemplate> getVoitureTemplate() {
		return voitureTemplate;
	}

	public void setVoitureTemplate(List<VoitureTemplate> voitureTemplate) {
		this.voitureTemplate = voitureTemplate;
	}

}

