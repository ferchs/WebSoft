/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.DocumentoIdentidad;
import modelo.entidades.InformacionContacto;
import modelo.entidades.InformacionMedica;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class Persona extends AbstractFacade{
        
    private Personas persona;
    
    private EntityManager em;

    public Persona() {
        super(Personas.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Personas crearPersona(String numeroId, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, DocumentoIdentidad docId,InformacionContacto infoContacto,InformacionMedica infoMedica){
        persona= new Personas();
        persona.setNumeroIdentificacion(numeroId);
        persona.setPrimerNombre(primerNombre);
        persona.setSegundoNombre(segundoNombre);
        persona.setPrimerApellido(primerApellido);
        persona.setSegundoApellido(segundoApellido);
        persona.setDocumentoIdentidad(docId);
        persona.setInformacionContacto(infoContacto);
        persona.setInformacionMedica(infoMedica);
        super.create(persona);
        return persona;
    }
    
    public Personas editarPersona(String numeroId, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, DocumentoIdentidad docId,InformacionContacto infoContacto,InformacionMedica infoMedica){
        persona= (Personas) super.find(numeroId);
        persona.setNumeroIdentificacion(numeroId);
        persona.setPrimerNombre(primerNombre);
        persona.setSegundoNombre(segundoNombre);
        persona.setPrimerApellido(primerApellido);
        persona.setSegundoApellido(segundoApellido);
        persona.setDocumentoIdentidad(docId);
        persona.setInformacionContacto(infoContacto);
        persona.setInformacionMedica(infoMedica);
        super.edit(persona);
        return persona;
    }
    
    public Personas buscarPersonaPorId(String idPersona){
        Personas estudiante=(Personas) super.find(idPersona);
        return estudiante;
    }
    
    public boolean eliminarPersona(String numeroId){
        boolean eliminada=true;
        try{
        persona= new Personas();
        persona=buscarPersonaPorId(numeroId);
        super.remove(persona);
        }
        catch(Exception e){
            eliminada=false;
        }
        return eliminada;
    }
    
}
