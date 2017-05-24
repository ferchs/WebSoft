/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "Evaluaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluaciones.findAll", query = "SELECT e FROM Evaluaciones e")
    , @NamedQuery(name = "Evaluaciones.findByConsecutivo", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.consecutivo = :consecutivo")
    , @NamedQuery(name = "Evaluaciones.findByCursoMateria", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursoMateria = :cursoMateria")
    , @NamedQuery(name = "Evaluaciones.findByCursosProfesor", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosProfesor = :cursosProfesor")
    , @NamedQuery(name = "Evaluaciones.findByCursosGrado", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosGrado = :cursosGrado")
    , @NamedQuery(name = "Evaluaciones.findByCursosInstitucion", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosInstitucion = :cursosInstitucion")
    , @NamedQuery(name = "Evaluaciones.findByCursosConsecutivo", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosConsecutivo = :cursosConsecutivo")
    , @NamedQuery(name = "Evaluaciones.findByTema", query = "SELECT e FROM Evaluaciones e WHERE e.tema = :tema")
    , @NamedQuery(name = "Evaluaciones.findByPorcentaje", query = "SELECT e FROM Evaluaciones e WHERE e.porcentaje = :porcentaje")})
public class Evaluaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionesPK evaluacionesPK;
    @Column(name = "tema")
    private String tema;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @JoinColumns({
        @JoinColumn(name = "Curso_Materia", referencedColumnName = "Materia", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Profesor", referencedColumnName = "Profesor", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Grado", referencedColumnName = "Grado", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Consecutivo", referencedColumnName = "Consecutivo_curso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CursosImpartidos cursosImpartidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluaciones")
    private Collection<Examen> examenCollection;

    public Evaluaciones() {
    }

    public Evaluaciones(EvaluacionesPK evaluacionesPK) {
        this.evaluacionesPK = evaluacionesPK;
    }

    public Evaluaciones(int consecutivo, int cursoMateria, String cursosProfesor, int cursosGrado, int cursosInstitucion, int cursosConsecutivo) {
        this.evaluacionesPK = new EvaluacionesPK(consecutivo, cursoMateria, cursosProfesor, cursosGrado, cursosInstitucion, cursosConsecutivo);
    }

    public EvaluacionesPK getEvaluacionesPK() {
        return evaluacionesPK;
    }

    public void setEvaluacionesPK(EvaluacionesPK evaluacionesPK) {
        this.evaluacionesPK = evaluacionesPK;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public CursosImpartidos getCursosImpartidos() {
        return cursosImpartidos;
    }

    public void setCursosImpartidos(CursosImpartidos cursosImpartidos) {
        this.cursosImpartidos = cursosImpartidos;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionesPK != null ? evaluacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluaciones)) {
            return false;
        }
        Evaluaciones other = (Evaluaciones) object;
        if ((this.evaluacionesPK == null && other.evaluacionesPK != null) || (this.evaluacionesPK != null && !this.evaluacionesPK.equals(other.evaluacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Evaluaciones[ evaluacionesPK=" + evaluacionesPK + " ]";
    }
    
}
