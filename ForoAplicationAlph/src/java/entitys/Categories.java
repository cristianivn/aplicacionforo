/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByIdCategories", query = "SELECT c FROM Categories c WHERE c.idCategories = :idCategories"),
    @NamedQuery(name = "Categories.findByCategory", query = "SELECT c FROM Categories c WHERE c.category = :category")})
public class Categories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategories")
    private Integer idCategories;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "category")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategories")
    private List<Questions> questionsList;

    public Categories() {
    }

    public Categories(Integer idCategories) {
        this.idCategories = idCategories;
    }

    public Categories(Integer idCategories, String category) {
        this.idCategories = idCategories;
        this.category = category;
    }

    public Integer getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Integer idCategories) {
        this.idCategories = idCategories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlTransient
    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategories != null ? idCategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.idCategories == null && other.idCategories != null) || (this.idCategories != null && !this.idCategories.equals(other.idCategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Categories[ idCategories=" + idCategories + " ]";
    }
    
}
