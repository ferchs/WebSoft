/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Examenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examenes.findAll", query = "SELECT e FROM Examenes e")
    , @NamedQuery(name = "Examenes.findByFecha", query = "SELECT e FROM Examenes e WHERE e.examenesPK.fecha = :fecha")
    , @NamedQuery(name = "Examenes.findByEstudiante", query = "SELECT e FROM Examenes e WHERE e.examenesPK.estudiante = :estudiante")
    , @NamedQuery(name = "Examenes.findByEvaluacionesMateria", query = "SELECT e FROM Examenes e WHERE e.examenesPK.evaluacionesMateria = :evaluacionesMateria")
    , @NamedQuery(name = "Examenes.findByEvaluacionesGrado", query = "SELECT e FROM Examenes e WHERE e.examenesPK.evaluacionesGrado = :evaluacionesGrado")
    , @NamedQuery(name = "Examenes.findByEvaluacionesInstitucion", query = "SELECT e FROM Examenes e WHERE e.examenesPK.evaluacionesInstitucion = :evaluacionesInstitucion")
    , @NamedQuery(name = "Examenes.findByEvaluacionesConsecutivocurso", query = "SELECT e FROM Examenes e WHERE e.examenesPK.evaluacionesConsecutivocurso = :evaluacionesConsecutivocurso")
    , @NamedQuery(name = "Examenes.findByEvaluacionestema", query = "SELECT e FROM Examenes e WHERE e.examenesPK.evaluacionestema = :evaluacionestema")
    , @NamedQuery(name = "Examenes.findByNota", query = "SELECT e FROM Examenes e WHERE e.nota = :nota")})
public class Examenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenesPK examenesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumns({
        @JoinColumn(name = "Evaluaciones_Materia", referencedColumnName = "Cursos_Materia", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Grado", referencedColumnName = "Cursos_Grado", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Institucion", referencedColumnName = "Cursos_Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Consecutivo_curso", referencedColumnName = "Cursos_Consecutivo_curso", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_tema", referencedColumnName = "tema", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluaciones evaluaciones;

    public Examenes() {
    }

    public Examenes(ExamenesPK examenesPK) {
        this.examenesPK = examenesPK;
    }

    public Examenes(Date fecha, String estudiante, int evaluacionesMateria, int evaluacionesGrado, int evaluacionesInstitucion, int evaluacionesConsecutivocurso, String evaluacionestema) {
        this.examenesPK = new ExamenesPK(fecha, estudiante, evaluacionesMateria, evaluacionesGrado, evaluacionesInstitucion, evaluacionesConsecutivocurso, evaluacionestema);
    }

    public ExamenesPK getExamenesPK() {
        return examenesPK;
    }

    public void setExamenesPK(ExamenesPK examenesPK) {
        this.examenesPK = examenesPK;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Evaluaciones getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(Evaluaciones evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenesPK != null ? examenesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examenes)) {
            return false;
        }
        Examenes other = (Examenes) object;
        if ((this.examenesPK == null && other.examenesPK != null) || (this.examenesPK != null && !this.examenesPK.equals(other.examenesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Examenes[ examenesPK=" + examenesPK + " ]";
    }
    
}
