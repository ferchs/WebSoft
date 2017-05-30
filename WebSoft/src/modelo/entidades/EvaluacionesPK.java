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
public class EvaluacionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Cursos_Materia")
    private int cursosMateria;
    @Basic(optional = false)
    @Column(name = "Cursos_Grado")
    private int cursosGrado;
    @Basic(optional = false)
    @Column(name = "Cursos_Institucion")
    private int cursosInstitucion;
    @Basic(optional = false)
    @Column(name = "Cursos_Consecutivo_curso")
    private int cursosConsecutivocurso;
    @Basic(optional = false)
    @Column(name = "tema")
    private String tema;

    public EvaluacionesPK() {
    }

    public EvaluacionesPK(int cursosMateria, int cursosGrado, int cursosInstitucion, int cursosConsecutivocurso, String tema) {
        this.cursosMateria = cursosMateria;
        this.cursosGrado = cursosGrado;
        this.cursosInstitucion = cursosInstitucion;
        this.cursosConsecutivocurso = cursosConsecutivocurso;
        this.tema = tema;
    }

    public int getCursosMateria() {
        return cursosMateria;
    }

    public void setCursosMateria(int cursosMateria) {
        this.cursosMateria = cursosMateria;
    }

    public int getCursosGrado() {
        return cursosGrado;
    }

    public void setCursosGrado(int cursosGrado) {
        this.cursosGrado = cursosGrado;
    }

    public int getCursosInstitucion() {
        return cursosInstitucion;
    }

    public void setCursosInstitucion(int cursosInstitucion) {
        this.cursosInstitucion = cursosInstitucion;
    }

    public int getCursosConsecutivocurso() {
        return cursosConsecutivocurso;
    }

    public void setCursosConsecutivocurso(int cursosConsecutivocurso) {
        this.cursosConsecutivocurso = cursosConsecutivocurso;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cursosMateria;
        hash += (int) cursosGrado;
        hash += (int) cursosInstitucion;
        hash += (int) cursosConsecutivocurso;
        hash += (tema != null ? tema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionesPK)) {
            return false;
        }
        EvaluacionesPK other = (EvaluacionesPK) object;
        if (this.cursosMateria != other.cursosMateria) {
            return false;
        }
        if (this.cursosGrado != other.cursosGrado) {
            return false;
        }
        if (this.cursosInstitucion != other.cursosInstitucion) {
            return false;
        }
        if (this.cursosConsecutivocurso != other.cursosConsecutivocurso) {
            return false;
        }
        if ((this.tema == null && other.tema != null) || (this.tema != null && !this.tema.equals(other.tema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.EvaluacionesPK[ cursosMateria=" + cursosMateria + ", cursosGrado=" + cursosGrado + ", cursosInstitucion=" + cursosInstitucion + ", cursosConsecutivocurso=" + cursosConsecutivocurso + ", tema=" + tema + " ]";
    }
    
}
