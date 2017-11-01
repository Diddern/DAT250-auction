package jms;

import javax.jms.*;  
import javax.naming.InitialContext;  
import javax.naming.NamingException;

/**
 * Code for listening for topics about ended auctions
 * 
 * The messaging part of the code is taken from https://www.javatpoint.com/jms-tutorial 
 * @author kristianrosland
 */
public class Receiver {  
    
    public static void main(String[] args) {  
        try {  
            InitialContext ctx=new InitialContext();  
            TopicConnectionFactory f=(TopicConnectionFactory)ctx.lookup("myTopicConnectionFactory");  
            TopicConnection con=f.createTopicConnection();  
            con.start();  
            
            TopicSession ses=con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  
            Topic t=(Topic)ctx.lookup("myTopic");  
            TopicSubscriber receiver=ses.createSubscriber(t);  
              
            //6) register the listener object with subscriber  
            receiver.setMessageListener(new NotifyBuyer());  
            System.out.println("Waiting for winning bids..");
            
            while(true){                  
                Thread.sleep(1000);  
            }  
        }catch(InterruptedException | JMSException | NamingException e){
            e.printStackTrace();
        }  
    }  
  
}  
