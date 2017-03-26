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
@Table(name = "Cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findByGrado", query = "SELECT c FROM Cursos c WHERE c.grado = :grado")
    , @NamedQuery(name = "Cursos.findByConsecutivo", query = "SELECT c FROM Cursos c WHERE c.consecutivo = :consecutivo")
    , @NamedQuery(name = "Cursos.findByInstitucion", query = "SELECT c FROM Cursos c WHERE c.cursosPK.institucion = :institucion")
    , @NamedQuery(name = "Cursos.findBySede", query = "SELECT c FROM Cursos c WHERE c.cursosPK.sede = :sede")
    , @NamedQuery(name = "Cursos.findBySalon", query = "SELECT c FROM Cursos c WHERE c.cursosPK.salon = :salon")
    , @NamedQuery(name = "Cursos.findByJornada", query = "SELECT c FROM Cursos c WHERE c.cursosPK.jornada = :jornada")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursosPK cursosPK;
    @Column(name = "grado")
    private Integer grado;
    @Column(name = "consecutivo")
    private Integer consecutivo;
    @JoinColumn(name = "Institucion", referencedColumnName = "nit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instituciones instituciones;
    @JoinColumn(name = "Jornada", referencedColumnName = "id_jornada", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jornadas jornadas;
    @JoinColumn(name = "Director", referencedColumnName = "Personas_numero_identificacion")
    @ManyToOne(optional = false)
    private Profesores director;
    @JoinColumn(name = "Salon", referencedColumnName = "id_salon", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Salones salones;
    @JoinColumn(name = "Sede", referencedColumnName = "nit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sedes sedes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursos")
    private Collection<MateriaEnCurso> materiaEnCursoCollection;

    public Cursos() {
    }

    public Cursos(CursosPK cursosPK) {
        this.cursosPK = cursosPK;
    }

    public Cursos(int institucion, int sede, int salon, int jornada) {
        this.cursosPK = new CursosPK(institucion, sede, salon, jornada);
    }

    public CursosPK getCursosPK() {
        return cursosPK;
    }

    public void setCursosPK(CursosPK cursosPK) {
        this.cursosPK = cursosPK;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Instituciones getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Instituciones instituciones) {
        this.instituciones = instituciones;
    }

    public Jornadas getJornadas() {
        return jornadas;
    }

    public void setJornadas(Jornadas jornadas) {
        this.jornadas = jornadas;
    }

    public Profesores getDirector() {
        return director;
    }

    public void setDirector(Profesores director) {
        this.director = director;
    }

    public Salones getSalones() {
        return salones;
    }

    public void setSalones(Salones salones) {
        this.salones = salones;
    }

    public Sedes getSedes() {
        return sedes;
    }

    public void setSedes(Sedes sedes) {
        this.sedes = sedes;
    }

    @XmlTransient
    public Collection<MateriaEnCurso> getMateriaEnCursoCollection() {
        return materiaEnCursoCollection;
    }

    public void setMateriaEnCursoCollection(Collection<MateriaEnCurso> materiaEnCursoCollection) {
        this.materiaEnCursoCollection = materiaEnCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursosPK != null ? cursosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.cursosPK == null && other.cursosPK != null) || (this.cursosPK != null && !this.cursosPK.equals(other.cursosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Cursos[ cursosPK=" + cursosPK + " ]";
    }
    
}
