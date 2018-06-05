package projet_rest;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Couleur;
import model.Motorisation;
import model.TypeJante;
import sr03.projet.fr.VoitureLocalEjb;

@Stateless
@Path("/voiture")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class MyWS { /* Mon Web Service */
	
	@EJB
	private VoitureLocalEjb voiture;
	
	@GET
	@Path("/finitions") //URI
    public Response getFinitions()
    {
		return Response.ok(this.voiture.getFinitions()).build();
    }
	
	@GET
	@Path("/couleurs") //URI
    public Response getCouleurs()
    {
		return Response.ok(this.voiture.getCouleurs()).build();
    }
	
	@GET
	@Path("/modeles") //URI
    public Response getModeles()
    {
		return Response.ok(this.voiture.getModeles()).build();
    }
	
	@GET
	@Path("/motorisations") //URI
    public Response getMotorisations()
    {
		return Response.ok(this.voiture.getMotorisations()).build();
    }
	
	@GET
	@Path("/optionSups") //URI
    public Response getOptionSups()
    {
		return Response.ok(this.voiture.getOptionSups()).build();
    }
	
	@GET
	@Path("/typeJantes") //URI
    public Response getTypeJantes()
    {
		return Response.ok(this.voiture.getTypeJantes()).build();
    }
	
	@GET
	@Path("/motorisationById")
    public Response getMotorisation(@QueryParam("motId") String id)
    {
		return Response.ok(this.voiture.getMotorisationById(id)).build();
    }
	
	
	@GET
	@Path("/voituresByColor")
    public Response getVoitureByColor(@QueryParam("couleur") String couleur)
    {
		return Response.ok(this.voiture.getVoitureByColor(couleur)).build();
    }
	
	@GET
	@Path("/voituresByPuissanceAndJante")
    public Response getVoitureByPuissanceMoteurAndMatiereJante(@QueryParam("puissance") int puissance, @QueryParam("matiereJante") String matiereJante )
    {
		return Response.ok(this.voiture.getVoitureByPuissanceMoteurAndMatiereJante(puissance,matiereJante)).build();
    }
	

	@GET
	@Path("/nbVoituresByNameMotor")
    public Response getNumberVoitureByMotor(@QueryParam("nomMoteur") String nom)
    {
		return Response.ok(this.voiture.getNumberVoitureByNameOfMotor(nom)).build();
    }
	
	
	@GET
	@Path("/prixVoituresById")
    public Response getPrixVoitureById(@QueryParam("voitureId") String id)
    {
		return Response.ok(this.voiture.getPrixVoitureById(id)).build();
    }
	
	@GET
	@Path("/voituresByBudget")
    public Response getVoitureByBudget(@QueryParam("prix") BigDecimal prixMax)
    {
		return Response.ok(this.voiture.getVoitureByBudget(prixMax)).build();
    }
	
	//EN TEST
	
	@GET
	@Path("/finitionsNames") //URI
    public Response getFinitionsNames()
    {
		return Response.ok(this.voiture.getFinitionsNames()).build();
    }
	
	
	//Ca marche quand je mets un truc bon, mais sinon ça retourne une erreur au lieu de rien renvoyer ...
	@GET
	@Path("/finitionByName") //URI
    public Response getFinitionByName(@QueryParam("name") String name)
    {
		return Response.ok(this.voiture.getFinitionByName(name)).build();
    }
	
	@GET
	@Path("/couleurByName") //URI
    public Response getCouleurByName(@QueryParam("name") String name)
    {
		return Response.ok(this.voiture.getCouleurByName(name)).build();
    }
	
	@GET
	@Path("/ModeleByName") //URI
    public Response getModeleByName(@QueryParam("name") String name)
    {
		return Response.ok(this.voiture.getModeleByName(name)).build();
    }
	
	@GET
	@Path("/MotorisationByName") //URI
    public Response getMotorisationByName(@QueryParam("name") String name)
    {
		return Response.ok(this.voiture.getMotorisationByName(name)).build();
    }
	
	@GET
	@Path("/TypeJanteByName") //URI
    public Response getTypeJanteByName(@QueryParam("name") String name)
    {
		return Response.ok(this.voiture.getTypeJanteByName(name)).build();
    }
	
	@GET
	@Path("/OptionSupByName") //URI
    public Response getOptionSupByName(@QueryParam("name") String name)
    {
		return Response.ok(this.voiture.getOptionSupByName(name)).build();
    }
	
	
	
}
