/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Bid;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kristianrosland
 */
@Stateless
public class BidFacade extends AbstractFacade<Bid> {

    @PersistenceContext(unitName = "jdbcReamlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * @return true if any records were updated
     */ 
    public boolean updateSetBidAuction(String auctionId, String bidId) {
        String updateQuery = String.format("update Bid set auction_id = :a where id = :i");
        
        Query q = this.em.createQuery(updateQuery);
        
        return q.setParameter("a", auctionId).setParameter("i", bidId).executeUpdate() >= 1;
    }

    public BidFacade() {
        super(Bid.class);
    }
    
}
