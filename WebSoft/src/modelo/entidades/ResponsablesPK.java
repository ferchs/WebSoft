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
public class ResponsablesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Estudiante")
    private int estudiante;
    @Basic(optional = false)
    @Column(name = "Persona")
    private int persona;

    public ResponsablesPK() {
    }

    public ResponsablesPK(int estudiante, int persona) {
        this.estudiante = estudiante;
        this.persona = persona;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estudiante;
        hash += (int) persona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsablesPK)) {
            return false;
        }
        ResponsablesPK other = (ResponsablesPK) object;
        if (this.estudiante != other.estudiante) {
            return false;
        }
        if (this.persona != other.persona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.ResponsablesPK[ estudiante=" + estudiante + ", persona=" + persona + " ]";
    }
    
}
