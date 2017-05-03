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
    , @NamedQuery(name = "Evaluaciones.findByFechaMateriaEnCurso", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.fechaMateriaEnCurso = :fechaMateriaEnCurso")
    , @NamedQuery(name = "Evaluaciones.findByInstitucion", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.institucion = :institucion")
    , @NamedQuery(name = "Evaluaciones.findBySalon", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.salon = :salon")
    , @NamedQuery(name = "Evaluaciones.findByJornada", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.jornada = :jornada")
    , @NamedQuery(name = "Evaluaciones.findByMateria", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.materia = :materia")
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
        @JoinColumn(name = "Fecha_Materia-En-Curso", referencedColumnName = "fecha", insertable = false, updatable = false)
        , @JoinColumn(name = "Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Salon", referencedColumnName = "Salon", insertable = false, updatable = false)
        , @JoinColumn(name = "Jornada", referencedColumnName = "Jornada", insertable = false, updatable = false)
        , @JoinColumn(name = "Materia", referencedColumnName = "Materia", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MateriaEnCurso materiaEnCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluaciones")
    private Collection<Examen> examenCollection;

    public Evaluaciones() {
    }

    public Evaluaciones(EvaluacionesPK evaluacionesPK) {
        this.evaluacionesPK = evaluacionesPK;
    }

    public Evaluaciones(int consecutivo, Date fechaMateriaEnCurso, int institucion, int salon, int jornada, int materia) {
        this.evaluacionesPK = new EvaluacionesPK(consecutivo, fechaMateriaEnCurso, institucion, salon, jornada, materia);
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

    public MateriaEnCurso getMateriaEnCurso() {
        return materiaEnCurso;
    }

    public void setMateriaEnCurso(MateriaEnCurso materiaEnCurso) {
        this.materiaEnCurso = materiaEnCurso;
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
