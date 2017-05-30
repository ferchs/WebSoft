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
    , @NamedQuery(name = "Evaluaciones.findByCursosMateria", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosMateria = :cursosMateria")
    , @NamedQuery(name = "Evaluaciones.findByCursosGrado", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosGrado = :cursosGrado")
    , @NamedQuery(name = "Evaluaciones.findByCursosInstitucion", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosInstitucion = :cursosInstitucion")
    , @NamedQuery(name = "Evaluaciones.findByCursosConsecutivocurso", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.cursosConsecutivocurso = :cursosConsecutivocurso")
    , @NamedQuery(name = "Evaluaciones.findByTema", query = "SELECT e FROM Evaluaciones e WHERE e.evaluacionesPK.tema = :tema")
    , @NamedQuery(name = "Evaluaciones.findByPorcentaje", query = "SELECT e FROM Evaluaciones e WHERE e.porcentaje = :porcentaje")})
public class Evaluaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionesPK evaluacionesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluaciones")
    private Collection<Examenes> examenesCollection;
    @JoinColumns({
        @JoinColumn(name = "Cursos_Materia", referencedColumnName = "Materia", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Grado", referencedColumnName = "Grado", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Institucion", referencedColumnName = "Institucion", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Consecutivo_curso", referencedColumnName = "Consecutivo_curso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CursosImpartidos cursosImpartidos;

    public Evaluaciones() {
    }

    public Evaluaciones(EvaluacionesPK evaluacionesPK) {
        this.evaluacionesPK = evaluacionesPK;
    }

    public Evaluaciones(int cursosMateria, int cursosGrado, int cursosInstitucion, int cursosConsecutivocurso, String tema) {
        this.evaluacionesPK = new EvaluacionesPK(cursosMateria, cursosGrado, cursosInstitucion, cursosConsecutivocurso, tema);
    }

    public EvaluacionesPK getEvaluacionesPK() {
        return evaluacionesPK;
    }

    public void setEvaluacionesPK(EvaluacionesPK evaluacionesPK) {
        this.evaluacionesPK = evaluacionesPK;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @XmlTransient
    public Collection<Examenes> getExamenesCollection() {
        return examenesCollection;
    }

    public void setExamenesCollection(Collection<Examenes> examenesCollection) {
        this.examenesCollection = examenesCollection;
    }

    public CursosImpartidos getCursosImpartidos() {
        return cursosImpartidos;
    }

    public void setCursosImpartidos(CursosImpartidos cursosImpartidos) {
        this.cursosImpartidos = cursosImpartidos;
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
