
import DAO.PersonasJpaController;
import DTO.Personas;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class datos {

    /**
     * Creates a new instance of datos
     */
    
    
    
    private int id;
    private String nombre;
    private String apellidos;
    private Date fnacimiento;
    private String observaciones;
    
    public datos() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void altaPersona(){
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("personas");
        PersonasJpaController ctrlPersona = new PersonasJpaController(emf);
        
        Personas perso = new Personas(null,nombre,apellidos,fnacimiento,observaciones);
        ctrlPersona.create(perso);
        
    }
    
}
