/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Jornadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jornadas.findAll", query = "SELECT j FROM Jornadas j")
    , @NamedQuery(name = "Jornadas.findByIdJornada", query = "SELECT j FROM Jornadas j WHERE j.idJornada = :idJornada")
    , @NamedQuery(name = "Jornadas.findByNombre", query = "SELECT j FROM Jornadas j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jornadas.findByHoraInicio", query = "SELECT j FROM Jornadas j WHERE j.horaInicio = :horaInicio")
    , @NamedQuery(name = "Jornadas.findByHoraFin", query = "SELECT j FROM Jornadas j WHERE j.horaFin = :horaFin")})
public class Jornadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jornada")
    private Integer idJornada;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "horaInicio")
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "horaFin")
    private String horaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jornadasidjornada")
    private Collection<Cursos> cursosCollection;

    public Jornadas() {
    }

    public Jornadas(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public Jornadas(Integer idJornada, String horaInicio, String horaFin) {
        this.idJornada = idJornada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @XmlTransient
    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJornada != null ? idJornada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jornadas)) {
            return false;
        }
        Jornadas other = (Jornadas) object;
        if ((this.idJornada == null && other.idJornada != null) || (this.idJornada != null && !this.idJornada.equals(other.idJornada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Jornadas[ idJornada=" + idJornada + " ]";
    }
    
}
