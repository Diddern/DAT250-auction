package rest;

import boundary.AuctionFacade;
import entities.Auction;
import entities.Category;
import entities.Seller;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.*;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {
    
    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private AuctionFacade auctionFacade;
    
    //https://localhost:8181/DAT250-auction/resources/MyRestService/sayHello
    
    @GET
    @Path("/sayHello")
    public String getHelloMsg() {
        return "Hello World";
    }
    
    @GET
    @Path("/auctions")
    @Produces(MediaType.APPLICATION_XML)
    public List<Seller> getAuctions() throws Exception{
        
        Query q = em.createQuery("SELECT s FROM Seller s");
        //System.out.println((List<Auction>)q.getResultList());
        return (List<Seller>)q.getResultList();
        
        /*List<Auction> list = new ArrayList<>();
        list.add(new Auction(100L, "Katt", "En badass katt", 1000L, 999L));
        list.add(new Auction(253L, "Fisk", "Blub blub MFs", 50L, 12345L));
                
        return list;*/
        //System.out.println(auctionFacade.getAllActiveAuctions());
        //return auctionFacade.getAllActiveAuctions();
        
    }
    
    @GET
    @Path("/auction")
    @Produces(MediaType.APPLICATION_XML)
    public Auction getAuction(){
        
        //Query q = em.createQuery("SELECT auction FROM Auction auction WHERE id = 4501");
        Auction q = em.find(Auction.class, 4705L);
        System.out.println(q);
        return q;
        
        /*List<Auction> list = new ArrayList<>();
        list.add(new Auction(100L, "Katt", "En badass katt", 1000L, 999L));
        list.add(new Auction(253L, "Fisk", "Blub blub MFs", 50L, 12345L));
                
        return list;*/
        
    }
    
    
}

