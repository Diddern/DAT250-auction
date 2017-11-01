package jms;
import boundary.AuctionFacade;
import entities.Auction;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.*;  
import javax.jms.*;  
  
/**
 *  A job for checking if an auction has ended and publish a topic about the winner if it has
 *  The messaging part of the code is taken from https://www.javatpoint.com/jms-tutorial 
 * 
 * @author kristianrosland
 */

public class CheckWinnersJob {  
   
    @EJB
    private static AuctionFacade auctionFacade;
    
    public static void main(String[] args) {  
        System.out.println("Starting recurrent job..");
        try  
        {   
            Properties props = new Properties();            
            Context ctx = new InitialContext(props);
            TopicConnectionFactory f = (TopicConnectionFactory) ctx.lookup("myTopicConnectionFactory");  
            TopicConnection con= f.createTopicConnection();  
            con.start();  
            
            TopicSession ses=con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  
            Topic t=(Topic)ctx.lookup("myTopic");  
            TopicPublisher publisher=ses.createPublisher(t);  
               
            //RECURRENT JOB
            while(true)  
            {  
                List<Auction> auctions = auctionFacade.getAllActiveAuctions();
                for (Auction a : auctions) {
                    String s = "";
                    if (a.getBid() != null) {
                        MapMessage msg = ses.createMapMessage();
                        msg.setString("product_name", a.getProduct_name());
                        msg.setString("url", "https://localhost:8181/DAT250-auction/faces/loggedin/productView.xhtml?id="+a.getId());
                        if (a.getSeller() != null) 
                            msg.setString("email", a.getSeller().getEmail());
                        
                        a.setIsActive(false);
                        auctionFacade.edit(a);
                        publisher.publish(msg);  
                    }
                }
                                
                try { Thread.sleep(1000); } catch (Exception e) { }
            }  
              
        }catch(JMSException | NamingException e){ 
            System.out.println("FATAL ERROR CAUSED RECURRENT JOB TO STOP: " + e.getMessage());
        }
    }
}  