package entities;

import entities.Auction;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T15:51:37")
@StaticMetamodel(Seller.class)
public class Seller_ { 

    public static volatile SingularAttribute<Seller, String> zip;
    public static volatile SingularAttribute<Seller, Integer> phoneNumber;
    public static volatile SingularAttribute<Seller, Double> rating;
    public static volatile SingularAttribute<Seller, String> name;
    public static volatile SingularAttribute<Seller, String> adress;
    public static volatile SingularAttribute<Seller, Long> id;
    public static volatile SingularAttribute<Seller, String> email;
    public static volatile ListAttribute<Seller, Auction> auctions;

}