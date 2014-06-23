/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;


import entitys.Answers;
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
public class AnswersFacade extends AbstractFacade<Answers> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnswersFacade() {
        super(Answers.class);
    }
 public boolean createAnswer (String answer, String date, String username, int idquestion)  {
 try{
      Date date1 = new Date();
  Answers an = new Answers();
  Users u = new Users();
  Questions q = new Questions();
  u.setUsername(username);
  q.setIdQuestions(idquestion);
  an.setAnswer(answer);
 an.setDate(date1);
  an.setUsername(u);
  an.setIdQuestions(q);
this.create(an);
em.flush();}catch(Exception e){return false;}
 return true;
  }   
 
 public List<Answers> listans (int id){
  List<Answers> list;     
 Query consult =em.createQuery("SELECT t FROM Answers t WHERE t.idQuestions.idQuestions = :id");

consult.setParameter("id", id);
 list=consult.getResultList();
   
     System.out.println(list);
return list;

}
 

 
}
