package sr03.projet.fr;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import model.Couleur;
import model.Modele;
import model.Motorisation;
import model.OptionSup;
import model.TypeFinition;
import model.TypeJante;
import model.Voiture;

@Local
public interface VoitureLocalEjb {
	
	public List<TypeFinition> getFinitions();
	
	public List<Couleur> getCouleurs();
	
	public List<Modele> getModeles();
	
	public List<Motorisation> getMotorisations();
	
	public List<OptionSup> getOptionSups();

	public List<TypeJante> getTypeJantes();

	public Motorisation getMotorisationById(String motId);
	 
	public List<Voiture> getVoitureByColor(String couleur);
	 
	public List<Voiture> getVoitureByPuissanceMoteurAndMatiereJante(int puissance, String matiereJante);

	public long getNumberVoitureByNameOfMotor(String nomMoteur);
	
	public BigDecimal getPrixVoitureById(String id);
	
	public List<Voiture> getVoitureByBudget(BigDecimal prix);
	
	// En phase de test
	
	public List<String> getFinitionsNames();
	
	public TypeFinition getFinitionByName(String name);
	
	public Couleur getCouleurByName(String name);
	
	public Modele getModeleByName(String name);
	
	public Motorisation getMotorisationByName(String name);
	
	public OptionSup getOptionSupByName(String name);
	
	public TypeJante getTypeJanteByName(String name);


}
