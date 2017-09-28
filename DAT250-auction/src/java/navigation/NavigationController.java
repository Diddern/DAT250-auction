package navigation;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kristianrosland
 */

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value="#{param.singleAuctionId}") //used when going from main view to single view
    private Long singleAuctionId;

    public Long getSingleAuctionId() {
        return singleAuctionId;
    }

    public void setSingleAuctionId(Long singleAuctionId) {
        this.singleAuctionId = singleAuctionId;
    }
    
    public String goToSingleView() {
        if (singleAuctionId == null)
            return "index";
        else
            return "productView";
    }
    
    public String goToHomePage() {
        return "index";
    }
}
