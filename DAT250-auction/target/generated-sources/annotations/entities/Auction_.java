package entities;

import entities.Bid;
import entities.Category;
import entities.Seller;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T15:51:37")
@StaticMetamodel(Auction.class)
public class Auction_ { 

    public static volatile SingularAttribute<Auction, Seller> seller;
    public static volatile SingularAttribute<Auction, Long> min_price;
    public static volatile SingularAttribute<Auction, Long> unix_end_time;
    public static volatile SingularAttribute<Auction, String> description;
    public static volatile SingularAttribute<Auction, Long> id;
    public static volatile SingularAttribute<Auction, Boolean> isActive;
    public static volatile SingularAttribute<Auction, Category> category;
    public static volatile SingularAttribute<Auction, Bid> bid;
    public static volatile SingularAttribute<Auction, String> product_name;

}