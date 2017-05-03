/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ferchs
 */
@Embeddable
public class EvaluacionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Consecutivo")
    private int consecutivo;
    @Basic(optional = false)
    @Column(name = "Fecha_Materia-En-Curso")
    @Temporal(TemporalType.DATE)
    private Date fechaMateriaEnCurso;
    @Basic(optional = false)
    @Column(name = "Institucion")
    private int institucion;
    @Basic(optional = false)
    @Column(name = "Salon")
    private int salon;
    @Basic(optional = false)
    @Column(name = "Jornada")
    private int jornada;
    @Basic(optional = false)
    @Column(name = "Materia")
    private int materia;

    public EvaluacionesPK() {
    }

    public EvaluacionesPK(int consecutivo, Date fechaMateriaEnCurso, int institucion, int salon, int jornada, int materia) {
        this.consecutivo = consecutivo;
        this.fechaMateriaEnCurso = fechaMateriaEnCurso;
        this.institucion = institucion;
        this.salon = salon;
        this.jornada = jornada;
        this.materia = materia;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFechaMateriaEnCurso() {
        return fechaMateriaEnCurso;
    }

    public void setFechaMateriaEnCurso(Date fechaMateriaEnCurso) {
        this.fechaMateriaEnCurso = fechaMateriaEnCurso;
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

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consecutivo;
        hash += (fechaMateriaEnCurso != null ? fechaMateriaEnCurso.hashCode() : 0);
        hash += (int) institucion;
        hash += (int) salon;
        hash += (int) jornada;
        hash += (int) materia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionesPK)) {
            return false;
        }
        EvaluacionesPK other = (EvaluacionesPK) object;
        if (this.consecutivo != other.consecutivo) {
            return false;
        }
        if ((this.fechaMateriaEnCurso == null && other.fechaMateriaEnCurso != null) || (this.fechaMateriaEnCurso != null && !this.fechaMateriaEnCurso.equals(other.fechaMateriaEnCurso))) {
            return false;
        }
        if (this.institucion != other.institucion) {
            return false;
        }
        if (this.salon != other.salon) {
            return false;
        }
        if (this.jornada != other.jornada) {
            return false;
        }
        if (this.materia != other.materia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.EvaluacionesPK[ consecutivo=" + consecutivo + ", fechaMateriaEnCurso=" + fechaMateriaEnCurso + ", institucion=" + institucion + ", salon=" + salon + ", jornada=" + jornada + ", materia=" + materia + " ]";
    }
    
}
