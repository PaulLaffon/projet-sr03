import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import sr03.projet.fr.VoitureLocalEjb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


@ManagedBean
@ViewScoped
public class GestForTest {

    private CouleurTemplate couleur;
    private List<CouleurTemplate> couleurs; 
    
    private ModeleTemplate modele;
    private List<ModeleTemplate> modeles;
    
    private MotorisationTemplate motorisation;
    private List<MotorisationTemplate> motorisations;
    
    private TypeFinitionTemplate finition;
    private List<TypeFinitionTemplate> finitions;
    
    private TypeJanteTemplate jante;
    private List<TypeJanteTemplate> jantes;
    
    private List<OptionsSupTemplate> options;
    private List<String> currentOpts;
    private List<OptionsSupTemplate> currentOptions;
    
    private BigDecimal prixTotal;
    
    @PostConstruct
    public void init() {
    	this.finitions = new ArrayList<TypeFinitionTemplate>();
		
		
		Client client = ClientBuilder.newClient();
		
		//Ca serait pas plus simple de mettre un objet 
		//@EJB
		//private VoitureLocalEjb voiture;  et d'appeller les m�thodes � partir de lui au lieu de faire des appels � des web services ? Mais le prof avait fait avec web services pour exemple donc ??
		this.finitions = client.target("http://localhost:8080/TD5SR03_REST/voiture/finitions")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<List<TypeFinitionTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate
		
		this.couleurs = client.target("http://localhost:8080/TD5SR03_REST/voiture/couleurs")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<List<CouleurTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate	
		
		this.modeles = client.target("http://localhost:8080/TD5SR03_REST/voiture/modeles")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<List<ModeleTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate	
		
		this.motorisations = client.target("http://localhost:8080/TD5SR03_REST/voiture/motorisations")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<List<MotorisationTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate	
		
		this.jantes = client.target("http://localhost:8080/TD5SR03_REST/voiture/typeJantes")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<List<TypeJanteTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate
		
		this.options = client.target("http://localhost:8080/TD5SR03_REST/voiture/optionSups")  //Appel du Web Service
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<List<OptionsSupTemplate>>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate	
		
		this.finition = new TypeFinitionTemplate();
		this.couleur = new CouleurTemplate();
		this.modele = new ModeleTemplate();
		this.motorisation = new MotorisationTemplate();
		this.jante = new TypeJanteTemplate();
		
		this.currentOptions = new ArrayList<OptionsSupTemplate>();
		this.currentOpts = new ArrayList<String>();
		this.prixTotal = new BigDecimal(0);
    }

	public TypeFinitionTemplate getFinition() {
		return finition;
	}

	public void setFinition(TypeFinitionTemplate finition) {
		this.finition = finition;
	}

	public List<TypeFinitionTemplate> getFinitions() {
		return finitions;
	}

	public void setFinitions(List<TypeFinitionTemplate> finitions) {
		this.finitions = finitions;
	}

	public CouleurTemplate getCouleur() {
		return couleur;
	}

	public void setCouleur(CouleurTemplate couleur) {
		this.couleur = couleur;
	}

	public List<CouleurTemplate> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(List<CouleurTemplate> couleurs) {
		this.couleurs = couleurs;
	}

	public ModeleTemplate getModele() {
		return modele;
	}

	public void setModele(ModeleTemplate modele) {
		this.modele = modele;
	}

	public List<ModeleTemplate> getModeles() {
		return modeles;
	}

	public void setModeles(List<ModeleTemplate> modeles) {
		this.modeles = modeles;
	}

	public MotorisationTemplate getMotorisation() {
		return motorisation;
	}

	public void setMotorisation(MotorisationTemplate motorisation) {
		this.motorisation = motorisation;
	}

	public List<MotorisationTemplate> getMotorisations() {
		return motorisations;
	}

	public void setMotorisations(List<MotorisationTemplate> motorisations) {
		this.motorisations = motorisations;
	}

	public TypeJanteTemplate getJante() {
		return jante;
	}

	public void setJante(TypeJanteTemplate jante) {
		this.jante = jante;
	}

	public List<TypeJanteTemplate> getJantes() {
		return jantes;
	}

	public void setJantes(List<TypeJanteTemplate> jantes) {
		this.jantes = jantes;
	}

	public List<OptionsSupTemplate> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsSupTemplate> options) {
		this.options = options;
	}

	public List<OptionsSupTemplate> getCurrentOptions() {
		return currentOptions;
	}

	public void setCurrentOptions(List<OptionsSupTemplate> currentOptions) {
		this.currentOptions = currentOptions;
	}

	public List<String> getCurrentOpts() {
		return currentOpts;
	}

	public void setCurrentOpts(List<String> currentOpts) {
		this.currentOpts = currentOpts;
	}
	
	public BigDecimal getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public void updateTypeFinition(AjaxBehaviorEvent event) {
		Client client = ClientBuilder.newClient();
		String name = getFinition().getType();
		this.finition = client.target("http://localhost:8080/TD5SR03_REST/voiture/finitionByName")  //Appel du Web Service
				.queryParam("name", name)  //Avec ces param�tres
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<TypeFinitionTemplate>() {});  //On transfert le JSON dans l'objet TypeFinitionTemplate
		this.updatePrixTotal();
	}
	
	public void updateModele(AjaxBehaviorEvent event) {
		Client client = ClientBuilder.newClient();
		String name = getModele().getNom();
		this.modele = client.target("http://localhost:8080/TD5SR03_REST/voiture/ModeleByName")  //Appel du Web Service
				.queryParam("name", name)  //Avec ces param�tres
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<ModeleTemplate>() {});  //On transfert le JSON dans l'objet VoitureTemplate
		this.updatePrixTotal(); 
	}
	
	public void updateMotorisation(AjaxBehaviorEvent event) {
		Client client = ClientBuilder.newClient();
		String name = getMotorisation().getNomMoteur();
		this.motorisation = client.target("http://localhost:8080/TD5SR03_REST/voiture/MotorisationByName")  //Appel du Web Service
				.queryParam("name", name)  //Avec ces param�tres
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<MotorisationTemplate>() {});  //On transfert le JSON dans l'objet VoitureTemplate
		this.updatePrixTotal();
	}
	
	public void updateCouleur(AjaxBehaviorEvent event) {
		Client client = ClientBuilder.newClient();
		String name = getCouleur().getCouleur();
		this.couleur = client.target("http://localhost:8080/TD5SR03_REST/voiture/couleurByName")  //Appel du Web Service
				.queryParam("name", name)  //Avec ces param�tres
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<CouleurTemplate>() {});  //On transfert le JSON dans l'objet VoitureTemplate	
		this.updatePrixTotal();
	}
	
	public void updateTypeJante(AjaxBehaviorEvent event) {
		Client client = ClientBuilder.newClient();
		String name = getJante().getMatiere();
		this.jante = client.target("http://localhost:8080/TD5SR03_REST/voiture/TypeJanteByName")  //Appel du Web Service
				.queryParam("name", name)  //Avec ces param�tres
				.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
				.get(new GenericType<TypeJanteTemplate>() {});  //On transfert le JSON dans l'objet VoitureTemplate		
		this.updatePrixTotal();
	}
	
	public void updateCurrentOptionSups(AjaxBehaviorEvent event) {
		this.currentOptions.clear();
		Client client = ClientBuilder.newClient();
		for(String x : getCurrentOpts()) {
			this.currentOptions.add(client.target("http://localhost:8080/TD5SR03_REST/voiture/OptionSupByName")  //Appel du Web Service
					.queryParam("name", x)  //Avec ces param�tres
					.request(MediaType.APPLICATION_JSON)  //On obtient r�sultat sous forme de JSON
					.get(new GenericType<OptionsSupTemplate>() {}));  //On transfert le JSON dans l'objet VoitureTemplate
		}
		this.updatePrixTotal();
	}
	
	public void updatePrixTotal() {
		this.setPrixTotal(new BigDecimal(0));
		this.setPrixTotal(getPrixTotal().add(getModele().getPrix())
			.add(getFinition().getPrix())
			.add(getCouleur().getPrix())
			.add(getJante().getPrix())
			.add(getMotorisation().getPrix()));
		for(OptionsSupTemplate x: getCurrentOptions()) {
			this.setPrixTotal(this.getPrixTotal().add(x.getPrix()));
		}
		
	}
    
    

    // ... (getters, setters, etc)
}