/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Documento_Identidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoIdentidad.findAll", query = "SELECT d FROM DocumentoIdentidad d")
    , @NamedQuery(name = "DocumentoIdentidad.findByPersona", query = "SELECT d FROM DocumentoIdentidad d WHERE d.persona = :persona")
    , @NamedQuery(name = "DocumentoIdentidad.findByTipo", query = "SELECT d FROM DocumentoIdentidad d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "DocumentoIdentidad.findByFechaNacimiento", query = "SELECT d FROM DocumentoIdentidad d WHERE d.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "DocumentoIdentidad.findByLugarNacimiento", query = "SELECT d FROM DocumentoIdentidad d WHERE d.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "DocumentoIdentidad.findByPaisNacimiento", query = "SELECT d FROM DocumentoIdentidad d WHERE d.paisNacimiento = :paisNacimiento")
    , @NamedQuery(name = "DocumentoIdentidad.findByRh", query = "SELECT d FROM DocumentoIdentidad d WHERE d.rh = :rh")})
public class DocumentoIdentidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Persona")
    private Integer persona;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Column(name = "pais_nacimiento")
    private String paisNacimiento;
    @Column(name = "rh")
    private String rh;
    @JoinColumn(name = "Persona", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personas personas;

    public DocumentoIdentidad() {
    }

    public DocumentoIdentidad(Integer persona) {
        this.persona = persona;
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
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
        hash += (persona != null ? persona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoIdentidad)) {
            return false;
        }
        DocumentoIdentidad other = (DocumentoIdentidad) object;
        if ((this.persona == null && other.persona != null) || (this.persona != null && !this.persona.equals(other.persona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.DocumentoIdentidad[ persona=" + persona + " ]";
    }
    
}
