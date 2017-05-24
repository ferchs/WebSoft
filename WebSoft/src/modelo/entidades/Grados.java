/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Grados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grados.findAll", query = "SELECT g FROM Grados g")
    , @NamedQuery(name = "Grados.findByIdGrado", query = "SELECT g FROM Grados g WHERE g.gradosPK.idGrado = :idGrado")
    , @NamedQuery(name = "Grados.findByInstitucionesnit", query = "SELECT g FROM Grados g WHERE g.gradosPK.institucionesnit = :institucionesnit")
    , @NamedQuery(name = "Grados.findByNombre", query = "SELECT g FROM Grados g WHERE g.nombre = :nombre")})
public class Grados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GradosPK gradosPK;
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "Curriculos", joinColumns = {
        @JoinColumn(name = "Grados_idGrado", referencedColumnName = "idGrado")
        , @JoinColumn(name = "Grados_Instituciones_nit", referencedColumnName = "Instituciones_nit")}, inverseJoinColumns = {
        @JoinColumn(name = "Materias_codigo_materia", referencedColumnName = "codigo_materia")})
    @ManyToMany
    private Collection<Materias> materiasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grados")
    private Collection<Cursos> cursosCollection;
    @JoinColumn(name = "Instituciones_nit", referencedColumnName = "nit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instituciones instituciones;

    public Grados() {
    }

    public Grados(GradosPK gradosPK) {
        this.gradosPK = gradosPK;
    }

    public Grados(int idGrado, int institucionesnit) {
        this.gradosPK = new GradosPK(idGrado, institucionesnit);
    }

    public GradosPK getGradosPK() {
        return gradosPK;
    }

    public void setGradosPK(GradosPK gradosPK) {
        this.gradosPK = gradosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Materias> getMateriasCollection() {
        return materiasCollection;
    }

    public void setMateriasCollection(Collection<Materias> materiasCollection) {
        this.materiasCollection = materiasCollection;
    }

    @XmlTransient
    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    public Instituciones getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Instituciones instituciones) {
        this.instituciones = instituciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradosPK != null ? gradosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grados)) {
            return false;
        }
        Grados other = (Grados) object;
        if ((this.gradosPK == null && other.gradosPK != null) || (this.gradosPK != null && !this.gradosPK.equals(other.gradosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Grados[ gradosPK=" + gradosPK + " ]";
    }
    
}
