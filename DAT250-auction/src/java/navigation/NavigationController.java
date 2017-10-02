package navigation;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kristianrosland
 */

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public String goToSingleView(String id) {
        return "productView.xhtml?faces-redirect=true&id="+id;
    }
    
    public String goToHomePage() {
        return "index?faces-redirect=true";
    }
    
    public String goToMyAuctions() {
        return "myAccount?faces-redirect=true";
    }
    
    public String goToNewAuction() {
        return "createAuction?faces-redirect=true";
    }
}
