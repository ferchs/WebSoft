/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Informacion_Contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionContacto.findAll", query = "SELECT i FROM InformacionContacto i")
    , @NamedQuery(name = "InformacionContacto.findByPersonasId", query = "SELECT i FROM InformacionContacto i WHERE i.personasId = :personasId")
    , @NamedQuery(name = "InformacionContacto.findByDireccion", query = "SELECT i FROM InformacionContacto i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "InformacionContacto.findByTelefono", query = "SELECT i FROM InformacionContacto i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "InformacionContacto.findByCelular", query = "SELECT i FROM InformacionContacto i WHERE i.celular = :celular")
    , @NamedQuery(name = "InformacionContacto.findByCorreo", query = "SELECT i FROM InformacionContacto i WHERE i.correo = :correo")
    , @NamedQuery(name = "InformacionContacto.findByBarrio", query = "SELECT i FROM InformacionContacto i WHERE i.barrio = :barrio")
    , @NamedQuery(name = "InformacionContacto.findByEstrato", query = "SELECT i FROM InformacionContacto i WHERE i.estrato = :estrato")})
public class InformacionContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Personas_Id")
    private String personasId;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "celular")
    private String celular;
    @Column(name = "correo")
    private String correo;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "estrato")
    private String estrato;
    @JoinColumn(name = "Personas_Id", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personas personas;

    public InformacionContacto() {
    }

    public InformacionContacto(String personasId) {
        this.personasId = personasId;
    }

    public String getPersonasId() {
        return personasId;
    }

    public void setPersonasId(String personasId) {
        this.personasId = personasId;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personasId != null ? personasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionContacto)) {
            return false;
        }
        InformacionContacto other = (InformacionContacto) object;
        if ((this.personasId == null && other.personasId != null) || (this.personasId != null && !this.personasId.equals(other.personasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InformacionContacto[ personasId=" + personasId + " ]";
    }
    
}
