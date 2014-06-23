/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NamedBeans;

import SessionBeans.AnswersFacade;
import SessionBeans.QuestionsFacade;
import entitys.Answers;
import entitys.Questions;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author cristian
 */
@Named("question")
@SessionScoped
public class QuestionsBeans implements Serializable {
 
  private String question;
  private String answer;
  @EJB QuestionsFacade qfac;
  @EJB AnswersFacade anfac;
  Questions ques;
  private Questions selectques;
  @Inject UserBean usbean;
  private int idquesselect;
  private String categoryselect="General";

  private List<String> listcantans;
 private  List<Questions> listq;
  private List<Answers> listans;
 private List<Answers> answersList;

  

    public String getCategoryselect() {
        return categoryselect;
    }

    public void setCategoryselect(String categoryselect) {
        this.categoryselect = categoryselect;
    }

    public List<String> getListcantans() {
        return listcantans;
    }

    public void setListcantans(List<String> listcantans) {
        this.listcantans = listcantans;
    }

   

    public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }
 
    public int getIdquesselect() {
        return idquesselect;
    }

    public void setIdquesselect(int idquesselect) {
        this.idquesselect = idquesselect;
    }

    public Questions getSelectques() {
        return selectques;
    }

    public void setSelectques(Questions selectques) {
        this.selectques = selectques;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Answers> getListans() {
        return listans;
    }

    public void setListans(List<Answers> listans) {
        this.listans = listans;
    }
  
    public Questions getQues() {
        return ques;
    }

    public void setQues(Questions ques) {
        this.ques = ques;
    }

    public List<Questions> getListq() {
       
        return listq;
    }

    public void setListq(List<Questions> listq) {
        this.listq = listq;
    }
  
  public void createQuestion(int cat){
      boolean hecho;
      Date date = new Date();
      String dateh;
DateFormat hourFormat = new SimpleDateFormat("HH:mm");
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
 dateh= dateFormat.format(date)+" "+hourFormat.format(date);    
      System.out.println(dateh);
      System.out.println(cat);
      System.out.println("ACA PROBANDO COSAS");
      System.out.println(usbean.getUser().getUsername()); 
  hecho=qfac.create(question, dateh, usbean.getUser().getUsername(), cat);
  this.listq=qfac.listaq(categoryselect); 
  if(hecho==true){
      question="";
      System.out.println("creando msj growl");    
  
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "successful!", "Question  successfully added"));
     
    RequestContext.getCurrentInstance().update("menu:f2:growlcq");
  
  }
  else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "minimum 1 character, maximum 100"));}
  }
@PostConstruct private void init(){ 
   this.listq=qfac.listaq(categoryselect);

}  
   

 public void obteneridques(String seleccion){
     System.out.println("Obtenindo la id");
 idquesselect =Integer.parseInt(seleccion);
     System.out.println("La seleccion es:"+idquesselect);
 }
 
public void createAnswerc1() throws IOException {
  boolean flag;
    String dateh;
    Date date = new Date();
DateFormat hourFormat = new SimpleDateFormat("HH:mm");
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
dateh= dateFormat.format(date)+" "+hourFormat.format(date);  
String uname=usbean.getUser().getUsername();
String a=answer;
 flag=anfac.createAnswer(answer, dateh, uname, idquesselect);
    System.out.println(dateh+" "+uname+" "+answer+"" +idquesselect);
   //listq=qfac.listaq();
    if(flag==true){
        System.out.println("ya hice la respuesta");  
     answer="";
   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "successful!", "Answer successfully added"));
     
   RequestContext.getCurrentInstance().update("menu:f2:growlca");  
   RequestContext.getCurrentInstance().update("menu:forma:table");  
   
 
   
    }else{
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "minimum 1 character, maximum 60"));
    
    }
   
} 
 public void onRowSelect (SelectEvent event){
    //System.out.println("ENTRE A LAS SELECCC:"+(TblUsuarios) event.getObject()).getIdusuario().toString());
 String usuariosel=((Questions) event.getObject()).getIdQuestions().toString();
    System.out.println("Entre se selecciono:"+ usuariosel);
FacesMessage msg = new FacesMessage("Car Selected", ((Questions) event.getObject()).getIdQuestions().toString());
FacesContext.getCurrentInstance().addMessage(null,msg);
}
public void onRowUnselect (UnselectEvent event){
    System.out.println("QUE PASA NO SELECCIONAS");
}

public void msj(SelectEvent event) {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "successful!", "Answer added successfully")); 
    }


public void expand(String id){

    System.out.println("ID EXPANDIDA: "+id);

answersList=anfac.listans(Integer.parseInt(id));
}
public void problistAns(){

anfac.listans(2);


}
public void onCarChosen(SelectEvent event) {
    
    // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "successful!", "Answer added successfully")); 
System.out.println("AJAX CUANDO CIERRA DIALOG");
}


public String paginaGeneral (){
categoryselect="General";
this.listq=qfac.listaq(categoryselect);
return "/General.xhtml?faces-redirect=true";
}
public String paginaEndodon (){
categoryselect="Endodontics";
this.listq=qfac.listaq(categoryselect);
return "/Endodontics.xhtml?faces-redirect=true";
}
public String paginaOrthodontics(){
categoryselect="Orthodontics";
this.listq=qfac.listaq(categoryselect);
return "/Orthodontics.xhtml?faces-redirect=true";
}
public String paginaPatients(){
categoryselect="Patients";
this.listq=qfac.listaq(categoryselect);
return "/Patients.xhtml?faces-redirect=true";
}
public String paginaPeriodontics(){
categoryselect="Periodontics";
this.listq=qfac.listaq(categoryselect);
return "/Periodontics.xhtml?faces-redirect=true";
}
public String paginaRestoration(){
categoryselect="Restoration";
this.listq=qfac.listaq(categoryselect);
return "/Restoration.xhtml?faces-redirect=true";
}
public String paginaStudents(){
categoryselect="Students";
this.listq=qfac.listaq(categoryselect);
return "/Students.xhtml?faces-redirect=true";
}
public String paginaSurgery(){
categoryselect="Surgery";
this.listq=qfac.listaq(categoryselect);
return "/Surgery.xhtml?faces-redirect=true";
}
public String paginaCosmetic(){
categoryselect="Cosmetic";
this.listq=qfac.listaq(categoryselect);
return "/Cosmetic.xhtml?faces-redirect=true";
}









}
