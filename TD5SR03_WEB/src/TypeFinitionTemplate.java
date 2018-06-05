import java.io.Serializable;
import java.math.BigDecimal;


public class TypeFinitionTemplate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private BigDecimal prix;
	private String type;	
	
	public TypeFinitionTemplate() {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
