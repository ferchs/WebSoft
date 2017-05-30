/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "Materia_En_Curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaEnCurso.findAll", query = "SELECT m FROM MateriaEnCurso m")
    , @NamedQuery(name = "MateriaEnCurso.findByEstudiantesPersonasnumeroidentificacion", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.estudiantesPersonasnumeroidentificacion = :estudiantesPersonasnumeroidentificacion")
    , @NamedQuery(name = "MateriaEnCurso.findByMateriascodigomateria", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.materiascodigomateria = :materiascodigomateria")
    , @NamedQuery(name = "MateriaEnCurso.findByCursosGradosidGrado", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.cursosGradosidGrado = :cursosGradosidGrado")
    , @NamedQuery(name = "MateriaEnCurso.findByCursosGradosInstitucionesnit", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.cursosGradosInstitucionesnit = :cursosGradosInstitucionesnit")
    , @NamedQuery(name = "MateriaEnCurso.findByCursosconsecutivo", query = "SELECT m FROM MateriaEnCurso m WHERE m.materiaEnCursoPK.cursosconsecutivo = :cursosconsecutivo")
    , @NamedQuery(name = "MateriaEnCurso.findByNotaDefinitiva", query = "SELECT m FROM MateriaEnCurso m WHERE m.notaDefinitiva = :notaDefinitiva")
    , @NamedQuery(name = "MateriaEnCurso.findByTotalInasistencias", query = "SELECT m FROM MateriaEnCurso m WHERE m.totalInasistencias = :totalInasistencias")})
public class MateriaEnCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaEnCursoPK materiaEnCursoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota_Definitiva")
    private Double notaDefinitiva;
    @Column(name = "total_inasistencias")
    private Integer totalInasistencias;
    @JoinColumn(name = "Estudiantes_Personas_numero_identificacion", referencedColumnName = "Personas_numero_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumn(name = "Materias_codigo_materia", referencedColumnName = "codigo_materia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materias materias;
    @JoinColumns({
        @JoinColumn(name = "Cursos_Grados_idGrado", referencedColumnName = "Grados_idGrado", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_Grados_Instituciones_nit", referencedColumnName = "Grados_Instituciones_nit", insertable = false, updatable = false)
        , @JoinColumn(name = "Cursos_consecutivo", referencedColumnName = "consecutivo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cursos cursos;

    public MateriaEnCurso() {
    }

    public MateriaEnCurso(MateriaEnCursoPK materiaEnCursoPK) {
        this.materiaEnCursoPK = materiaEnCursoPK;
    }

    public MateriaEnCurso(String estudiantesPersonasnumeroidentificacion, int materiascodigomateria, int cursosGradosidGrado, int cursosGradosInstitucionesnit, int cursosconsecutivo) {
        this.materiaEnCursoPK = new MateriaEnCursoPK(estudiantesPersonasnumeroidentificacion, materiascodigomateria, cursosGradosidGrado, cursosGradosInstitucionesnit, cursosconsecutivo);
    }

    public MateriaEnCursoPK getMateriaEnCursoPK() {
        return materiaEnCursoPK;
    }

    public void setMateriaEnCursoPK(MateriaEnCursoPK materiaEnCursoPK) {
        this.materiaEnCursoPK = materiaEnCursoPK;
    }

    public Double getNotaDefinitiva() {
        return notaDefinitiva;
    }

    public void setNotaDefinitiva(Double notaDefinitiva) {
        this.notaDefinitiva = notaDefinitiva;
    }

    public Integer getTotalInasistencias() {
        return totalInasistencias;
    }

    public void setTotalInasistencias(Integer totalInasistencias) {
        this.totalInasistencias = totalInasistencias;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaEnCursoPK != null ? materiaEnCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaEnCurso)) {
            return false;
        }
        MateriaEnCurso other = (MateriaEnCurso) object;
        if ((this.materiaEnCursoPK == null && other.materiaEnCursoPK != null) || (this.materiaEnCursoPK != null && !this.materiaEnCursoPK.equals(other.materiaEnCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.MateriaEnCurso[ materiaEnCursoPK=" + materiaEnCursoPK + " ]";
    }
    
}
