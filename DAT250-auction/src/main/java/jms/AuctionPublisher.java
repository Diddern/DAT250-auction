package jms;

import java.util.Properties;
import javax.ejb.Stateless;

@Stateless
public class AuctionPublisher {
    
    final Properties properties = new Properties();
    final String STRING_NAME = "jms/auctionQueue";
    final String FACTORY = "java:comp/DefaultJMSConnectionFactory";
    String message;
    
    
}
