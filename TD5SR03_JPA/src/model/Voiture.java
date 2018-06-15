package model;

import java.io.IOException;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


/**
 * The persistent class for the voiture database table.
 * 
 */
@Entity
@NamedQuery(name="Voiture.findAll", query="SELECT v FROM Voiture v")
public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	//bi-directional many-to-one association to Couleur
	@ManyToOne
	private Couleur couleur;

	//bi-directional many-to-one association to Modele
	@ManyToOne
	private Modele modele;

	//bi-directional many-to-one association to Motorisation
	@ManyToOne
	private Motorisation motorisation;

	//bi-directional many-to-many association to OptionSup
	@ManyToMany
	@JoinTable(
		name="voiture_option_sup"
		, joinColumns={
			@JoinColumn(name="voiture_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="option_sup_id")
			}
		)
	private List<OptionSup> optionSups;

	//bi-directional many-to-one association to TypeFinition
	@ManyToOne
	@JoinColumn(name="type_finition_id")
	private TypeFinition typeFinition;

	//bi-directional many-to-one association to TypeJante
	@ManyToOne
	@JoinColumn(name="type_jante_id")
	private TypeJante typeJante;

	public Voiture() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Modele getModele() {
		return this.modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Motorisation getMotorisation() {
		return this.motorisation;
	}

	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}

	@JsonIgnore
	public List<OptionSup> getOptionSups() {
		return this.optionSups;
	}

	public void setOptionSups(List<OptionSup> optionSups) {
		this.optionSups = optionSups;
	}

	public TypeFinition getTypeFinition() {
		return this.typeFinition;
	}

	public void setTypeFinition(TypeFinition typeFinition) {
		this.typeFinition = typeFinition;
	}

	public TypeJante getTypeJante() {
		return this.typeJante;
	}

	public void setTypeJante(TypeJante typeJante) {
		this.typeJante = typeJante;
	}
	
	public String toString()
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Voiture fromString(String s)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return (Voiture)mapper.readValue(s, Voiture.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}