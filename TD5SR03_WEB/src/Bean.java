import javax.faces.bean.ViewScoped;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
@ViewScoped
public class Bean {

    private String name;
    private List<String> names; 

    @PostConstruct
    public void init() {
    	names = new ArrayList<String>();
    	names.add("valeur1");
    	names.add("valeur2");
    	names.add("valeur3");
    	names.add("valeur4");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
    
    

    // ... (getters, setters, etc)
}