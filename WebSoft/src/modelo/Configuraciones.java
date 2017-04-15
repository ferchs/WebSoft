/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ferchs
 */
public class Configuraciones {     
     private String rutaArchivoConfiguracion;

    public Configuraciones(String rutaArchivoConfiguracion){
        this.rutaArchivoConfiguracion = rutaArchivoConfiguracion;
    }
    
    public Properties obtenerConfiguracionesProperties(){
         try {
             return cargarConfiguraciones();
         } catch (IOException ex) {
             return null;
         }
    }
    
    public String obtenerConfiguracionPropertie(String nombreConfiguracion) throws IOException, ParserConfigurationException, ParserConfigurationException, SAXException, SAXException, SAXException, SAXException{
        Properties propiedades= cargarConfiguraciones();
        String propiedad=propiedades.getProperty(nombreConfiguracion);
        return propiedad;
    }
    
     public void escribirConfiguracionPropertie(String nombreConfiguracion, String valorConfiguracion) throws IOException{
        Properties propiedades= cargarConfiguraciones();
        FileWriter salida =new FileWriter(rutaArchivoConfiguracion,false);
        propiedades.setProperty(nombreConfiguracion, valorConfiguracion);
        propiedades.store(salida,null);
        salida.close();
    }
     
     private Properties cargarConfiguraciones() throws IOException{
        FileReader entrada;
         try {
             entrada = new FileReader(rutaArchivoConfiguracion);
         } catch (FileNotFoundException ex) {
             File archivo = new File(rutaArchivoConfiguracion);
             archivo.createNewFile();
             entrada = new FileReader(rutaArchivoConfiguracion);
         }
          Properties propiedades = new Properties();
          propiedades.load(entrada);
          entrada.close();
          return propiedades;
     }
     
     public String obtenerConfiguracionXML(String nombreNodoConfiguracion, String nombreAtributoClave, String valorClave, String nombreAtributoValor){
         Document documento=cargarXML();
         Node nodoConfiguracion=encontarNodoConValorAtributo(documento,nombreNodoConfiguracion,nombreAtributoClave,valorClave);
         NamedNodeMap configuraciones = nodoConfiguracion.getAttributes();
         String configuracion=configuraciones.getNamedItem(nombreAtributoValor).getTextContent();
         return configuracion;
     }
     
     
     public void escribirConfiguracionXML(String nombreNodoConfiguracion, String nombreAtributoClave, String valorClave, String nombreAtributoValor, String valor){
         Document documento=cargarXML();
         Node nodoConfiguracion=encontarNodoConValorAtributo(documento,nombreNodoConfiguracion,nombreAtributoClave,valorClave);
         NamedNodeMap configuraciones = nodoConfiguracion.getAttributes();
         Node nodeAttr = configuraciones.getNamedItem(nombreAtributoValor);
         nodeAttr.setTextContent(valor);
         GuardarCambioXML(documento);
     }
     
     private Document cargarXML(){
         try {
             String filepath = rutaArchivoConfiguracion;
             DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
             Document doc = docBuilder.parse(filepath);
             return doc;
         } catch (SAXException ex) {
             return null;
         } catch (IOException ex) {
             return null;
         } catch (ParserConfigurationException ex) {
             return null;
         }
     }
     
     private  Node encontarNodoConValorAtributo (Document documento, String nombreNodo, String idAtributo, String valorAtributo){
         NodeList listaNodos= documento.getElementsByTagName(nombreNodo);
         boolean encontrado=false;
         for (int i = 0; i < listaNodos.getLength() && !encontrado; i++) {
             Node node = listaNodos.item(i);
             NamedNodeMap atributos = node.getAttributes();
             String atributo=atributos.getNamedItem(idAtributo).getTextContent();
             if(atributo.equals(valorAtributo)){
                 encontrado=true;
                 return node;
             }
         }
         return null;
     }
     
     private void GuardarCambioXML(Document documento){
         try {
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(documento);
             StreamResult result = new StreamResult(new File(rutaArchivoConfiguracion));
             transformer.transform(source, result);
         } catch (TransformerConfigurationException ex) {
             Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TransformerException ex) {
             Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}