import java.math.BigDecimal;

public class MotorisationTemplate {
	
	private String id;

	private String nomMoteur;
	
	private int puissance;

	private BigDecimal prix;

	public MotorisationTemplate() {
		super();
		this.prix = new BigDecimal(0);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomMoteur() {
		return nomMoteur;
	}

	public void setNomMoteur(String nomMoteur) {
		this.nomMoteur = nomMoteur;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	

	
}

