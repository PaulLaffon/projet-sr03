import java.io.Serializable;
import java.math.BigDecimal;


public class CouleurTemplate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String couleur;
	private BigDecimal prix;

	public CouleurTemplate() {
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
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
	
	

}
