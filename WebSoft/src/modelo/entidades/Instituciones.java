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
@Table(name = "Instituciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituciones.findAll", query = "SELECT i FROM Instituciones i")
    , @NamedQuery(name = "Instituciones.findByNit", query = "SELECT i FROM Instituciones i WHERE i.nit = :nit")
    , @NamedQuery(name = "Instituciones.findByNombre", query = "SELECT i FROM Instituciones i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Instituciones.findByDireccion", query = "SELECT i FROM Instituciones i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Instituciones.findByTelefono", query = "SELECT i FROM Instituciones i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "Instituciones.findByCorreo", query = "SELECT i FROM Instituciones i WHERE i.correo = :correo")})
public class Instituciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nit")
    private Integer nit;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instituciones")
    private Collection<Sedes> sedesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instituciones")
    private Collection<Cursos> cursosCollection;

    public Instituciones() {
    }

    public Instituciones(Integer nit) {
        this.nit = nit;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Sedes> getSedesCollection() {
        return sedesCollection;
    }

    public void setSedesCollection(Collection<Sedes> sedesCollection) {
        this.sedesCollection = sedesCollection;
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
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituciones)) {
            return false;
        }
        Instituciones other = (Instituciones) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Instituciones[ nit=" + nit + " ]";
    }
    
}
