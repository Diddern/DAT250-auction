package ws;

import entities.Auction;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AuctionServer {
    
    @WebMethod public List<Auction> getActiveAuctions();
    @WebMethod public String bidForAuction(Long amount, Long user_id, Long auction_id);
        
}