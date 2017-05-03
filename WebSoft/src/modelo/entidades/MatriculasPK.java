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
    @Column(name = "Estudiante")
    private String estudiante;
    @Basic(optional = false)
    @Column(name = "Materia_En_Curso_fecha")
    @Temporal(TemporalType.DATE)
    private Date materiaEnCursofecha;
    @Basic(optional = false)
    @Column(name = "Materia_En_Curso_Salon")
    private int materiaEnCursoSalon;
    @Basic(optional = false)
    @Column(name = "Materia_En_Curso_Institucion")
    private int materiaEnCursoInstitucion;
    @Basic(optional = false)
    @Column(name = "Materia_En_Curso_Jornada")
    private int materiaEnCursoJornada;
    @Basic(optional = false)
    @Column(name = "Materia_En_Curso_Materia")
    private int materiaEnCursoMateria;

    public MatriculasPK() {
    }

    public MatriculasPK(String estudiante, Date materiaEnCursofecha, int materiaEnCursoSalon, int materiaEnCursoInstitucion, int materiaEnCursoJornada, int materiaEnCursoMateria) {
        this.estudiante = estudiante;
        this.materiaEnCursofecha = materiaEnCursofecha;
        this.materiaEnCursoSalon = materiaEnCursoSalon;
        this.materiaEnCursoInstitucion = materiaEnCursoInstitucion;
        this.materiaEnCursoJornada = materiaEnCursoJornada;
        this.materiaEnCursoMateria = materiaEnCursoMateria;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public Date getMateriaEnCursofecha() {
        return materiaEnCursofecha;
    }

    public void setMateriaEnCursofecha(Date materiaEnCursofecha) {
        this.materiaEnCursofecha = materiaEnCursofecha;
    }

    public int getMateriaEnCursoSalon() {
        return materiaEnCursoSalon;
    }

    public void setMateriaEnCursoSalon(int materiaEnCursoSalon) {
        this.materiaEnCursoSalon = materiaEnCursoSalon;
    }

    public int getMateriaEnCursoInstitucion() {
        return materiaEnCursoInstitucion;
    }

    public void setMateriaEnCursoInstitucion(int materiaEnCursoInstitucion) {
        this.materiaEnCursoInstitucion = materiaEnCursoInstitucion;
    }

    public int getMateriaEnCursoJornada() {
        return materiaEnCursoJornada;
    }

    public void setMateriaEnCursoJornada(int materiaEnCursoJornada) {
        this.materiaEnCursoJornada = materiaEnCursoJornada;
    }

    public int getMateriaEnCursoMateria() {
        return materiaEnCursoMateria;
    }

    public void setMateriaEnCursoMateria(int materiaEnCursoMateria) {
        this.materiaEnCursoMateria = materiaEnCursoMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiante != null ? estudiante.hashCode() : 0);
        hash += (materiaEnCursofecha != null ? materiaEnCursofecha.hashCode() : 0);
        hash += (int) materiaEnCursoSalon;
        hash += (int) materiaEnCursoInstitucion;
        hash += (int) materiaEnCursoJornada;
        hash += (int) materiaEnCursoMateria;
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
        if ((this.materiaEnCursofecha == null && other.materiaEnCursofecha != null) || (this.materiaEnCursofecha != null && !this.materiaEnCursofecha.equals(other.materiaEnCursofecha))) {
            return false;
        }
        if (this.materiaEnCursoSalon != other.materiaEnCursoSalon) {
            return false;
        }
        if (this.materiaEnCursoInstitucion != other.materiaEnCursoInstitucion) {
            return false;
        }
        if (this.materiaEnCursoJornada != other.materiaEnCursoJornada) {
            return false;
        }
        if (this.materiaEnCursoMateria != other.materiaEnCursoMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.MatriculasPK[ estudiante=" + estudiante + ", materiaEnCursofecha=" + materiaEnCursofecha + ", materiaEnCursoSalon=" + materiaEnCursoSalon + ", materiaEnCursoInstitucion=" + materiaEnCursoInstitucion + ", materiaEnCursoJornada=" + materiaEnCursoJornada + ", materiaEnCursoMateria=" + materiaEnCursoMateria + " ]";
    }
    
}
