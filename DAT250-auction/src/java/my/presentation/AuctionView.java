/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.AuctionFacade;
import entities.Auction;
import java.util.Collections;
import java.util.Date;
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
        
    public List<Auction> getAllAuctions() {
        long now = System.currentTimeMillis();
        return auctionFacade.findAll()
                .stream()
                .filter(a -> a.getUnix_end_time() > now)
                .sorted((a,b) -> Long.compare(a.getUnix_end_time(), b.getUnix_end_time()))
                .collect(Collectors.toList());
    }
       
    public String postAuction() {
        this.auctionFacade.create(this.auction);
        return "auctionPosted";
    }
}
