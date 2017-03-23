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
@Table(name = "Matriculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculas.findAll", query = "SELECT m FROM Matriculas m")
    , @NamedQuery(name = "Matriculas.findByFechaMateriaEnCurso", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.fechaMateriaEnCurso = :fechaMateriaEnCurso")
    , @NamedQuery(name = "Matriculas.findByInstitucion", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.institucion = :institucion")
    , @NamedQuery(name = "Matriculas.findBySede", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.sede = :sede")
    , @NamedQuery(name = "Matriculas.findByJornada", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.jornada = :jornada")
    , @NamedQuery(name = "Matriculas.findBySalon", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.salon = :salon")
    , @NamedQuery(name = "Matriculas.findByEstudiante", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.estudiante = :estudiante")
    , @NamedQuery(name = "Matriculas.findByNotaDefinitiva", query = "SELECT m FROM Matriculas m WHERE m.notaDefinitiva = :notaDefinitiva")
    , @NamedQuery(name = "Matriculas.findByTotalInasistencias", query = "SELECT m FROM Matriculas m WHERE m.totalInasistencias = :totalInasistencias")})
public class Matriculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculasPK matriculasPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota_definitiva")
    private Double notaDefinitiva;
    @Column(name = "total_inasistencias")
    private Integer totalInasistencias;
    @JoinColumns({
        @JoinColumn(name = "Fecha_Materia_En_Curso", referencedColumnName = "fecha", insertable = false, updatable = false)
        , @JoinColumn(name = "Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Sede", referencedColumnName = "Sedes", insertable = false, updatable = false)
        , @JoinColumn(name = "Salon", referencedColumnName = "Salon", insertable = false, updatable = false)
        , @JoinColumn(name = "Jornada", referencedColumnName = "Jornada", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MateriaEnCurso materiaEnCurso;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;

    public Matriculas() {
    }

    public Matriculas(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public Matriculas(Date fechaMateriaEnCurso, int institucion, int sede, int jornada, int salon, int estudiante) {
        this.matriculasPK = new MatriculasPK(fechaMateriaEnCurso, institucion, sede, jornada, salon, estudiante);
    }

    public MatriculasPK getMatriculasPK() {
        return matriculasPK;
    }

    public void setMatriculasPK(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public Double getNotaDefinitiva() {
        return notaDefinitiva;
    }

    public void setNotaDefinitiva(Double notaDefinitiva) {
        this.notaDefinitiva = notaDefinitiva;
    }

    public Integer getTotalInasistencias() {
        return totalInasistencias;
    }

    public void setTotalInasistencias(Integer totalInasistencias) {
        this.totalInasistencias = totalInasistencias;
    }

    public MateriaEnCurso getMateriaEnCurso() {
        return materiaEnCurso;
    }

    public void setMateriaEnCurso(MateriaEnCurso materiaEnCurso) {
        this.materiaEnCurso = materiaEnCurso;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculasPK != null ? matriculasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculas)) {
            return false;
        }
        Matriculas other = (Matriculas) object;
        if ((this.matriculasPK == null && other.matriculasPK != null) || (this.matriculasPK != null && !this.matriculasPK.equals(other.matriculasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Matriculas[ matriculasPK=" + matriculasPK + " ]";
    }
    
}
