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
public class MatriculasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Fecha_Materia_En_Curso")
    @Temporal(TemporalType.DATE)
    private Date fechaMateriaEnCurso;
    @Basic(optional = false)
    @Column(name = "Institucion")
    private int institucion;
    @Basic(optional = false)
    @Column(name = "Sede")
    private int sede;
    @Basic(optional = false)
    @Column(name = "Jornada")
    private int jornada;
    @Basic(optional = false)
    @Column(name = "Salon")
    private int salon;
    @Basic(optional = false)
    @Column(name = "Estudiante")
    private int estudiante;

    public MatriculasPK() {
    }

    public MatriculasPK(Date fechaMateriaEnCurso, int institucion, int sede, int jornada, int salon, int estudiante) {
        this.fechaMateriaEnCurso = fechaMateriaEnCurso;
        this.institucion = institucion;
        this.sede = sede;
        this.jornada = jornada;
        this.salon = salon;
        this.estudiante = estudiante;
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

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaMateriaEnCurso != null ? fechaMateriaEnCurso.hashCode() : 0);
        hash += (int) institucion;
        hash += (int) sede;
        hash += (int) jornada;
        hash += (int) salon;
        hash += (int) estudiante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculasPK)) {
            return false;
        }
        MatriculasPK other = (MatriculasPK) object;
        if ((this.fechaMateriaEnCurso == null && other.fechaMateriaEnCurso != null) || (this.fechaMateriaEnCurso != null && !this.fechaMateriaEnCurso.equals(other.fechaMateriaEnCurso))) {
            return false;
        }
        if (this.institucion != other.institucion) {
            return false;
        }
        if (this.sede != other.sede) {
            return false;
        }
        if (this.jornada != other.jornada) {
            return false;
        }
        if (this.salon != other.salon) {
            return false;
        }
        if (this.estudiante != other.estudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.MatriculasPK[ fechaMateriaEnCurso=" + fechaMateriaEnCurso + ", institucion=" + institucion + ", sede=" + sede + ", jornada=" + jornada + ", salon=" + salon + ", estudiante=" + estudiante + " ]";
    }
    
}
