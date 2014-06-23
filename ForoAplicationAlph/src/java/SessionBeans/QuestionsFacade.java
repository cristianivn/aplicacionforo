/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.Answers;
import entitys.Categories;
import entitys.Questions;
import entitys.Users;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class QuestionsFacade extends AbstractFacade<Questions> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionsFacade() {
        super(Questions.class);
    }

public List<Questions> listaq (String cat){
  List<Questions> list;     
 Query consult =em.createQuery("SELECT t FROM Questions t WHERE t.idCategories.category = :category");

consult.setParameter("category", cat);
 list=consult.getResultList();
   
    return list;


}

  public boolean create (String question, String date, String username, int categoria){
  
 try{ 
     Date date1 = new Date();
  Questions q = new Questions();
  Users u = new Users();
  Categories cat=new Categories();
  u.setUsername(username);
  cat.setIdCategories(categoria);
  
  q.setQuestion(question);
  q.setDate(date1);
  q.setIdCategories(cat);
  q.setUsername(u);
   em.persist(q);
   return true;
 }
 catch(Exception e){
 return false;
 }
  
  }
  
    
}
