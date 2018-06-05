package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the couleur database table.
 * 
 */
@Entity
@NamedQuery(name="Couleur.findAll", query="SELECT c FROM Couleur c")
public class Couleur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String couleur;

	private BigDecimal prix;

	//bi-directional many-to-many association to TypeFinition
	@ManyToMany
	@JoinTable(
		name="couleur_type_finition"
		, joinColumns={
			@JoinColumn(name="couleur_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="type_finition_id")
			}
		)
	private List<TypeFinition> typeFinitions;

	//bi-directional many-to-one association to Voiture
	@OneToMany(mappedBy="couleur")
	private List<Voiture> voitures;

	public Couleur() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
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
		voiture.setCouleur(this);

		return voiture;
	}

	public Voiture removeVoiture(Voiture voiture) {
		getVoitures().remove(voiture);
		voiture.setCouleur(null);

		return voiture;
	}

}