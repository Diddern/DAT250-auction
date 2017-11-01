package rest;

import boundary.AuctionFacade;
import entities.Auction;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {
    
    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private AuctionFacade auctionFacade;
    
    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_XML)
    public List<Auction> getAuctions() throws Exception{
        return auctionFacade.getAllActiveAuctions();
    }
}

