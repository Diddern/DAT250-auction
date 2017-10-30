package ws;

import entities.Auction;
import entities.Bid;
import entities.Message;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AuctionServer {
    
    @WebMethod public List<Auction> getActiveAuctions();
    @WebMethod public Message bidForAuction(Bid newBid);
    @WebMethod public String test();
    
}