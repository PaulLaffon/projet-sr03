import java.io.Serializable;
import java.math.BigDecimal;


public class TypeJanteTemplate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String diametre;
	private String matiere;
	private BigDecimal prix;

	public TypeJanteTemplate() {
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
	public String getDiametre() {
		return diametre;
	}
	public void setDiametre(String diametre) {
		this.diametre = diametre;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	
	
	
	
	

}
