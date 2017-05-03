/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Materia_En_Curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaEnCurso.findAll", query = "SELECT m FROM MateriaEnCurso m")
    , @NamedQuery(name = "MateriaEnCurso.findByFecha", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.fecha = :fecha")
    , @NamedQuery(name = "MateriaEnCurso.findByInstitucion", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.institucion = :institucion")
    , @NamedQuery(name = "MateriaEnCurso.findBySalon", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.salon = :salon")
    , @NamedQuery(name = "MateriaEnCurso.findByJornada", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.jornada = :jornada")
    , @NamedQuery(name = "MateriaEnCurso.findByMateria", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.materia = :materia")})
public class MateriaEnCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaEnCursoPK materiaEnCursoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaEnCurso")
    private Collection<Evaluaciones> evaluacionesCollection;
    @JoinColumns({
        @JoinColumn(name = "Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Salon", referencedColumnName = "Salon", insertable = false, updatable = false)
        , @JoinColumn(name = "Jornada", referencedColumnName = "Jornada", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cursos cursos;
    @JoinColumn(name = "Materia", referencedColumnName = "codigo_materia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materias materias;
    @JoinColumn(name = "Profesor", referencedColumnName = "Personas_numero_identificacion")
    @ManyToOne(optional = false)
    private Profesores profesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaEnCurso")
    private Collection<Matriculas> matriculasCollection;

    public MateriaEnCurso() {
    }

    public MateriaEnCurso(MateriaEnCursoPK materiaEnCursoPK) {
        this.materiaEnCursoPK = materiaEnCursoPK;
    }

    public MateriaEnCurso(Date fecha, int institucion, int salon, int jornada, int materia) {
        this.materiaEnCursoPK = new MateriaEnCursoPK(fecha, institucion, salon, jornada, materia);
    }

    public MateriaEnCursoPK getMateriaEnCursoPK() {
        return materiaEnCursoPK;
    }

    public void setMateriaEnCursoPK(MateriaEnCursoPK materiaEnCursoPK) {
        this.materiaEnCursoPK = materiaEnCursoPK;
    }

    @XmlTransient
    public Collection<Evaluaciones> getEvaluacionesCollection() {
        return evaluacionesCollection;
    }

    public void setEvaluacionesCollection(Collection<Evaluaciones> evaluacionesCollection) {
        this.evaluacionesCollection = evaluacionesCollection;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    @XmlTransient
    public Collection<Matriculas> getMatriculasCollection() {
        return matriculasCollection;
    }

    public void setMatriculasCollection(Collection<Matriculas> matriculasCollection) {
        this.matriculasCollection = matriculasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaEnCursoPK != null ? materiaEnCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaEnCurso)) {
            return false;
        }
        MateriaEnCurso other = (MateriaEnCurso) object;
        if ((this.materiaEnCursoPK == null && other.materiaEnCursoPK != null) || (this.materiaEnCursoPK != null && !this.materiaEnCursoPK.equals(other.materiaEnCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.MateriaEnCurso[ materiaEnCursoPK=" + materiaEnCursoPK + " ]";
    }
    
}
