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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Administradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a")
    , @NamedQuery(name = "Administradores.findByUsuario", query = "SELECT a FROM Administradores a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "Administradores.findByContrase\u00f1a", query = "SELECT a FROM Administradores a WHERE a.contrase\u00f1a = :contrase\u00f1a")})
public class Administradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @JoinColumn(name = "Persona", referencedColumnName = "numero_identificacion")
    @ManyToOne(optional = false)
    private Personas persona;

    public Administradores() {
    }

    public Administradores(String usuario) {
        this.usuario = usuario;
    }

    public Administradores(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Administradores[ usuario=" + usuario + " ]";
    }
    
}
