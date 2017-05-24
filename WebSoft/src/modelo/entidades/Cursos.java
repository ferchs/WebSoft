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
@Table(name = "Cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findByGradosidGrado", query = "SELECT c FROM Cursos c WHERE c.cursosPK.gradosidGrado = :gradosidGrado")
    , @NamedQuery(name = "Cursos.findByGradosInstitucionesnit", query = "SELECT c FROM Cursos c WHERE c.cursosPK.gradosInstitucionesnit = :gradosInstitucionesnit")
    , @NamedQuery(name = "Cursos.findByConsecutivo", query = "SELECT c FROM Cursos c WHERE c.cursosPK.consecutivo = :consecutivo")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursosPK cursosPK;
    @JoinColumns({
        @JoinColumn(name = "Grados_idGrado", referencedColumnName = "idGrado", insertable = false, updatable = false)
        , @JoinColumn(name = "Grados_Instituciones_nit", referencedColumnName = "Instituciones_nit", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Grados grados;
    @JoinColumn(name = "Jornadas_id_jornada", referencedColumnName = "id_jornada")
    @ManyToOne(optional = false)
    private Jornadas jornadasidjornada;
    @JoinColumn(name = "director", referencedColumnName = "Personas_numero_identificacion")
    @ManyToOne(optional = false)
    private Profesores director;
    @JoinColumn(name = "Salones_id_salon", referencedColumnName = "id_salon")
    @ManyToOne(optional = false)
    private Salones salonesidsalon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursos")
    private Collection<MateriaEnCurso> materiaEnCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursos")
    private Collection<CursosImpartidos> cursosImpartidosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursos")
    private Collection<Matriculas> matriculasCollection;

    public Cursos() {
    }

    public Cursos(CursosPK cursosPK) {
        this.cursosPK = cursosPK;
    }

    public Cursos(int gradosidGrado, int gradosInstitucionesnit, int consecutivo) {
        this.cursosPK = new CursosPK(gradosidGrado, gradosInstitucionesnit, consecutivo);
    }

    public CursosPK getCursosPK() {
        return cursosPK;
    }

    public void setCursosPK(CursosPK cursosPK) {
        this.cursosPK = cursosPK;
    }

    public Grados getGrados() {
        return grados;
    }

    public void setGrados(Grados grados) {
        this.grados = grados;
    }

    public Jornadas getJornadasidjornada() {
        return jornadasidjornada;
    }

    public void setJornadasidjornada(Jornadas jornadasidjornada) {
        this.jornadasidjornada = jornadasidjornada;
    }

    public Profesores getDirector() {
        return director;
    }

    public void setDirector(Profesores director) {
        this.director = director;
    }

    public Salones getSalonesidsalon() {
        return salonesidsalon;
    }

    public void setSalonesidsalon(Salones salonesidsalon) {
        this.salonesidsalon = salonesidsalon;
    }

    @XmlTransient
    public Collection<MateriaEnCurso> getMateriaEnCursoCollection() {
        return materiaEnCursoCollection;
    }

    public void setMateriaEnCursoCollection(Collection<MateriaEnCurso> materiaEnCursoCollection) {
        this.materiaEnCursoCollection = materiaEnCursoCollection;
    }

    @XmlTransient
    public Collection<CursosImpartidos> getCursosImpartidosCollection() {
        return cursosImpartidosCollection;
    }

    public void setCursosImpartidosCollection(Collection<CursosImpartidos> cursosImpartidosCollection) {
        this.cursosImpartidosCollection = cursosImpartidosCollection;
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
