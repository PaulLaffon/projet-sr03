package sr03.projet.fr;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import model.Couleur;
import model.Motorisation;
import model.TypeFinition;
import model.TypeJante;
import model.Voiture;

@Local
public interface VoitureLocalEjb {
	
	public List<TypeFinition> getFinitions();

	public Motorisation getMotorisationById(String motId);
	 
	public List<Voiture> getVoitureByColor(String couleur);
	 
	public List<Voiture> getVoitureByPuissanceMoteurAndMatiereJante(int puissance, String matiereJante);

	public long getNumberVoitureByNameOfMotor(String nomMoteur);
	
	public BigDecimal getPrixVoitureById(String id);
	
	public List<Voiture> getVoitureByBudget(BigDecimal prix);
	
	// En phase de test
	
	public List<String> getFinitionsNames();
	
	public TypeFinition getFinitionsByType(String type);


}
