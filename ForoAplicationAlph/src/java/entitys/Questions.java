/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
    @NamedQuery(name = "Questions.findByIdQuestions", query = "SELECT q FROM Questions q WHERE q.idQuestions = :idQuestions"),
    @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question"),
    @NamedQuery(name = "Questions.findByDate", query = "SELECT q FROM Questions q WHERE q.date = :date")})
public class Questions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuestions")
    private Integer idQuestions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestions")
    private List<Answers> answersList;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users username;
    @JoinColumn(name = "idCategories", referencedColumnName = "idCategories")
    @ManyToOne(optional = false)
    private Categories idCategories;

    public Questions() {
    }

    public Questions(Integer idQuestions) {
        this.idQuestions = idQuestions;
    }

    public Questions(Integer idQuestions, String question, Date date) {
        this.idQuestions = idQuestions;
        this.question = question;
        this.date = date;
    }

    public Integer getIdQuestions() {
        return idQuestions;
    }

    public void setIdQuestions(Integer idQuestions) {
        this.idQuestions = idQuestions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDate() {
        
     SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy HH:mm:ss");   
       String d= format.format(date);
        return d;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    public Categories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Categories idCategories) {
        this.idCategories = idCategories;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestions != null ? idQuestions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.idQuestions == null && other.idQuestions != null) || (this.idQuestions != null && !this.idQuestions.equals(other.idQuestions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Questions[ idQuestions=" + idQuestions + " ]";
    }
    
}
