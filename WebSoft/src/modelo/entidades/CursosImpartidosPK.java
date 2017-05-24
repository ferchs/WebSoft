/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ferchs
 */
@Embeddable
public class CursosImpartidosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Materia")
    private int materia;
    @Basic(optional = false)
    @Column(name = "Profesor")
    private String profesor;
    @Basic(optional = false)
    @Column(name = "Grado")
    private int grado;
    @Basic(optional = false)
    @Column(name = "Institucion")
    private int institucion;
    @Basic(optional = false)
    @Column(name = "Consecutivo_curso")
    private int consecutivocurso;

    public CursosImpartidosPK() {
    }

    public CursosImpartidosPK(int materia, String profesor, int grado, int institucion, int consecutivocurso) {
        this.materia = materia;
        this.profesor = profesor;
        this.grado = grado;
        this.institucion = institucion;
        this.consecutivocurso = consecutivocurso;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getInstitucion() {
        return institucion;
    }

    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

    public int getConsecutivocurso() {
        return consecutivocurso;
    }

    public void setConsecutivocurso(int consecutivocurso) {
        this.consecutivocurso = consecutivocurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) materia;
        hash += (profesor != null ? profesor.hashCode() : 0);
        hash += (int) grado;
        hash += (int) institucion;
        hash += (int) consecutivocurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosImpartidosPK)) {
            return false;
        }
        CursosImpartidosPK other = (CursosImpartidosPK) object;
        if (this.materia != other.materia) {
            return false;
        }
        if ((this.profesor == null && other.profesor != null) || (this.profesor != null && !this.profesor.equals(other.profesor))) {
            return false;
        }
        if (this.grado != other.grado) {
            return false;
        }
        if (this.institucion != other.institucion) {
            return false;
        }
        if (this.consecutivocurso != other.consecutivocurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CursosImpartidosPK[ materia=" + materia + ", profesor=" + profesor + ", grado=" + grado + ", institucion=" + institucion + ", consecutivocurso=" + consecutivocurso + " ]";
    }
    
}
