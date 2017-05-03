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
    , @NamedQuery(name = "Examen.findByConsecutivoEvaluacion", query = "SELECT e FROM Examen e WHERE e.examenPK.consecutivoEvaluacion = :consecutivoEvaluacion")
    , @NamedQuery(name = "Examen.findByFechaEvaluacion", query = "SELECT e FROM Examen e WHERE e.examenPK.fechaEvaluacion = :fechaEvaluacion")
    , @NamedQuery(name = "Examen.findByInstitucion", query = "SELECT e FROM Examen e WHERE e.examenPK.institucion = :institucion")
    , @NamedQuery(name = "Examen.findBySalon", query = "SELECT e FROM Examen e WHERE e.examenPK.salon = :salon")
    , @NamedQuery(name = "Examen.findByJornada", query = "SELECT e FROM Examen e WHERE e.examenPK.jornada = :jornada")
    , @NamedQuery(name = "Examen.findByMateria", query = "SELECT e FROM Examen e WHERE e.examenPK.materia = :materia")
    , @NamedQuery(name = "Examen.findByEstudiante", query = "SELECT e FROM Examen e WHERE e.examenPK.estudiante = :estudiante")
    , @NamedQuery(name = "Examen.findByNota", query = "SELECT e FROM Examen e WHERE e.nota = :nota")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenPK examenPK;
    @Basic(optional = false)
    @Column(name = "nota")
    private double nota;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumns({
        @JoinColumn(name = "Consecutivo_Evaluacion", referencedColumnName = "Consecutivo", insertable = false, updatable = false)
        , @JoinColumn(name = "Fecha_Evaluacion", referencedColumnName = "Fecha_Materia-En-Curso", insertable = false, updatable = false)
        , @JoinColumn(name = "Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Salon", referencedColumnName = "Salon", insertable = false, updatable = false)
        , @JoinColumn(name = "Jornada", referencedColumnName = "Jornada", insertable = false, updatable = false)
        , @JoinColumn(name = "Materia", referencedColumnName = "Materia", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluaciones evaluaciones;

    public Examen() {
    }

    public Examen(ExamenPK examenPK) {
        this.examenPK = examenPK;
    }

    public Examen(ExamenPK examenPK, double nota) {
        this.examenPK = examenPK;
        this.nota = nota;
    }

    public Examen(Date fecha, int consecutivoEvaluacion, Date fechaEvaluacion, int institucion, int salon, int jornada, int materia, String estudiante) {
        this.examenPK = new ExamenPK(fecha, consecutivoEvaluacion, fechaEvaluacion, institucion, salon, jornada, materia, estudiante);
    }

    public ExamenPK getExamenPK() {
        return examenPK;
    }

    public void setExamenPK(ExamenPK examenPK) {
        this.examenPK = examenPK;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
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
