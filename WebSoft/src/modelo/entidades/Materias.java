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
import javax.persistence.ManyToMany;
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
@Table(name = "Materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
    , @NamedQuery(name = "Materias.findByCodigoMateria", query = "SELECT m FROM Materias m WHERE m.codigoMateria = :codigoMateria")
    , @NamedQuery(name = "Materias.findByNombre", query = "SELECT m FROM Materias m WHERE m.nombre = :nombre")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_materia")
    private Integer codigoMateria;
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "materiasCollection")
    private Collection<Grados> gradosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materias")
    private Collection<MateriaEnCurso> materiaEnCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materias")
    private Collection<CursosImpartidos> cursosImpartidosCollection;

    public Materias() {
    }

    public Materias(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public Integer getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Grados> getGradosCollection() {
        return gradosCollection;
    }

    public void setGradosCollection(Collection<Grados> gradosCollection) {
        this.gradosCollection = gradosCollection;
    }

    @XmlTransient
    public Collection<MateriaEnCurso> getMateriaEnCursoCollection() {
        return materiaEnCursoCollection;
    }

    public void setMateriaEnCursoCollection(Collection<MateriaEnCurso> materiaEnCursoCollection) {
        this.materiaEnCursoCollection = materiaEnCursoCollection;
    }

    @XmlTransient
    public Collection<CursosImpartidos> getCursosImpartidosCollection() {
        return cursosImpartidosCollection;
    }

    public void setCursosImpartidosCollection(Collection<CursosImpartidos> cursosImpartidosCollection) {
        this.cursosImpartidosCollection = cursosImpartidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMateria != null ? codigoMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.codigoMateria == null && other.codigoMateria != null) || (this.codigoMateria != null && !this.codigoMateria.equals(other.codigoMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Materias[ codigoMateria=" + codigoMateria + " ]";
    }
    
}
