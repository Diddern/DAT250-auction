/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kristianrosland
 */
@Entity
@XmlRootElement
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product_name;
    private String description;
    private Long min_price;
    private boolean isActive = true;
    private Long unix_end_time;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;
    
    @OneToOne
    @JoinColumn(name="bid_id")
    private Bid bid;

    public Auction(Long id, String product_name, String description, Long min_price, Long unix_end_time, Category category, Seller seller, Bid bid) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.min_price = min_price;
        this.unix_end_time = unix_end_time;
        this.category = category;
        this.seller = seller;
        this.bid = bid;
    }

    public Auction(){
        
    }
    
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMin_price() {
        return min_price;
    }

    public void setMin_price(Long min_price) {
        this.min_price = min_price;
    }

    public Long getUnix_end_time() {
        return unix_end_time;
    }

    public void setUnix_end_time(Long hours) {
        this.unix_end_time = System.currentTimeMillis() + (hours * 3600 * 1000);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getRemainingTime() {
        long totalSecs = (this.unix_end_time - System.currentTimeMillis()) / 1000;
        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        String ret = hours == 0 ? "" : hours == 1 ? "1 hour, " : hours + " hours, ";
        return ret + (minutes == 1 ? "1 minute left" : minutes + " minutes left");
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auction{" + "id=" + id + ", product_name=" + product_name + ", description=" + description + ", min_price=" + min_price + ", isActive=" + isActive + ", unix_end_time=" + unix_end_time + ", category=" + category + ", seller=" + seller + ", bid=" + bid + '}';
    }

}
