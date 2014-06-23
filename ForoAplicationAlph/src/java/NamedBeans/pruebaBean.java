/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NamedBeans;

import SessionBeans.AnswersFacade;
import entitys.Answers;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cristian
 */
@Named("pr")
@SessionScoped
public class pruebaBean implements Serializable{
    @EJB AnswersFacade ansfac;
  private   int listans;

    public int getListans() {
       
        return listans;
    }

    public void setListans(int listans) {
        this.listans = listans;
    }
  
    public void act(int id){
   
     List<Answers> l;
        List<Integer> lent = null;
        l=ansfac.findAll();
   for(int i=0;i<l.size();i++){
   if(l.get(i).getIdQuestions().getIdQuestions()==id){
lent.add(l.get(i).getIdQuestions().getIdQuestions());
   }
   }
        this.listans=lent.size();
   
        System.out.println("ES EL AJAX");
    }
  public void imprime(String id){
  
      System.out.println("SIMON IMPRIMIO: "+id);
  
  }  
    

  
  
}
