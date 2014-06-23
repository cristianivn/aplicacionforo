/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NamedBeans;

import SessionBeans.QuestionsFacade;
import SessionBeans.UsersFacade;
import entitys.Users;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author cristian
 */
@Named("user")
@SessionScoped
public class UserBean  implements Serializable{
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    List<Users> lista;
@EJB UsersFacade usfac;
@EJB QuestionsFacade qfac;
Users user;
@Inject QuestionsBeans qbean;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Users> getLista() {
        this.lista=usfac.findAll();
        return lista;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
  public String  login(){
   
 // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o contraseña invalido"));
    user=usfac.logIn(username, password);
     
    if(user!=null){
    username="";
    password="";
    qbean.setListq(qfac.listaq("General"));
    
    
    return "/General.xhtml?faces-redirect=true";
  
    }
    
    else{
    password="";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Invalid user or password"));
    return null;
    }
 
 }
 public void regitrar(){
 boolean existente;
 UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("registerform:us");
 UIInput compPass = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("registerform:pass");
   System.out.println(compUsuario.getValue().toString()+ compPass.getValue().toString());
   existente=usfac.agregar(compUsuario.getValue().toString(), compPass.getValue().toString(), name, lastname, email);
    if(existente==true) {
    //aqui ponemos mensaje, usuario o correo existentes
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Username or Email already in use"));
    
    
    }else{
   //usuario agregado con EXITO!!!!
   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "User "+compUsuario.getValue().toString()+" successfully created"));
 
       Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 170);
        options.put("closable", false);

        RequestContext.getCurrentInstance().openDialog("/dialog/ans1", options, null); 
   
 username=compUsuario.getValue().toString();
password=compPass.getValue().toString();
 UIOutput compUs = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("registerform:us");
 UIOutput compPa = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("registerform:pass");
compUs.setValue("");
compPa.setValue("");
   name="";
   lastname="";
   email="";
    }
 } 
  
  public void prueba1(){
      System.out.println("entrando con el overlay");
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Usuario agregado con exito!"));
   
   RequestContext.getCurrentInstance().update("f2:growl");
  
  
  }
  public String logOut(){
  
  user=null;
  qbean.setCategoryselect("General");
  return "login.xhtml?faces-redirect=true";
  }
  public void verificar(ComponentSystemEvent e) {

        System.out.println("entro");
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();
        String valor = null;

        try {
            valor = user.getUsername();
           // System.out.println("Valor= "+valor);
        } catch (NullPointerException c) {
        }
       // System.out.print("Dato:" + valor);

        if (valor == null) {
            try {

                fc.redirect("errorpage.xhtml");

            } catch (IOException ex) {
                // Logger.getLogger(redireccion.class.getName()).log(Level.SEVERE,null,ex);

            }
        }

    }
   public void idleListener() {
      //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
        //        "Sesion cerrada", "Has estado oculto durante los ultimos 5 segundos"));

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       // return "faces/logIn.xhtml?faces-redirect=true";

        FacesContext ctx = FacesContext.getCurrentInstance();

        ExternalContext extContext = ctx.getExternalContext();
        String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/login.xhtml"));
       
               
        try {
         user= null;
            extContext.redirect(url);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
//"faces/uicomposition/logIn.xhtml?faces-redirect=true");
         //return "/uicomposition/logIn.xhtml?faces-redirect=true";
            //invalidate session
        }
   
 public void irloginafterreg(){
 
 username="";
 password="";
 RequestContext.getCurrentInstance().closeDialog(null);

 } 
 public void redirectLog() throws IOException{
     
 ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();
 fc.redirect("login.xhtml");  
     
     }

}
