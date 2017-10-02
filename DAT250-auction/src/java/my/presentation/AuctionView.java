
package my.presentation;

import boundary.AuctionFacade;
import entities.Auction;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

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
    
    public List<Auction> getAllActiveAuctions() {
        long now = System.currentTimeMillis();
        return auctionFacade.findAll()
                .stream()
                .filter(a -> a.getUnix_end_time() > now)
                .filter(a -> a.isIsActive())
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
        
        String message = String.format("Your product %s is now up for sale under the category %s", auction.getProduct_name(), auction.getCategory().getName());
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("indexMessage", message);        
        
        return "index?faces-redirect=true";
    }
    
    public void removeAuction(Long id){
        Auction a = auctionFacade.find(id);
        a.setIsActive(false);
        auctionFacade.edit(a);
    }
}
