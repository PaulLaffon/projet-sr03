import java.io.Serializable;
import java.math.BigDecimal;


public class ModeleTemplate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nom;
	private String marque;
	private BigDecimal prix;

	public ModeleTemplate() {
		super();
		this.prix = new BigDecimal(0);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	
	

}
