/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entities.Category;

/**
 *
 * @author kristianrosland
 */
@FacesConverter(forClass=Category.class, value="category")
public class CategoryConverter extends EntityConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value == null || value.isEmpty() ? null : this.getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null || !(object instanceof Category)) return "";
                
        Category category = (Category) object;
        Long id = category.getId();
        
        if (id != null) {
            String stringId = String.valueOf(id.longValue());
            this.getViewMap(context).put(stringId, object);
            return stringId;
        }
        return null;
    }
}
