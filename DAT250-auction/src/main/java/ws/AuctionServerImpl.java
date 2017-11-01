package ws;

import entities.Auction;
import entities.Bid;
import java.util.List;
import javax.jws.WebService;
import boundary.AuctionFacade;
import boundary.SellerFacade;
import entities.Seller;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@WebService
public class AuctionServerImpl implements AuctionServer{ 
    @EJB
    private AuctionFacade auctionFacade;
    
    @EJB
    private SellerFacade sellerFacade;

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Auction> getActiveAuctions(){
        return auctionFacade.getAllActiveAuctions();
    }
    
    @Override
    public String bidForAuction(Long amount, Long user_id, Long auction_id){
        Auction auction = auctionFacade.find(auction_id);
        Seller seller = sellerFacade.find(user_id);
        if (auction == null || auction.getUnix_end_time() <= System.currentTimeMillis())
            return "Auction with id " + auction_id + " is not active or may not exist";
            
        if (seller == null)
            return "Invalid user id " + user_id + ", no account associated with this id";
        
        if (auction.getBid() != null && amount <= auction.getBid().getAmount())
            return "Bid too small, the current bid amount is $" + auction.getBid().getAmount();
        
        if (auction.getBid() == null && amount < auction.getMin_price()) 
            return "Bid too small, the minimum price for this auction is $" + auction.getMin_price();
        
        Bid bid = new Bid();
        bid.setAmount(amount);
        bid.setAuction(auction);
        bid.setSeller(seller);
        
        auction.setBid(bid);
        auctionFacade.edit(auction);        
        
        return "User " + seller.getName() + " bid $" + amount + " for product " + auction.getProduct_name();
    }
}