/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
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
    , @NamedQuery(name = "Matriculas.findByGrado", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.grado = :grado")
    , @NamedQuery(name = "Matriculas.findByInstitucion", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.institucion = :institucion")
    , @NamedQuery(name = "Matriculas.findByCursosconsecutivo", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.cursosconsecutivo = :cursosconsecutivo")})
public class Matriculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculasPK matriculasPK;
    @JoinColumns({
        @JoinColumn(name = "Grado", referencedColumnName = "Grados_idGrado", insertable = false, updatable = false)
        , @JoinColumn(name = "Institucion", referencedColumnName = "Grados_Instituciones_nit", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_consecutivo", referencedColumnName = "consecutivo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cursos cursos;
    @JoinColumn(name = "Estudiante", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estudiantes estudiantes;

    public Matriculas() {
    }

    public Matriculas(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public Matriculas(String estudiante, int grado, int institucion, int cursosconsecutivo) {
        this.matriculasPK = new MatriculasPK(estudiante, grado, institucion, cursosconsecutivo);
    }

    public MatriculasPK getMatriculasPK() {
        return matriculasPK;
    }

    public void setMatriculasPK(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
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
