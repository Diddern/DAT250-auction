/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.SellerFacade;
import entities.Seller;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ady
 */
@Named(value = "SellerView")
@RequestScoped
public class SellerView {

    private Seller seller;
    @EJB
    private SellerFacade sellerFacade;

    /**
     * Creates a new instance of SellerView
     */
    public SellerView() {
        this.seller = new Seller();
    }
    
    public Seller getSeller(){
        return seller;
    }
    
    public List<Seller> getAllSellers() {
        return sellerFacade.findAll();
    }
    
    public int getNumberOfSellers(){
        return sellerFacade.findAll().size();
    }
}
