package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the motorisation database table.
 * 
 */
@Entity
@NamedQuery(name="Motorisation.findAll", query="SELECT m FROM Motorisation m")
public class Motorisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="nom_moteur")
	private String nomMoteur;

	private BigDecimal prix;

	private int puissance;

	//bi-directional many-to-many association to TypeFinition
	@ManyToMany
	@JoinTable(
		name="motorisation_type_finition"
		, joinColumns={
			@JoinColumn(name="motorisation_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="type_finition_id")
			}
		)
	private List<TypeFinition> typeFinitions;

	//bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy="motorisation")
	private List<Voiture> voitures;

	public Motorisation() {
	}

	public Motorisation(String id, String nomMoteur, BigDecimal prix, int puissance) {
		super();
		this.id = id;
		this.nomMoteur = nomMoteur;
		this.prix = prix;
		this.puissance = puissance;
	}



	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomMoteur() {
		return this.nomMoteur;
	}

	public void setNomMoteur(String nomMoteur) {
		this.nomMoteur = nomMoteur;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getPuissance() {
		return this.puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	@JsonIgnore
	public List<TypeFinition> getTypeFinitions() {
		return this.typeFinitions;
	}

	public void setTypeFinitions(List<TypeFinition> typeFinitions) {
		this.typeFinitions = typeFinitions;
	}

	@JsonIgnore
	public List<Voiture> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Voiture addVoiture(Voiture voiture) {
		getVoitures().add(voiture);
		voiture.setMotorisation(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setMotorisation(null);

		return voiture;
	}

}