package jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "jms/actionQueie"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class NotifyBuyer implements MessageListener{

    @Resource
    private MessageDrivenContext messageDrivenContext;
    static final Logger LOGGER = Logger.getLogger("SimpleMessageBean");
    
    public NotifyBuyer(){
    
    }
    
    @Override
    public void onMessage(Message message) {
        
        try{
            if(message instanceof TextMessage){
                String auctionName = "";
                String username = "";
                String auctionId = "1";
                String link = "";
                String msg = message.getBody(String.class);
                String[] info = msg.split(":");
                if(info.length == 3){
                    auctionName = info[0];
                    username = info[1];
                    auctionId = info[2];
                }
                
                /*try{
                    link = "hhtps://localhost:8181/DAT250_auction/";
                }catch(Exception e){
                
                }*/
                
                
                StringBuilder sb = new StringBuilder();
                sb.append("---- START EMAIL to customer ").append(username).append(" ---- \n");
                sb.append("Dear ").append(username).append(",\n");
                sb.append("Congratulations! You have won in bidding for ").append(auctionName).append("\n");
                sb.append("You can access the product using the following link: \n").append("").append("\n");
                sb.append("---- END EMAIL to customer ").append(username).append(" ----");
                
                
            } else {
                LOGGER.log(Level.WARNING,
                        "Message of wrong type: {0}",
                        message.getClass().getName());
            }
        } catch (JMSException e) {
            LOGGER.log(Level.SEVERE,
                    "SimpleMessageBean.onMessage: JMSException: {0}",
                    e.toString());
            messageDrivenContext.setRollbackOnly();
        }
    }
    
}
