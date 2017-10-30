/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Auction;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kristianrosland
 */
@Stateless
public class AuctionFacade extends AbstractFacade<Auction> {

    @PersistenceContext(unitName = "jdbcReamlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuctionFacade() {
        super(Auction.class);
    }
    
    public List<Auction> getAllActiveAuctions() {
        long now = System.currentTimeMillis();
        return this.findAll()
                .stream()
                .filter(a -> a.getUnix_end_time() > now)
                .filter(a -> a.isIsActive())
                .sorted((a,b) -> Long.compare(a.getUnix_end_time(), b.getUnix_end_time()))
                .collect(Collectors.toList());
    }
    
}
