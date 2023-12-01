
import DAO.PersonasJpaController;
import DAO.exceptions.NonexistentEntityException;
import DTO.Personas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlDataTable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kete
 */
public class cargaPersonas {

    /**
     * Creates a new instance of cargaPersonas
     */
    
    private PersonasJpaController ctrlPersona;
    private List <Personas> listaPersonas;
    private HtmlDataTable respaldoTabla;
    private int filaSelc;
    private List listaPersonasTabla;
    private Personas personaSelc;
    
    public cargaPersonas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("personas");
        ctrlPersona = new PersonasJpaController(emf);
        
    }

    public PersonasJpaController getCtrlPersona() {
        return ctrlPersona;
    }

    public void setCtrlPersona(PersonasJpaController ctrlPersona) {
        this.ctrlPersona = ctrlPersona;
    }

    public List getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public HtmlDataTable getRespaldoTabla() {
        return respaldoTabla;
    }

    public void setRespaldoTabla(HtmlDataTable respaldoTabla) {
        this.respaldoTabla = respaldoTabla;
    }

    public int getFilaSelc() {
        return filaSelc;
    }

    public void setFilaSelc(int filaSelc) {
        this.filaSelc = filaSelc;
    }

    public List getListaPersonasTabla() {
        return listaPersonasTabla;
    }

    public void setListaPersonasTabla(List listaPersonasTabla) {
        this.listaPersonasTabla = listaPersonasTabla;
    }

    public Personas getPersonaSelc() {
        return personaSelc;
    }

    public void setPersonaSelc(Personas personaSelc) {
        this.personaSelc = personaSelc;
    }
    
    public List<Personas> getListaPersona(){
        listaPersonas = ctrlPersona.findPersonasEntities();
        
        return listaPersonas;
    }
    
    public void eliminaPersona (){
        Personas per = (Personas) respaldoTabla.getRowData();
        try {
            ctrlPersona.destroy(per.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(cargaPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verPersona(){
        respaldoTabla.setBgcolor("green");
        filaSelc = respaldoTabla.getRowIndex();
        listaPersonasTabla = (List <Personas>) respaldoTabla.getValue();
        personaSelc = (Personas) respaldoTabla.getRowData();
        
    }
    
    public void editaPersona(){
        Personas per = (Personas) respaldoTabla.getRowData();
        
        try {
            ctrlPersona.edit(per);
        } catch (Exception ex) {
            Logger.getLogger(cargaPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
