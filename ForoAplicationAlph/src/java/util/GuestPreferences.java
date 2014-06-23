/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author cristian
 */
class GuestPreferences implements Serializable{
     private String theme = "hot-sneaks"; //default

        public String getTheme() {
                Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
                if(params.containsKey("theme")) {
                        theme = params.get("theme");
                }
                
                return theme;
        }

        public void setTheme(String theme) {
                this.theme = theme;
        }
}
