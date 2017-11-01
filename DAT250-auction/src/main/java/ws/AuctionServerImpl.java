package ws;

import entities.Auction;
import entities.Bid;
import entities.Message;
import java.util.List;
import javax.jws.WebService;
import boundary.AuctionFacade;
import entities.Category;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@WebService
public class AuctionServerImpl implements AuctionServer{
    
@EJB
private AuctionFacade auctionFacade;

@PersistenceContext
private EntityManager em;
    
    public List<Auction> getActiveAuctions(){
        return auctionFacade.getAllActiveAuctions();
    }
    
    public List<Category> getCategories(){
        Query q = em.createQuery("SELECT c FROM Category c");
        //System.out.println((List<Auction>)q.getResultList());
        return (List<Category>)q.getResultList();
    }
    
    public Message bidForAuction(Bid newBid){
        return null;
    }
    
    public String test(){
        return "IT WORKS!!!!";
    }
}