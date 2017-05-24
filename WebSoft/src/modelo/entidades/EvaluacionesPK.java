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
    @Column(name = "Consecutivo")
    private int consecutivo;
    @Basic(optional = false)
    @Column(name = "Curso_Materia")
    private int cursoMateria;
    @Basic(optional = false)
    @Column(name = "Cursos_Profesor")
    private String cursosProfesor;
    @Basic(optional = false)
    @Column(name = "Cursos_Grado")
    private int cursosGrado;
    @Basic(optional = false)
    @Column(name = "Cursos_Institucion")
    private int cursosInstitucion;
    @Basic(optional = false)
    @Column(name = "Cursos_Consecutivo")
    private int cursosConsecutivo;

    public EvaluacionesPK() {
    }

    public EvaluacionesPK(int consecutivo, int cursoMateria, String cursosProfesor, int cursosGrado, int cursosInstitucion, int cursosConsecutivo) {
        this.consecutivo = consecutivo;
        this.cursoMateria = cursoMateria;
        this.cursosProfesor = cursosProfesor;
        this.cursosGrado = cursosGrado;
        this.cursosInstitucion = cursosInstitucion;
        this.cursosConsecutivo = cursosConsecutivo;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getCursoMateria() {
        return cursoMateria;
    }

    public void setCursoMateria(int cursoMateria) {
        this.cursoMateria = cursoMateria;
    }

    public String getCursosProfesor() {
        return cursosProfesor;
    }

    public void setCursosProfesor(String cursosProfesor) {
        this.cursosProfesor = cursosProfesor;
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

    public int getCursosConsecutivo() {
        return cursosConsecutivo;
    }

    public void setCursosConsecutivo(int cursosConsecutivo) {
        this.cursosConsecutivo = cursosConsecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consecutivo;
        hash += (int) cursoMateria;
        hash += (cursosProfesor != null ? cursosProfesor.hashCode() : 0);
        hash += (int) cursosGrado;
        hash += (int) cursosInstitucion;
        hash += (int) cursosConsecutivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionesPK)) {
            return false;
        }
        EvaluacionesPK other = (EvaluacionesPK) object;
        if (this.consecutivo != other.consecutivo) {
            return false;
        }
        if (this.cursoMateria != other.cursoMateria) {
            return false;
        }
        if ((this.cursosProfesor == null && other.cursosProfesor != null) || (this.cursosProfesor != null && !this.cursosProfesor.equals(other.cursosProfesor))) {
            return false;
        }
        if (this.cursosGrado != other.cursosGrado) {
            return false;
        }
        if (this.cursosInstitucion != other.cursosInstitucion) {
            return false;
        }
        if (this.cursosConsecutivo != other.cursosConsecutivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.EvaluacionesPK[ consecutivo=" + consecutivo + ", cursoMateria=" + cursoMateria + ", cursosProfesor=" + cursosProfesor + ", cursosGrado=" + cursosGrado + ", cursosInstitucion=" + cursosInstitucion + ", cursosConsecutivo=" + cursosConsecutivo + " ]";
    }
    
}
