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
    @Column(name = "Grados_idGrado")
    private int gradosidGrado;
    @Basic(optional = false)
    @Column(name = "Grados_Instituciones_nit")
    private int gradosInstitucionesnit;
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private int consecutivo;

    public CursosPK() {
    }

    public CursosPK(int gradosidGrado, int gradosInstitucionesnit, int consecutivo) {
        this.gradosidGrado = gradosidGrado;
        this.gradosInstitucionesnit = gradosInstitucionesnit;
        this.consecutivo = consecutivo;
    }

    public int getGradosidGrado() {
        return gradosidGrado;
    }

    public void setGradosidGrado(int gradosidGrado) {
        this.gradosidGrado = gradosidGrado;
    }

    public int getGradosInstitucionesnit() {
        return gradosInstitucionesnit;
    }

    public void setGradosInstitucionesnit(int gradosInstitucionesnit) {
        this.gradosInstitucionesnit = gradosInstitucionesnit;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gradosidGrado;
        hash += (int) gradosInstitucionesnit;
        hash += (int) consecutivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosPK)) {
            return false;
        }
        CursosPK other = (CursosPK) object;
        if (this.gradosidGrado != other.gradosidGrado) {
            return false;
        }
        if (this.gradosInstitucionesnit != other.gradosInstitucionesnit) {
            return false;
        }
        if (this.consecutivo != other.consecutivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CursosPK[ gradosidGrado=" + gradosidGrado + ", gradosInstitucionesnit=" + gradosInstitucionesnit + ", consecutivo=" + consecutivo + " ]";
    }
    
}
