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
public class MateriaEnCursoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Estudiantes_Personas_numero_identificacion")
    private String estudiantesPersonasnumeroidentificacion;
    @Basic(optional = false)
    @Column(name = "Materias_codigo_materia")
    private int materiascodigomateria;
    @Basic(optional = false)
    @Column(name = "Cursos_Grados_idGrado")
    private int cursosGradosidGrado;
    @Basic(optional = false)
    @Column(name = "Cursos_Grados_Instituciones_nit")
    private int cursosGradosInstitucionesnit;
    @Basic(optional = false)
    @Column(name = "Cursos_consecutivo")
    private int cursosconsecutivo;

    public MateriaEnCursoPK() {
    }

    public MateriaEnCursoPK(String estudiantesPersonasnumeroidentificacion, int materiascodigomateria, int cursosGradosidGrado, int cursosGradosInstitucionesnit, int cursosconsecutivo) {
        this.estudiantesPersonasnumeroidentificacion = estudiantesPersonasnumeroidentificacion;
        this.materiascodigomateria = materiascodigomateria;
        this.cursosGradosidGrado = cursosGradosidGrado;
        this.cursosGradosInstitucionesnit = cursosGradosInstitucionesnit;
        this.cursosconsecutivo = cursosconsecutivo;
    }

    public String getEstudiantesPersonasnumeroidentificacion() {
        return estudiantesPersonasnumeroidentificacion;
    }

    public void setEstudiantesPersonasnumeroidentificacion(String estudiantesPersonasnumeroidentificacion) {
        this.estudiantesPersonasnumeroidentificacion = estudiantesPersonasnumeroidentificacion;
    }

    public int getMateriascodigomateria() {
        return materiascodigomateria;
    }

    public void setMateriascodigomateria(int materiascodigomateria) {
        this.materiascodigomateria = materiascodigomateria;
    }

    public int getCursosGradosidGrado() {
        return cursosGradosidGrado;
    }

    public void setCursosGradosidGrado(int cursosGradosidGrado) {
        this.cursosGradosidGrado = cursosGradosidGrado;
    }

    public int getCursosGradosInstitucionesnit() {
        return cursosGradosInstitucionesnit;
    }

    public void setCursosGradosInstitucionesnit(int cursosGradosInstitucionesnit) {
        this.cursosGradosInstitucionesnit = cursosGradosInstitucionesnit;
    }

    public int getCursosconsecutivo() {
        return cursosconsecutivo;
    }

    public void setCursosconsecutivo(int cursosconsecutivo) {
        this.cursosconsecutivo = cursosconsecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiantesPersonasnumeroidentificacion != null ? estudiantesPersonasnumeroidentificacion.hashCode() : 0);
        hash += (int) materiascodigomateria;
        hash += (int) cursosGradosidGrado;
        hash += (int) cursosGradosInstitucionesnit;
        hash += (int) cursosconsecutivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaEnCursoPK)) {
            return false;
        }
        MateriaEnCursoPK other = (MateriaEnCursoPK) object;
        if ((this.estudiantesPersonasnumeroidentificacion == null && other.estudiantesPersonasnumeroidentificacion != null) || (this.estudiantesPersonasnumeroidentificacion != null && !this.estudiantesPersonasnumeroidentificacion.equals(other.estudiantesPersonasnumeroidentificacion))) {
            return false;
        }
        if (this.materiascodigomateria != other.materiascodigomateria) {
            return false;
        }
        if (this.cursosGradosidGrado != other.cursosGradosidGrado) {
            return false;
        }
        if (this.cursosGradosInstitucionesnit != other.cursosGradosInstitucionesnit) {
            return false;
        }
        if (this.cursosconsecutivo != other.cursosconsecutivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.MateriaEnCursoPK[ estudiantesPersonasnumeroidentificacion=" + estudiantesPersonasnumeroidentificacion + ", materiascodigomateria=" + materiascodigomateria + ", cursosGradosidGrado=" + cursosGradosidGrado + ", cursosGradosInstitucionesnit=" + cursosGradosInstitucionesnit + ", cursosconsecutivo=" + cursosconsecutivo + " ]";
    }
    
}
