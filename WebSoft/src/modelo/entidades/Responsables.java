/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "Responsables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsables.findAll", query = "SELECT r FROM Responsables r")
    , @NamedQuery(name = "Responsables.findByEstudiante", query = "SELECT r FROM Responsables r WHERE r.responsablesPK.estudiante = :estudiante")
    , @NamedQuery(name = "Responsables.findByPersona", query = "SELECT r FROM Responsables r WHERE r.responsablesPK.persona = :persona")})
public class Responsables implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsablesPK responsablesPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsables")
    private Collection<RolResponsable> rolResponsableCollection;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumn(name = "Persona", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personas personas;

    public Responsables() {
    }

    public Responsables(ResponsablesPK responsablesPK) {
        this.responsablesPK = responsablesPK;
    }

    public Responsables(int estudiante, int persona) {
        this.responsablesPK = new ResponsablesPK(estudiante, persona);
    }

    public ResponsablesPK getResponsablesPK() {
        return responsablesPK;
    }

    public void setResponsablesPK(ResponsablesPK responsablesPK) {
        this.responsablesPK = responsablesPK;
    }

    @XmlTransient
    public Collection<RolResponsable> getRolResponsableCollection() {
        return rolResponsableCollection;
    }

    public void setRolResponsableCollection(Collection<RolResponsable> rolResponsableCollection) {
        this.rolResponsableCollection = rolResponsableCollection;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsablesPK != null ? responsablesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsables)) {
            return false;
        }
        Responsables other = (Responsables) object;
        if ((this.responsablesPK == null && other.responsablesPK != null) || (this.responsablesPK != null && !this.responsablesPK.equals(other.responsablesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Responsables[ responsablesPK=" + responsablesPK + " ]";
    }
    
}
