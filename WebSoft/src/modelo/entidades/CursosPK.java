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
public class CursosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Institucion")
    private int institucion;
    @Basic(optional = false)
    @Column(name = "Salon")
    private int salon;
    @Basic(optional = false)
    @Column(name = "Jornada")
    private int jornada;

    public CursosPK() {
    }

    public CursosPK(int institucion, int salon, int jornada) {
        this.institucion = institucion;
        this.salon = salon;
        this.jornada = jornada;
    }

    public int getInstitucion() {
        return institucion;
    }

    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) institucion;
        hash += (int) salon;
        hash += (int) jornada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosPK)) {
            return false;
        }
        CursosPK other = (CursosPK) object;
        if (this.institucion != other.institucion) {
            return false;
        }
        if (this.salon != other.salon) {
            return false;
        }
        if (this.jornada != other.jornada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CursosPK[ institucion=" + institucion + ", salon=" + salon + ", jornada=" + jornada + " ]";
    }
    
}
