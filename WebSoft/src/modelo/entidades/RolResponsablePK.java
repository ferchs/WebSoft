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
    @Column(name = "Responsable_Estudiantes")
    private int responsableEstudiantes;
    @Basic(optional = false)
    @Column(name = "Responsable_Personas")
    private int responsablePersonas;

    public RolResponsablePK() {
    }

    public RolResponsablePK(int rolidrol, int responsableEstudiantes, int responsablePersonas) {
        this.rolidrol = rolidrol;
        this.responsableEstudiantes = responsableEstudiantes;
        this.responsablePersonas = responsablePersonas;
    }

    public int getRolidrol() {
        return rolidrol;
    }

    public void setRolidrol(int rolidrol) {
        this.rolidrol = rolidrol;
    }

    public int getResponsableEstudiantes() {
        return responsableEstudiantes;
    }

    public void setResponsableEstudiantes(int responsableEstudiantes) {
        this.responsableEstudiantes = responsableEstudiantes;
    }

    public int getResponsablePersonas() {
        return responsablePersonas;
    }

    public void setResponsablePersonas(int responsablePersonas) {
        this.responsablePersonas = responsablePersonas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolidrol;
        hash += (int) responsableEstudiantes;
        hash += (int) responsablePersonas;
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
        if (this.responsableEstudiantes != other.responsableEstudiantes) {
            return false;
        }
        if (this.responsablePersonas != other.responsablePersonas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.RolResponsablePK[ rolidrol=" + rolidrol + ", responsableEstudiantes=" + responsableEstudiantes + ", responsablePersonas=" + responsablePersonas + " ]";
    }
    
}
