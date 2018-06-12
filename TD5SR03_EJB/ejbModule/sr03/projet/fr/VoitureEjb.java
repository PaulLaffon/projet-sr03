package sr03.projet.fr;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Couleur;
import model.Modele;
import model.Motorisation;
import model.OptionSup;
import model.TypeFinition;
import model.TypeJante;
import model.Voiture;

/**
 * Session Bean implementation class ProjetSr03
 */
@Stateless
public class VoitureEjb implements VoitureLocalEjb {
	
	@PersistenceContext(name = "TD5SR03_JPA")
	EntityManager em;
	
    public VoitureEjb() {

    }
    
    @SuppressWarnings("unchecked")
	public List<TypeFinition> getFinitions()
    {
    		Query q = em.createQuery("select f from TypeFinition f");
    		
    		return q.getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Couleur> getCouleurs()
    {
    		Query q = em.createQuery("select f from Couleur f");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Modele> getModeles()
    {
    		Query q = em.createQuery("select f from Modele f");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Motorisation> getMotorisations()
    {
    		Query q = em.createQuery("select f from Motorisation f");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<OptionSup> getOptionSups()
    {
    		Query q = em.createQuery("select f from OptionSup f");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<TypeJante> getTypeJantes()
    {
    		Query q = em.createQuery("select f from TypeJante f");
    		
    		return q.getResultList();
    }


	 public Motorisation getMotorisationById(String motId) {
		 //Create a query
		 Query q = em.createQuery("SELECT motorisation FROM Motorisation motorisation WHERE motorisation.id =:motoid");
		 
		 //Set the parameter
		 q.setParameter("motoid", motId);
		 
		 return (Motorisation) q.getSingleResult();	 
	 }
	 
	 //Récupérer les voitures d'une certaine couleur
	 @SuppressWarnings("unchecked")
	 public List<Voiture> getVoitureByColor(String couleur){  // IL MANQUE LES optionsSups
		 
		 Query q = em.createQuery("SELECT v FROM Voiture v JOIN FETCH v.couleur couleur WHERE couleur.couleur =:color");
			 
		 q.setParameter("color", couleur);
		 
		 List<Voiture> voitures = q.getResultList();
		 return voitures;
	 }
	 
	//Récupérer toutes les voitures ayant un moteur d'une certaines puissance et des jantes d'une certaine matière
	@SuppressWarnings("unchecked")
	public List<Voiture> getVoitureByPuissanceMoteurAndMatiereJante(int puissance, String matiereJante){
		 
		 Query q = em.createQuery("SELECT v FROM Voiture v "
		 		+ "JOIN FETCH v.motorisation moteur "
		 		+ "JOIN FETCH v.typeJante jante "
		 		+ "WHERE moteur.puissance =:puissance "
		 		+ "AND jante.matiere =:matiere");
			 
		 q.setParameter("puissance", puissance);
		 q.setParameter("matiere", matiereJante);
		 
		 List<Voiture> voitures = q.getResultList();
		 return voitures;
	 }
	 
	//Récupérer le nombre de voiture ayant un moteur d'un certain nom
	public long getNumberVoitureByNameOfMotor(String nomMoteur){
		 
		 Query q = em.createQuery("SELECT COUNT(*) FROM Voiture v JOIN v.motorisation moteur WHERE moteur.nomMoteur =:nom");
			 
		 q.setParameter("nom", nomMoteur);
		 
		 long nombre = (long)q.getSingleResult() ;
		 return nombre;
	 }
	
	//Récupérer le prix d'une voiture
	public BigDecimal getPrixVoitureById(String id){
		Query q = em.createQuery("SELECT modele.prix + couleur.prix + typeFinition.prix + moteur.prix + jante.prix + SUM(optionsSups.prix) FROM Voiture v "
				+ "JOIN v.modele modele "
				+ "JOIN v.couleur couleur "
				+ "JOIN v.typeFinition typeFinition "
		 		+ "JOIN v.motorisation moteur "
		 		+ "JOIN v.typeJante jante "
		 		+ "JOIN v.optionSups optionsSups "
		 		+ "WHERE v.id =:voitureId" );
			 
		 q.setParameter("voitureId", id);
		 
		 BigDecimal prixVoiture = (BigDecimal) q.getSingleResult() ;
		 return prixVoiture;
	}

	//Ne marche pas, je sais pas pourquoi, j'ai essayé 5000 trucs ..,
	//Récupérer les voitures en dessous d'un certain budget
	public List<Voiture> getVoitureByBudget(BigDecimal prix){
		Query q = em.createQuery("SELECT v.id, modele.prix + couleur.prix + typeFinition.prix + moteur.prix + jante.prix + SUM(optionsSups.prix) as prixTotal FROM Voiture v "
				+ "JOIN v.modele modele "
				+ "JOIN v.couleur couleur "
				+ "JOIN v.typeFinition typeFinition "
		 		+ "JOIN v.motorisation moteur "
		 		+ "JOIN v.typeJante jante "
		 		+ "JOIN v.optionSups optionsSups "
		 		+ "GROUP BY v.id"
		 		+ "HAVING prixTotal <=:prixMax");
			 
		 q.setParameter("prixMax", prix);
		 
		 List<Voiture> voitures = q.getResultList();
		 return voitures;
		
	}
	
	//EN TEST
	
	@SuppressWarnings("unchecked")
	public List<String> getFinitionsNames()
    {
    		Query q = em.createQuery("select type from TypeFinition f");
    		
    		return q.getResultList();
    }
	
	
	public TypeFinition getFinitionByName(String name) {
		//Create a query
		 Query q = em.createQuery("SELECT f FROM TypeFinition f WHERE f.type =:name");
		 
		 //Set the parameter
		 q.setParameter("name", name);
		 
		 return (TypeFinition) q.getSingleResult();	 
	}
	
	public Couleur getCouleurByName(String name) {
		//Create a query
		 Query q = em.createQuery("SELECT f FROM Couleur f WHERE f.couleur =:name");
		 
		 //Set the parameter
		 q.setParameter("name", name);
		 
		 return (Couleur) q.getSingleResult();	 
	}
	
	public Modele getModeleByName(String name) {
		//Create a query
		 Query q = em.createQuery("SELECT f FROM Modele f WHERE f.nom =:name");
		 
		 //Set the parameter
		 q.setParameter("name", name);
		 
		 return (Modele) q.getSingleResult();	 
	}
	
	public Motorisation getMotorisationByName(String name) {
		//Create a query
		 Query q = em.createQuery("SELECT f FROM Motorisation f WHERE f.nomMoteur =:name");
		 
		 //Set the parameter
		 q.setParameter("name", name);
		 
		 return (Motorisation) q.getSingleResult();	 
	}
	
	public OptionSup getOptionSupByName(String name) {
		//Create a query
		 Query q = em.createQuery("SELECT f FROM OptionSup f WHERE f.nom =:name");
		 
		 //Set the parameter
		 q.setParameter("name", name);
		 
		 return (OptionSup) q.getSingleResult();	 
	}
	
	public TypeJante getTypeJanteByName(String name) {
		//Create a query
		 Query q = em.createQuery("SELECT f FROM TypeJante f WHERE f.matiere =:name");
		 
		 //Set the parameter
		 q.setParameter("name", name);
		 
		 return (TypeJante) q.getSingleResult();	 
	}

	


    
    /*
     public void updateVoitures(List<Voiture> voitures)
    {
            em.merge(voitures);
    }

    public void deleteVoitures(List<Voiture> voitures)
    {
            em.remove(voitures);
    }

    public void addVoitures(List<Voiture> voitures)
    {
            em.persist(voitures);
    }
     */

}


