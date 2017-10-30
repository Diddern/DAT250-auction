package entities;

import entities.Auction;
import entities.Seller;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-27T16:13:50")
@StaticMetamodel(Bid.class)
public class Bid_ { 

    public static volatile SingularAttribute<Bid, Seller> seller;
    public static volatile SingularAttribute<Bid, Long> amount;
    public static volatile SingularAttribute<Bid, Long> id;
    public static volatile SingularAttribute<Bid, Auction> auction;

}