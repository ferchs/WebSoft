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
public class ExamenPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Consecutivo_Evaluacion")
    private int consecutivoEvaluacion;
    @Basic(optional = false)
    @Column(name = "Fecha_Evaluacion")
    @Temporal(TemporalType.DATE)
    private Date fechaEvaluacion;
    @Basic(optional = false)
    @Column(name = "Institucion")
    private int institucion;
    @Basic(optional = false)
    @Column(name = "Sede")
    private int sede;
    @Basic(optional = false)
    @Column(name = "Salon")
    private int salon;
    @Basic(optional = false)
    @Column(name = "Jornada")
    private int jornada;
    @Basic(optional = false)
    @Column(name = "Materia")
    private int materia;
    @Basic(optional = false)
    @Column(name = "Estudiante")
    private String estudiante;

    public ExamenPK() {
    }

    public ExamenPK(Date fecha, int consecutivoEvaluacion, Date fechaEvaluacion, int institucion, int sede, int salon, int jornada, int materia, String estudiante) {
        this.fecha = fecha;
        this.consecutivoEvaluacion = consecutivoEvaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
        this.institucion = institucion;
        this.sede = sede;
        this.salon = salon;
        this.jornada = jornada;
        this.materia = materia;
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getConsecutivoEvaluacion() {
        return consecutivoEvaluacion;
    }

    public void setConsecutivoEvaluacion(int consecutivoEvaluacion) {
        this.consecutivoEvaluacion = consecutivoEvaluacion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public int getInstitucion() {
        return institucion;
    }

    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
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

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) consecutivoEvaluacion;
        hash += (fechaEvaluacion != null ? fechaEvaluacion.hashCode() : 0);
        hash += (int) institucion;
        hash += (int) sede;
        hash += (int) salon;
        hash += (int) jornada;
        hash += (int) materia;
        hash += (estudiante != null ? estudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenPK)) {
            return false;
        }
        ExamenPK other = (ExamenPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.consecutivoEvaluacion != other.consecutivoEvaluacion) {
            return false;
        }
        if ((this.fechaEvaluacion == null && other.fechaEvaluacion != null) || (this.fechaEvaluacion != null && !this.fechaEvaluacion.equals(other.fechaEvaluacion))) {
            return false;
        }
        if (this.institucion != other.institucion) {
            return false;
        }
        if (this.sede != other.sede) {
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
        if ((this.estudiante == null && other.estudiante != null) || (this.estudiante != null && !this.estudiante.equals(other.estudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.ExamenPK[ fecha=" + fecha + ", consecutivoEvaluacion=" + consecutivoEvaluacion + ", fechaEvaluacion=" + fechaEvaluacion + ", institucion=" + institucion + ", sede=" + sede + ", salon=" + salon + ", jornada=" + jornada + ", materia=" + materia + ", estudiante=" + estudiante + " ]";
    }
    
}
