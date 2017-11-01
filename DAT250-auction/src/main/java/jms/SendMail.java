/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.util.Properties;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;

/**
 *
 * @author ady
 */
public class SendMail {
    
    static final Logger logger = Logger.getLogger("SimpleMessageClient");
    
    final Properties properties = new Properties();
    final String STRING_NAME = "jms/auctionQueue";
    final String FACTORY = "java:comp/DefaultJMSConnectionFactory";
    String message;
    
    ConnectionFactory connectionFactory;
    Queue queue;
    
    public SendMail(){
        try{
            final InitialContext initialContext = new InitialContext(properties);
            
            this.connectionFactory = (ConnectionFactory) initialContext
                    .lookup(FACTORY);
            this.queue = (Queue) initialContext.lookup(STRING_NAME);
        }catch(Exception e){
            this.connectionFactory = null;
            this.queue = null;
        }
    }
     
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void sendMessage(String msg){
        try(JMSContext context = connectionFactory.createContext();){
            if(msg != null){
                context.createProducer().send(queue,msg);
            }
        }catch(Exception e){}
    }
    
    public void sendMessage(){
        try(JMSContext context = connectionFactory.createContext();){
            if(message != null){
                context.createProducer().send(queue,message);
            }
        }catch(Exception e){}
    }
}
