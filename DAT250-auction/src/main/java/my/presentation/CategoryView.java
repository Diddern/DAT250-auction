/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.CategoryFacade;
import entities.Category;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kristianrosland
 */
@Named(value = "CategoryView")
@RequestScoped
public class CategoryView {

    @EJB
    private CategoryFacade categoryFacade;
    private Category category;
    
    /**
     * Creates a new instance of CategoryView
     */
    public CategoryView() {
        this.category = new Category();
    }
    
    public List<Category> getAllCategories() {
        return this.categoryFacade.findAll();
    }
}
