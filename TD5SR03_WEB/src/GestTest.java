import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import model.TypeFinition;


@ManagedBean
@ViewScoped
public class GestTest {
	
	private String currentType;
	private List<String> typefinitonsAvailable;
	
	
	@PostConstruct
	public void init()
	{		
		this.typefinitonsAvailable = new ArrayList<String>();
		
		Client client = ClientBuilder.newClient();
		
		this.typefinitonsAvailable = client.target("http://localhost:8080/TD5SR03_REST/voiture/finitions")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient résultat sous forme de JSON
				.get(new GenericType<List<String>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate		
		if(this.typefinitonsAvailable.size()!=0) {
			this.currentType = this.typefinitonsAvailable.get(0);
		}
		else {
			this.currentType = "";
		}
	}


	public List<String> getTypefinitonsAvailable() {
		return typefinitonsAvailable;
	}

	public void setTypefinitonsAvailable(List<String> typefinitonsAvailable) {
		this.typefinitonsAvailable = typefinitonsAvailable;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	

}

