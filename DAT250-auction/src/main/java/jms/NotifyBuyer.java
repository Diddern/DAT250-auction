/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author kristianrosland
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "myTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myTopic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "myTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class NotifyBuyer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String email = "Sporty.sportsmann@hotmail.com"; // message.getStringProperty("email");
        String product = "iPhone X"; // message.getStringProperty("product_name");
        String url = "https://localhost:8181/productView..."; // message.getStringProperty("url");

        System.out.printf("---- START EMAIL to customer %s ----"
                + "Dear %s %n%n"
                + "Congratulations! You have won in bidding for product %s %n%n"
                + "You can access the product using the following link: %n"
                + "URL=%s%n%n"
                + "---- END EMAIL to customer %s ----%n%n",
                email, email, product, url, email);
    }
}
