
package my.presentation;

import boundary.AuctionFacade;
import entities.Auction;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kristianrosland
 */
@Named(value = "AuctionView")
@RequestScoped
public class AuctionView {

    @EJB
    private AuctionFacade auctionFacade;
    private Auction auction;
    
    /**
     * Creates a new instance of AuctionView
     */
    public AuctionView() {
        this.auction = new Auction();
    }
    
    public Auction getAuction() {
        return this.auction;
    }
    
    public void setAuction(Auction auction) {
        this.auction = auction;
    }
        
    public List<Auction> getAllAuctions() {
        long now = System.currentTimeMillis();
        return auctionFacade.findAll()
                .stream()
                .filter(a -> a.getUnix_end_time() > now)
                .sorted((a,b) -> Long.compare(a.getUnix_end_time(), b.getUnix_end_time()))
                .collect(Collectors.toList());
    }
    
    public String index() {
        return "index";
    }
    
    public Auction getSingleAuction(Long singleAuctionId) {
        if (singleAuctionId == null) return null;
        return this.auctionFacade.find(singleAuctionId);
    }
    
    public String postAuction() {
        this.auctionFacade.create(this.auction);
        return "auctionPosted";
    }
}
