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
import javax.persistence.OneToOne;
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
    , @NamedQuery(name = "Matriculas.findByEstudiante", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.estudiante = :estudiante")
    , @NamedQuery(name = "Matriculas.findByMateriaEnCursofecha", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.materiaEnCursofecha = :materiaEnCursofecha")
    , @NamedQuery(name = "Matriculas.findByMateriaEnCursoSalon", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.materiaEnCursoSalon = :materiaEnCursoSalon")
    , @NamedQuery(name = "Matriculas.findByMateriaEnCursoInstitucion", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.materiaEnCursoInstitucion = :materiaEnCursoInstitucion")
    , @NamedQuery(name = "Matriculas.findByMateriaEnCursoJornada", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.materiaEnCursoJornada = :materiaEnCursoJornada")
    , @NamedQuery(name = "Matriculas.findByMateriaEnCursoMateria", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.materiaEnCursoMateria = :materiaEnCursoMateria")
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
    @JoinColumn(name = "Estudiante", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumns({
        @JoinColumn(name = "Materia_En_Curso_fecha", referencedColumnName = "fecha", insertable = false, updatable = false)
        , @JoinColumn(name = "Materia_En_Curso_Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Materia_En_Curso_Salon", referencedColumnName = "Salon", insertable = false, updatable = false)
        , @JoinColumn(name = "Materia_En_Curso_Jornada", referencedColumnName = "Jornada", insertable = false, updatable = false)
        , @JoinColumn(name = "Materia_En_Curso_Materia", referencedColumnName = "Materia", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MateriaEnCurso materiaEnCurso;

    public Matriculas() {
    }

    public Matriculas(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public Matriculas(String estudiante, Date materiaEnCursofecha, int materiaEnCursoSalon, int materiaEnCursoInstitucion, int materiaEnCursoJornada, int materiaEnCursoMateria) {
        this.matriculasPK = new MatriculasPK(estudiante, materiaEnCursofecha, materiaEnCursoSalon, materiaEnCursoInstitucion, materiaEnCursoJornada, materiaEnCursoMateria);
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

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public MateriaEnCurso getMateriaEnCurso() {
        return materiaEnCurso;
    }

    public void setMateriaEnCurso(MateriaEnCurso materiaEnCurso) {
        this.materiaEnCurso = materiaEnCurso;
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
