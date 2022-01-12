package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.BoatDTO;
import dtos.FitnessCenter.FitnessCentersDTO;
import dtos.OwnersDTO;
import entities.Boat;
import errorhandling.API_Exception;
import facades.FitnessCenterFacade;
import facades.HarbourFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("harbour")
public class HarbourResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final HarbourFacade FACADE = HarbourFacade.getHarbourFacade(EMF);
    private static final HarbourFacade instance = HarbourFacade.getHarbourFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    Boat boat = new Boat();

    @Context
    private UriInfo context;

    @Path("owners")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllOwners() {
        OwnersDTO ownersDTO = FACADE.getAllOwners();
        return gson.toJson(ownersDTO);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response newBoat (String jsonString) throws API_Exception {
        String brand;
        String make;
        String name;
        String image;
        try {
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            brand = json.get("Brand").getAsString();
            boat.setBrand(brand);
            make = json.get("Make").getAsString();
            boat.setMake(make);
            name = json.get("Name").getAsString();
            boat.setName(name);
            // i mit json jeg har fået tager jeg værdien ud af mit string, hedder det samme i visuel
            image = json.get("Image").getAsString();
            boat.setImage(image);
            instance.createBoat(boat);
        } catch (Exception e) {
            throw new API_Exception("nope", 400, e);
        }
        return null;
    }

}