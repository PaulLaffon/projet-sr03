import java.util.List;

import model.Couleur;
import model.Modele;
import model.Motorisation;
import model.OptionSup;
import model.TypeFinition;
import model.TypeJante;

public class VoitureTemplate {
	
	private String id;
	private Couleur couleur;
	private Modele modele;
	private Motorisation motorisation;
	private List<OptionSup> optionSups;
	private TypeFinition typeFinition;
	private TypeJante typeJante;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	public Motorisation getMotorisation() {
		return motorisation;
	}
	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}
	public List<OptionSup> getOptionSups() {
		return optionSups;
	}
	public void setOptionSups(List<OptionSup> optionSups) {
		this.optionSups = optionSups;
	}
	public TypeFinition getTypeFinition() {
		return typeFinition;
	}
	public void setTypeFinition(TypeFinition typeFinition) {
		this.typeFinition = typeFinition;
	}
	public TypeJante getTypeJante() {
		return typeJante;
	}
	public void setTypeJante(TypeJante typeJante) {
		this.typeJante = typeJante;
	}
	
	
 

}
