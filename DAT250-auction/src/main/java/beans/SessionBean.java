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
    
    public String getBidError() {
        return getKey("bidError");
    }

    public String getIndexMessage() {
        return getKey("indexMessage");
    }

    public String getClearIndexMessage() {
        return this.getAndClearKey("indexMessage");
    }

    public String getClearBidError() {
        return this.getAndClearKey("bidError");
    }

    public String getUserId() {
        return getKey("user_id") == null ? "9871" : getKey("user_id");
    }

    private String getAndClearKey(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        Object o = context.getExternalContext().getSessionMap().get(key);
        context.getExternalContext().getSessionMap().put(key, null);
        return o != null ? o.toString() : null;
    }

    private String getKey(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        Object o = context.getExternalContext().getSessionMap().get(key);
        return o != null ? o.toString() : null;
    }
}
