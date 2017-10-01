/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author kristianrosland
 */
@ManagedBean(name = "SessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    public SessionBean() { }
           
    public String getSingleProductId() {
        FacesContext context = FacesContext.getCurrentInstance();
        Object o = context.getExternalContext().getSessionMap().get("singleProductId");
        return o != null ? o.toString() : null;
    }

    public void setSingleProductId(String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("singleProductId", id);
    }
    
    public String getBidError() {
        FacesContext context = FacesContext.getCurrentInstance();
        Object o = context.getExternalContext().getSessionMap().get("bidError");
        return o != null ? o.toString() : null;
    }
}
