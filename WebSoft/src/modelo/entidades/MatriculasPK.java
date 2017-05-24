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
public class MatriculasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Estudiante")
    private String estudiante;
    @Basic(optional = false)
    @Column(name = "Grado")
    private int grado;
    @Basic(optional = false)
    @Column(name = "Institucion")
    private int institucion;
    @Basic(optional = false)
    @Column(name = "Cursos_consecutivo")
    private int cursosconsecutivo;

    public MatriculasPK() {
    }

    public MatriculasPK(String estudiante, int grado, int institucion, int cursosconsecutivo) {
        this.estudiante = estudiante;
        this.grado = grado;
        this.institucion = institucion;
        this.cursosconsecutivo = cursosconsecutivo;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getInstitucion() {
        return institucion;
    }

    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

    public int getCursosconsecutivo() {
        return cursosconsecutivo;
    }

    public void setCursosconsecutivo(int cursosconsecutivo) {
        this.cursosconsecutivo = cursosconsecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiante != null ? estudiante.hashCode() : 0);
        hash += (int) grado;
        hash += (int) institucion;
        hash += (int) cursosconsecutivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculasPK)) {
            return false;
        }
        MatriculasPK other = (MatriculasPK) object;
        if ((this.estudiante == null && other.estudiante != null) || (this.estudiante != null && !this.estudiante.equals(other.estudiante))) {
            return false;
        }
        if (this.grado != other.grado) {
            return false;
        }
        if (this.institucion != other.institucion) {
            return false;
        }
        if (this.cursosconsecutivo != other.cursosconsecutivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.MatriculasPK[ estudiante=" + estudiante + ", grado=" + grado + ", institucion=" + institucion + ", cursosconsecutivo=" + cursosconsecutivo + " ]";
    }
    
}
