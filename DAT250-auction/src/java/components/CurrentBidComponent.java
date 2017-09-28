/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Auction;
import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author kristianrosland
 */
@FacesComponent(createTag = true, tagName="currentBidComponent", namespace="http://example.com")
public class CurrentBidComponent extends UIComponentBase {

    @Override
    public String getFamily() {
        return "currentBid";
    }
    
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        Object obj = getAttributes().get("auction");
        if (obj != null && obj instanceof Auction) {
            Auction auction = (Auction) obj;
            
            writer.startElement("p class=\"bid-heading\"", this);
            String heading, amount;
            if (auction.getBid() != null) {
                heading = "Current bid";
                amount = auction.getBid().getAmount().toString();
            }
            else {
                heading = "Minimum bid";
                amount = auction.getMin_price().toString();
            } 
            
            writer.write(heading);
            writer.endElement("p");
            writer.startElement("p class=\"bid-amount\"", this);
            writer.write("$" + amount);
            writer.endElement("p");
        } else {
            writer.startElement("p", this);
            writer.write("No auction present");
            writer.endElement("p");
        }
    }
}
