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
public class ExamenesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Estudiante")
    private String estudiante;
    @Basic(optional = false)
    @Column(name = "Evaluaciones_Materia")
    private int evaluacionesMateria;
    @Basic(optional = false)
    @Column(name = "Evaluaciones_Grado")
    private int evaluacionesGrado;
    @Basic(optional = false)
    @Column(name = "Evaluaciones_Institucion")
    private int evaluacionesInstitucion;
    @Basic(optional = false)
    @Column(name = "Evaluaciones_Consecutivo_curso")
    private int evaluacionesConsecutivocurso;
    @Basic(optional = false)
    @Column(name = "Evaluaciones_tema")
    private String evaluacionestema;

    public ExamenesPK() {
    }

    public ExamenesPK(Date fecha, String estudiante, int evaluacionesMateria, int evaluacionesGrado, int evaluacionesInstitucion, int evaluacionesConsecutivocurso, String evaluacionestema) {
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.evaluacionesMateria = evaluacionesMateria;
        this.evaluacionesGrado = evaluacionesGrado;
        this.evaluacionesInstitucion = evaluacionesInstitucion;
        this.evaluacionesConsecutivocurso = evaluacionesConsecutivocurso;
        this.evaluacionestema = evaluacionestema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public int getEvaluacionesMateria() {
        return evaluacionesMateria;
    }

    public void setEvaluacionesMateria(int evaluacionesMateria) {
        this.evaluacionesMateria = evaluacionesMateria;
    }

    public int getEvaluacionesGrado() {
        return evaluacionesGrado;
    }

    public void setEvaluacionesGrado(int evaluacionesGrado) {
        this.evaluacionesGrado = evaluacionesGrado;
    }

    public int getEvaluacionesInstitucion() {
        return evaluacionesInstitucion;
    }

    public void setEvaluacionesInstitucion(int evaluacionesInstitucion) {
        this.evaluacionesInstitucion = evaluacionesInstitucion;
    }

    public int getEvaluacionesConsecutivocurso() {
        return evaluacionesConsecutivocurso;
    }

    public void setEvaluacionesConsecutivocurso(int evaluacionesConsecutivocurso) {
        this.evaluacionesConsecutivocurso = evaluacionesConsecutivocurso;
    }

    public String getEvaluacionestema() {
        return evaluacionestema;
    }

    public void setEvaluacionestema(String evaluacionestema) {
        this.evaluacionestema = evaluacionestema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (estudiante != null ? estudiante.hashCode() : 0);
        hash += (int) evaluacionesMateria;
        hash += (int) evaluacionesGrado;
        hash += (int) evaluacionesInstitucion;
        hash += (int) evaluacionesConsecutivocurso;
        hash += (evaluacionestema != null ? evaluacionestema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenesPK)) {
            return false;
        }
        ExamenesPK other = (ExamenesPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.estudiante == null && other.estudiante != null) || (this.estudiante != null && !this.estudiante.equals(other.estudiante))) {
            return false;
        }
        if (this.evaluacionesMateria != other.evaluacionesMateria) {
            return false;
        }
        if (this.evaluacionesGrado != other.evaluacionesGrado) {
            return false;
        }
        if (this.evaluacionesInstitucion != other.evaluacionesInstitucion) {
            return false;
        }
        if (this.evaluacionesConsecutivocurso != other.evaluacionesConsecutivocurso) {
            return false;
        }
        if ((this.evaluacionestema == null && other.evaluacionestema != null) || (this.evaluacionestema != null && !this.evaluacionestema.equals(other.evaluacionestema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.ExamenesPK[ fecha=" + fecha + ", estudiante=" + estudiante + ", evaluacionesMateria=" + evaluacionesMateria + ", evaluacionesGrado=" + evaluacionesGrado + ", evaluacionesInstitucion=" + evaluacionesInstitucion + ", evaluacionesConsecutivocurso=" + evaluacionesConsecutivocurso + ", evaluacionestema=" + evaluacionestema + " ]";
    }
    
}
