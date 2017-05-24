/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "Cursos_Impartidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursosImpartidos.findAll", query = "SELECT c FROM CursosImpartidos c")
    , @NamedQuery(name = "CursosImpartidos.findByMateria", query = "SELECT c FROM CursosImpartidos c WHERE c.cursosImpartidosPK.materia = :materia")
    , @NamedQuery(name = "CursosImpartidos.findByProfesor", query = "SELECT c FROM CursosImpartidos c WHERE c.cursosImpartidosPK.profesor = :profesor")
    , @NamedQuery(name = "CursosImpartidos.findByGrado", query = "SELECT c FROM CursosImpartidos c WHERE c.cursosImpartidosPK.grado = :grado")
    , @NamedQuery(name = "CursosImpartidos.findByInstitucion", query = "SELECT c FROM CursosImpartidos c WHERE c.cursosImpartidosPK.institucion = :institucion")
    , @NamedQuery(name = "CursosImpartidos.findByConsecutivocurso", query = "SELECT c FROM CursosImpartidos c WHERE c.cursosImpartidosPK.consecutivocurso = :consecutivocurso")})
public class CursosImpartidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursosImpartidosPK cursosImpartidosPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosImpartidos")
    private Collection<Evaluaciones> evaluacionesCollection;
    @JoinColumns({
        @JoinColumn(name = "Grado", referencedColumnName = "Grados_idGrado", insertable = false, updatable = false)
        , @JoinColumn(name = "Institucion", referencedColumnName = "Grados_Instituciones_nit", insertable = false, updatable = false)
        , @JoinColumn(name = "Consecutivo_curso", referencedColumnName = "consecutivo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cursos cursos;
    @JoinColumn(name = "Profesor", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesores profesores;
    @JoinColumn(name = "Materia", referencedColumnName = "codigo_materia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materias materias;

    public CursosImpartidos() {
    }

    public CursosImpartidos(CursosImpartidosPK cursosImpartidosPK) {
        this.cursosImpartidosPK = cursosImpartidosPK;
    }

    public CursosImpartidos(int materia, String profesor, int grado, int institucion, int consecutivocurso) {
        this.cursosImpartidosPK = new CursosImpartidosPK(materia, profesor, grado, institucion, consecutivocurso);
    }

    public CursosImpartidosPK getCursosImpartidosPK() {
        return cursosImpartidosPK;
    }

    public void setCursosImpartidosPK(CursosImpartidosPK cursosImpartidosPK) {
        this.cursosImpartidosPK = cursosImpartidosPK;
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

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursosImpartidosPK != null ? cursosImpartidosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosImpartidos)) {
            return false;
        }
        CursosImpartidos other = (CursosImpartidos) object;
        if ((this.cursosImpartidosPK == null && other.cursosImpartidosPK != null) || (this.cursosImpartidosPK != null && !this.cursosImpartidosPK.equals(other.cursosImpartidosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CursosImpartidos[ cursosImpartidosPK=" + cursosImpartidosPK + " ]";
    }
    
}
