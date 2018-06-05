package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the modele database table.
 * 
 */
@Entity
@NamedQuery(name="Modele.findAll", query="SELECT m FROM Modele m")
public class Modele implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String marque;

	private String nom;

	private BigDecimal prix;

	//bi-directional many-to-many association to TypeFinition
	@ManyToMany
	@JoinTable(
		name="modele_type_finition"
		, joinColumns={
			@JoinColumn(name="modele_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="type_finition_id")
			}
		)
	private List<TypeFinition> typeFinitions;

	//bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy="modele")
	private List<Voiture> voitures;

	public Modele() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
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
		voiture.setModele(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setModele(null);

		return voiture;
	}

}