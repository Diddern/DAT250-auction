/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.AuctionFacade;
import entities.Auction;
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
       
    public String postAuction() {
        this.auctionFacade.create(this.auction);
        return "auctionPosted";
    }
}
