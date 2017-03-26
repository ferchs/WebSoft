/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ferchs
 */
@Embeddable
public class RolResponsablePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Rol_id_rol")
    private int rolidrol;
    @Basic(optional = false)
    @Column(name = "Personas_Id")
    private String personasId;
    @Basic(optional = false)
    @Column(name = "Estudiante")
    private String estudiante;

    public RolResponsablePK() {
    }

    public RolResponsablePK(int rolidrol, String personasId, String estudiante) {
        this.rolidrol = rolidrol;
        this.personasId = personasId;
        this.estudiante = estudiante;
    }

    public int getRolidrol() {
        return rolidrol;
    }

    public void setRolidrol(int rolidrol) {
        this.rolidrol = rolidrol;
    }

    public String getPersonasId() {
        return personasId;
    }

    public void setPersonasId(String personasId) {
        this.personasId = personasId;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolidrol;
        hash += (personasId != null ? personasId.hashCode() : 0);
        hash += (estudiante != null ? estudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolResponsablePK)) {
            return false;
        }
        RolResponsablePK other = (RolResponsablePK) object;
        if (this.rolidrol != other.rolidrol) {
            return false;
        }
        if ((this.personasId == null && other.personasId != null) || (this.personasId != null && !this.personasId.equals(other.personasId))) {
            return false;
        }
        if ((this.estudiante == null && other.estudiante != null) || (this.estudiante != null && !this.estudiante.equals(other.estudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.RolResponsablePK[ rolidrol=" + rolidrol + ", personasId=" + personasId + ", estudiante=" + estudiante + " ]";
    }
    
}
