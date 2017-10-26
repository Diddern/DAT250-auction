/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Seller;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ady
 */
@Stateless
public class SellerFacade extends AbstractFacade<Seller> {

    @PersistenceContext(unitName = "jdbcReamlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SellerFacade() {
        super(Seller.class);
    }
    
}