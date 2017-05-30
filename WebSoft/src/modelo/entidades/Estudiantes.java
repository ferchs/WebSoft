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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findByPersonasnumeroidentificacion", query = "SELECT e FROM Estudiantes e WHERE e.personasnumeroidentificacion = :personasnumeroidentificacion")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Personas_numero_identificacion")
    private String personasnumeroidentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<RolResponsable> rolResponsableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<Examenes> examenesCollection;
    @JoinColumn(name = "Personas_numero_identificacion", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personas personas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<MateriaEnCurso> materiaEnCursoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Matriculas matriculas;

    public Estudiantes() {
    }

    public Estudiantes(String personasnumeroidentificacion) {
        this.personasnumeroidentificacion = personasnumeroidentificacion;
    }

    public String getPersonasnumeroidentificacion() {
        return personasnumeroidentificacion;
    }

    public void setPersonasnumeroidentificacion(String personasnumeroidentificacion) {
        this.personasnumeroidentificacion = personasnumeroidentificacion;
    }

    @XmlTransient
    public Collection<RolResponsable> getRolResponsableCollection() {
        return rolResponsableCollection;
    }

    public void setRolResponsableCollection(Collection<RolResponsable> rolResponsableCollection) {
        this.rolResponsableCollection = rolResponsableCollection;
    }

    @XmlTransient
    public Collection<Examenes> getExamenesCollection() {
        return examenesCollection;
    }

    public void setExamenesCollection(Collection<Examenes> examenesCollection) {
        this.examenesCollection = examenesCollection;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @XmlTransient
    public Collection<MateriaEnCurso> getMateriaEnCursoCollection() {
        return materiaEnCursoCollection;
    }

    public void setMateriaEnCursoCollection(Collection<MateriaEnCurso> materiaEnCursoCollection) {
        this.materiaEnCursoCollection = materiaEnCursoCollection;
    }

    public Matriculas getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Matriculas matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personasnumeroidentificacion != null ? personasnumeroidentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.personasnumeroidentificacion == null && other.personasnumeroidentificacion != null) || (this.personasnumeroidentificacion != null && !this.personasnumeroidentificacion.equals(other.personasnumeroidentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Estudiantes[ personasnumeroidentificacion=" + personasnumeroidentificacion + " ]";
    }
    
}
