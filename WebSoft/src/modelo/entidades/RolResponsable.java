/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Rol_Responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolResponsable.findAll", query = "SELECT r FROM RolResponsable r")
    , @NamedQuery(name = "RolResponsable.findByRolidrol", query = "SELECT r FROM RolResponsable r WHERE r.rolResponsablePK.rolidrol = :rolidrol")
    , @NamedQuery(name = "RolResponsable.findByPersonasId", query = "SELECT r FROM RolResponsable r WHERE r.rolResponsablePK.personasId = :personasId")
    , @NamedQuery(name = "RolResponsable.findByEstudiante", query = "SELECT r FROM RolResponsable r WHERE r.rolResponsablePK.estudiante = :estudiante")
    , @NamedQuery(name = "RolResponsable.findByProfesion", query = "SELECT r FROM RolResponsable r WHERE r.profesion = :profesion")
    , @NamedQuery(name = "RolResponsable.findByEmpresa", query = "SELECT r FROM RolResponsable r WHERE r.empresa = :empresa")})
public class RolResponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolResponsablePK rolResponsablePK;
    @Column(name = "profesion")
    private String profesion;
    @Column(name = "empresa")
    private String empresa;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumn(name = "Personas_Id", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personas personas;
    @JoinColumn(name = "Rol_id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;

    public RolResponsable() {
    }

    public RolResponsable(RolResponsablePK rolResponsablePK) {
        this.rolResponsablePK = rolResponsablePK;
    }

    public RolResponsable(int rolidrol, String personasId, String estudiante) {
        this.rolResponsablePK = new RolResponsablePK(rolidrol, personasId, estudiante);
    }

    public RolResponsablePK getRolResponsablePK() {
        return rolResponsablePK;
    }

    public void setRolResponsablePK(RolResponsablePK rolResponsablePK) {
        this.rolResponsablePK = rolResponsablePK;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolResponsablePK != null ? rolResponsablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolResponsable)) {
            return false;
        }
        RolResponsable other = (RolResponsable) object;
        if ((this.rolResponsablePK == null && other.rolResponsablePK != null) || (this.rolResponsablePK != null && !this.rolResponsablePK.equals(other.rolResponsablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.RolResponsable[ rolResponsablePK=" + rolResponsablePK + " ]";
    }
    
}
