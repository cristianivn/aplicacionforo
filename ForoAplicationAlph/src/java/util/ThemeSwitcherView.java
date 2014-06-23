/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author cristian
 */
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
///import org.primefaces.showcase.domain.Theme;
//import org.primefaces.showcase.service.ThemeService;
 
@Named("themeswit")
@SessionScoped
public class ThemeSwitcherView implements Serializable{
 
 private Map<String, String> themes;
    private String theme;
    private GuestPreferences gp = new GuestPreferences();

    public void setGp(GuestPreferences gp) {
        this.gp = gp;
    }

    public Map<String, String> getThemes() {
        return themes;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    /** Creates a new instance of ThemeSwitcherMB */
    public ThemeSwitcherView() {

        theme = gp.getTheme();
        gp.setTheme("blitzer");

        themes = new TreeMap<String, String>();
        themes.put("Hot-Sneaks", "hot-sneaks");
        themes.put("Aristo", "aristo");
        themes.put("Blitzer", "blitzer");
        themes.put("Vader", "vader");
        themes.put("Redmond", "redmond");
        themes.put("Overcast", "overcast");
        
    }

    public void saveTheme() {
        System.out.println("theme: " + theme);
        gp.setTheme(theme);
    }
}
