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
@Table(name = "Examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByFecha", query = "SELECT e FROM Examen e WHERE e.examenPK.fecha = :fecha")
    , @NamedQuery(name = "Examen.findByEstudiante", query = "SELECT e FROM Examen e WHERE e.examenPK.estudiante = :estudiante")
    , @NamedQuery(name = "Examen.findByEvaluacionesConsecutivo", query = "SELECT e FROM Examen e WHERE e.examenPK.evaluacionesConsecutivo = :evaluacionesConsecutivo")
    , @NamedQuery(name = "Examen.findByEvaluacionesMateria", query = "SELECT e FROM Examen e WHERE e.examenPK.evaluacionesMateria = :evaluacionesMateria")
    , @NamedQuery(name = "Examen.findByEvaluacionesProfesor", query = "SELECT e FROM Examen e WHERE e.examenPK.evaluacionesProfesor = :evaluacionesProfesor")
    , @NamedQuery(name = "Examen.findByEvaluacionesGrado", query = "SELECT e FROM Examen e WHERE e.examenPK.evaluacionesGrado = :evaluacionesGrado")
    , @NamedQuery(name = "Examen.findByEvaluacionesInstitucion", query = "SELECT e FROM Examen e WHERE e.examenPK.evaluacionesInstitucion = :evaluacionesInstitucion")
    , @NamedQuery(name = "Examen.findByEvaluacionesConsecutivocurso", query = "SELECT e FROM Examen e WHERE e.examenPK.evaluacionesConsecutivocurso = :evaluacionesConsecutivocurso")
    , @NamedQuery(name = "Examen.findByNota", query = "SELECT e FROM Examen e WHERE e.nota = :nota")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenPK examenPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumns({
        @JoinColumn(name = "Evaluaciones_Consecutivo", referencedColumnName = "Consecutivo", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Materia", referencedColumnName = "Curso_Materia", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Profesor", referencedColumnName = "Cursos_Profesor", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Grado", referencedColumnName = "Cursos_Grado", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Institucion", referencedColumnName = "Cursos_Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Evaluaciones_Consecutivo_curso", referencedColumnName = "Cursos_Consecutivo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluaciones evaluaciones;

    public Examen() {
    }

    public Examen(ExamenPK examenPK) {
        this.examenPK = examenPK;
    }

    public Examen(Date fecha, String estudiante, int evaluacionesConsecutivo, int evaluacionesMateria, String evaluacionesProfesor, int evaluacionesGrado, int evaluacionesInstitucion, int evaluacionesConsecutivocurso) {
        this.examenPK = new ExamenPK(fecha, estudiante, evaluacionesConsecutivo, evaluacionesMateria, evaluacionesProfesor, evaluacionesGrado, evaluacionesInstitucion, evaluacionesConsecutivocurso);
    }

    public ExamenPK getExamenPK() {
        return examenPK;
    }

    public void setExamenPK(ExamenPK examenPK) {
        this.examenPK = examenPK;
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
        hash += (examenPK != null ? examenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.examenPK == null && other.examenPK != null) || (this.examenPK != null && !this.examenPK.equals(other.examenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Examen[ examenPK=" + examenPK + " ]";
    }
    
}
