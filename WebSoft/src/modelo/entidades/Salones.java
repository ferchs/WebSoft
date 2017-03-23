/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Salones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salones.findAll", query = "SELECT s FROM Salones s")
    , @NamedQuery(name = "Salones.findByIdSalon", query = "SELECT s FROM Salones s WHERE s.idSalon = :idSalon")
    , @NamedQuery(name = "Salones.findByNombre", query = "SELECT s FROM Salones s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Salones.findByPiso", query = "SELECT s FROM Salones s WHERE s.piso = :piso")})
public class Salones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_salon")
    private Integer idSalon;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "piso")
    private String piso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salones")
    private Collection<Cursos> cursosCollection;

    public Salones() {
    }

    public Salones(Integer idSalon) {
        this.idSalon = idSalon;
    }

    public Integer getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(Integer idSalon) {
        this.idSalon = idSalon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    @XmlTransient
    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalon != null ? idSalon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salones)) {
            return false;
        }
        Salones other = (Salones) object;
        if ((this.idSalon == null && other.idSalon != null) || (this.idSalon != null && !this.idSalon.equals(other.idSalon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Salones[ idSalon=" + idSalon + " ]";
    }
    
}
