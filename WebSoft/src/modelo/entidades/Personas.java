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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferchs
 */
@Entity
@Table(name = "Personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p")
    , @NamedQuery(name = "Personas.findByNumeroIdentificacion", query = "SELECT p FROM Personas p WHERE p.numeroIdentificacion = :numeroIdentificacion")
    , @NamedQuery(name = "Personas.findByPrimerNombre", query = "SELECT p FROM Personas p WHERE p.primerNombre = :primerNombre")
    , @NamedQuery(name = "Personas.findBySegundoNombre", query = "SELECT p FROM Personas p WHERE p.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Personas.findByPrimerApellido", query = "SELECT p FROM Personas p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Personas.findBySegundoApellido", query = "SELECT p FROM Personas p WHERE p.segundoApellido = :segundoApellido")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero_identificacion")
    private Integer numeroIdentificacion;
    @Basic(optional = false)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<Administradores> administradoresCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private InformacionContacto informacionContacto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private Estudiantes estudiantes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private Profesores profesores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personas")
    private Collection<Responsables> responsablesCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private DocumentoIdentidad documentoIdentidad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private InformacionMedica informacionMedica;

    public Personas() {
    }

    public Personas(Integer numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Personas(Integer numeroIdentificacion, String primerNombre, String primerApellido) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public Integer getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Integer numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @XmlTransient
    public Collection<Administradores> getAdministradoresCollection() {
        return administradoresCollection;
    }

    public void setAdministradoresCollection(Collection<Administradores> administradoresCollection) {
        this.administradoresCollection = administradoresCollection;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public void setInformacionContacto(InformacionContacto informacionContacto) {
        this.informacionContacto = informacionContacto;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    @XmlTransient
    public Collection<Responsables> getResponsablesCollection() {
        return responsablesCollection;
    }

    public void setResponsablesCollection(Collection<Responsables> responsablesCollection) {
        this.responsablesCollection = responsablesCollection;
    }

    public DocumentoIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(DocumentoIdentidad documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public InformacionMedica getInformacionMedica() {
        return informacionMedica;
    }

    public void setInformacionMedica(InformacionMedica informacionMedica) {
        this.informacionMedica = informacionMedica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroIdentificacion != null ? numeroIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.numeroIdentificacion == null && other.numeroIdentificacion != null) || (this.numeroIdentificacion != null && !this.numeroIdentificacion.equals(other.numeroIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Personas[ numeroIdentificacion=" + numeroIdentificacion + " ]";
    }
    
}
