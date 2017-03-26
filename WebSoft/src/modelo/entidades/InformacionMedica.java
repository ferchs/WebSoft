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
@Table(name = "Informacion_Medica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionMedica.findAll", query = "SELECT i FROM InformacionMedica i")
    , @NamedQuery(name = "InformacionMedica.findByPersonasId", query = "SELECT i FROM InformacionMedica i WHERE i.personasId = :personasId")
    , @NamedQuery(name = "InformacionMedica.findByNombreEps", query = "SELECT i FROM InformacionMedica i WHERE i.nombreEps = :nombreEps")
    , @NamedQuery(name = "InformacionMedica.findBySisben", query = "SELECT i FROM InformacionMedica i WHERE i.sisben = :sisben")
    , @NamedQuery(name = "InformacionMedica.findByNivel", query = "SELECT i FROM InformacionMedica i WHERE i.nivel = :nivel")})
public class InformacionMedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Personas_Id")
    private String personasId;
    @Column(name = "nombre_eps")
    private String nombreEps;
    @Column(name = "sisben")
    private String sisben;
    @Column(name = "nivel")
    private String nivel;
    @JoinColumn(name = "Personas_Id", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personas personas;

    public InformacionMedica() {
    }

    public InformacionMedica(String personasId) {
        this.personasId = personasId;
    }

    public String getPersonasId() {
        return personasId;
    }

    public void setPersonasId(String personasId) {
        this.personasId = personasId;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    public String getSisben() {
        return sisben;
    }

    public void setSisben(String sisben) {
        this.sisben = sisben;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
        if (!(object instanceof InformacionMedica)) {
            return false;
        }
        InformacionMedica other = (InformacionMedica) object;
        if ((this.personasId == null && other.personasId != null) || (this.personasId != null && !this.personasId.equals(other.personasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.InformacionMedica[ personasId=" + personasId + " ]";
    }
    
}
