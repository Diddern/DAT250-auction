/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.AuctionFacade;
import boundary.BidFacade;
import boundary.SellerFacade;
import entities.Auction;
import entities.Bid;
import entities.Seller;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author kristianrosland
 */
@Named(value = "BidView")
@RequestScoped
public class BidView {

    @EJB
    private BidFacade bidFacade;
    @EJB
    private AuctionFacade auctionFacade;
    @EJB
    private SellerFacade sellerFacade;
    private Bid bid;

    @ManagedProperty(value = "#{param.currentBid}")
    private Long currentBid;
    @ManagedProperty(value = "#{param.minimumPrice}")
    private Long minimumPrice;
    
    public BidView() {
        this.bid = new Bid();
    }
    
    public Long getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Long currentBid) {
        this.currentBid = currentBid;
    }

    public Long getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Long minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public String postBid() {
        String userId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user_id");
        String auctionId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("auction_id");
        
        try {
            Long auction_id = Long.parseLong(auctionId);
            Long user_id = Long.parseLong(userId);
            Auction auction = auctionFacade.find(auction_id);
            Seller seller = sellerFacade.find(user_id);
            
            if (auction.getBid() != null) {
                if (this.bid.getAmount() <= auction.getBid().getAmount()) {
                    //Set message that indicates bid too small
                    displayError("Bid must be bigger than the current bid of $" + auction.getBid().getAmount());
                    return "productView.xhtml?faces-redirect=true&id="+auction_id;
                }
            } else if (auction.getMin_price() != null && this.bid.getAmount() < auction.getMin_price()) {
                //set message that bid is too small
                displayError("Bid must be bigger than the minimum bid of $" + auction.getMin_price());
                return "productView.xhtml?faces-redirect=true&id="+auction_id;
            }
               
            auction.setBid(this.bid);
            auctionFacade.edit(auction);
            this.bid.setAuction(auction);
            this.bid.setSeller(seller);
            this.bidFacade.create(this.bid);
            this.bid = new Bid(); //Reset bid
        } catch (NumberFormatException nfe) {
            displayError("Bid must contain only numbers");
        }
        return "productView.xhtml?faces-redirect=true&id="+auctionId;
    }

    private void displayError(String errorMsg) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, errorMsg, null));
    }
}
