/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import entitys.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
 public Users logIn(String usuario, String clave){
 Users us=null;   
 
 try{
Query consultita =em.createQuery("SELECT t FROM Users t WHERE t.username = :usuario and t.password = :clave");
consultita.setParameter("usuario", usuario);
consultita.setParameter("clave", clave);

us=(Users) consultita.getSingleResult();
 }catch(Exception e){
 return us;
 } 
 return us;
}   
 public boolean agregar(String username,String password, String name, String lastname, String email){
Users us2=null;
 Query search1 =em.createQuery("SELECT t FROM Users t WHERE t.username = :usuario or t.email = :correo");
 search1.setParameter("usuario", username);
 search1.setParameter("correo", email);
 
 
 try{
 us2=(Users) search1.getSingleResult();
 return true;
 }
 catch(Exception e){
 Users us= new Users();
us.setUsername(username);
us.setPassword(password);
us.setName(name);
us.setLastname(lastname);
us.setEmail(email);
em.persist(us);
return false;
 
 }


}  

public void probar (String us){


    System.out.println(us);




}



}
