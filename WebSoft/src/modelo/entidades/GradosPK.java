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
public class GradosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idGrado")
    private int idGrado;
    @Basic(optional = false)
    @Column(name = "Instituciones_nit")
    private int institucionesnit;

    public GradosPK() {
    }

    public GradosPK(int idGrado, int institucionesnit) {
        this.idGrado = idGrado;
        this.institucionesnit = institucionesnit;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public int getInstitucionesnit() {
        return institucionesnit;
    }

    public void setInstitucionesnit(int institucionesnit) {
        this.institucionesnit = institucionesnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGrado;
        hash += (int) institucionesnit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradosPK)) {
            return false;
        }
        GradosPK other = (GradosPK) object;
        if (this.idGrado != other.idGrado) {
            return false;
        }
        if (this.institucionesnit != other.institucionesnit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.GradosPK[ idGrado=" + idGrado + ", institucionesnit=" + institucionesnit + " ]";
    }
    
}
