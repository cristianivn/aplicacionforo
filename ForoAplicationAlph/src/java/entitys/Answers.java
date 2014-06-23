/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a"),
    @NamedQuery(name = "Answers.findByIdAnswers", query = "SELECT a FROM Answers a WHERE a.idAnswers = :idAnswers"),
    @NamedQuery(name = "Answers.findByAnswer", query = "SELECT a FROM Answers a WHERE a.answer = :answer"),
    @NamedQuery(name = "Answers.findByDate", query = "SELECT a FROM Answers a WHERE a.date = :date")})
public class Answers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnswers")
    private Integer idAnswers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "answer")
    private String answer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users username;
    @JoinColumn(name = "idQuestions", referencedColumnName = "idQuestions")
    @ManyToOne(optional = false)
    private Questions idQuestions;

    public Answers() {
    }

    public Answers(Integer idAnswers) {
        this.idAnswers = idAnswers;
    }

    public Answers(Integer idAnswers, String answer, Date date) {
        this.idAnswers = idAnswers;
        this.answer = answer;
        this.date = date;
    }

    public Integer getIdAnswers() {
        return idAnswers;
    }

    public void setIdAnswers(Integer idAnswers) {
        this.idAnswers = idAnswers;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy HH:mm:ss");   
       String d= format.format(date);
        return d;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    public Questions getIdQuestions() {
        return idQuestions;
    }

    public void setIdQuestions(Questions idQuestions) {
        this.idQuestions = idQuestions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnswers != null ? idAnswers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answers)) {
            return false;
        }
        Answers other = (Answers) object;
        if ((this.idAnswers == null && other.idAnswers != null) || (this.idAnswers != null && !this.idAnswers.equals(other.idAnswers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Answers[ idAnswers=" + idAnswers + " ]";
    }
    
}
