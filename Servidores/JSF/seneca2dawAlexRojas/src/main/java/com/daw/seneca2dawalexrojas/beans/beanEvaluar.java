/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.seneca2dawalexrojas.beans;

import com.daw.seneca2dawalexrojas.DAO.AlumnoJpaController;
import com.daw.seneca2dawalexrojas.DAO.AsignaturaJpaController;
import com.daw.seneca2dawalexrojas.DAO.CursosJpaController;
import com.daw.seneca2dawalexrojas.DAO.DetallenotaJpaController;
import com.daw.seneca2dawalexrojas.DAO.ProfesorJpaController;
import com.daw.seneca2dawalexrojas.DTO.Alumno;
import com.daw.seneca2dawalexrojas.DTO.Asignatura;
import com.daw.seneca2dawalexrojas.DTO.Cursos;
import com.daw.seneca2dawalexrojas.DTO.Detallenota;
import com.daw.seneca2dawalexrojas.DTO.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author Usuario
 */
@ManagedBean(name="beanEvalua")
@ViewScoped
public class beanEvaluar {

    /**
     * Creates a new instance of beanEvaluar
     */
    ProfesorJpaController ctrlProfe;
    AsignaturaJpaController  ctrlAsig;
    CursosJpaController ctrlCurso;
    DetallenotaJpaController ctrlDet;
    AlumnoJpaController ctrlAlm;
    
    private String evaSel;
    private String cursoSel;
    private String asigSel;
    private String info;
    
    private ArrayList listaAs;
    private ArrayList listaNotas;
    private ArrayList listaNotas2;
    private ArrayList listaEva;
    private ArrayList nota;
    
    private boolean prim;
    private boolean sec;
    private boolean ter;
    
    private boolean carga;
    
    private HtmlDataTable respaldoTabla;
    
    private Detallenota detNot;
    
    @ManagedProperty("#{beanRespaldo}")
    private beanRespaldo miProfe;
    
    public beanEvaluar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.2daw_seneca2dawAlexRojas_war_1.0-SNAPSHOTPU");
        ctrlProfe = new ProfesorJpaController(emf);
        ctrlAsig = new AsignaturaJpaController(emf);
        ctrlCurso = new CursosJpaController(emf);
        ctrlDet = new DetallenotaJpaController(emf);
        ctrlAlm = new AlumnoJpaController(emf);
        
        listaAs = new ArrayList();
        listaNotas = new ArrayList();
        listaNotas2 = new ArrayList();
        nota = new ArrayList();
        listaEva = new ArrayList();
        
        
        
        prim =false;
        sec =false;
        ter =false;
        
        
        carga=false;
        
        evaSel="";
        info="";
        
        nota.add(new SelectItem(0, "0"));
        nota.add(new SelectItem(1, "1"));
        nota.add(new SelectItem(3, "3"));
        nota.add(new SelectItem(5, "5"));
        nota.add(new SelectItem(7, "7"));
        nota.add(new SelectItem(9, "9"));
        
        
        listaEva.add(new SelectItem("1","1"));
        listaEva.add(new SelectItem("2","2"));
        listaEva.add(new SelectItem("3","3"));
    }

    public Detallenota getDetNot() {
        return detNot;
    }

    public void setDetNot(Detallenota detNot) {
        this.detNot = detNot;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList getListaEva() {
        return listaEva;
    }

    public void setListaEva(ArrayList listaEva) {
        this.listaEva = listaEva;
    }

    
    
    public ArrayList getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList listaNotas) {
        this.listaNotas = listaNotas;
    }

    public HtmlDataTable getRespaldoTabla() {
        return respaldoTabla;
    }

    public void setRespaldoTabla(HtmlDataTable respaldoTabla) {
        this.respaldoTabla = respaldoTabla;
    }

    public boolean isPrim() {
        return prim;
    }

    public void setPrim(boolean prim) {
        this.prim = prim;
    }

    public boolean isSec() {
        return sec;
    }

    public void setSec(boolean sec) {
        this.sec = sec;
    }

    public boolean isTer() {
        return ter;
    }

    public void setTer(boolean ter) {
        this.ter = ter;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
    }

    
    
    public ArrayList getListaAs() {
        return listaAs;
    }

    public void setListaAs(ArrayList listaAs) {
        this.listaAs = listaAs;
    }

    public String getAsigSel() {
        return asigSel;
    }

    public void setAsigSel(String asigSel) {
        this.asigSel = asigSel;
    }

    
    
    public beanRespaldo getMiProfe() {
        return miProfe;
    }

    public void setMiProfe(beanRespaldo miProfe) {
        this.miProfe = miProfe;
    }

    public ArrayList getListaNotas2() {
        return listaNotas2;
    }

    public void setListaNotas2(ArrayList listaNotas2) {
        this.listaNotas2 = listaNotas2;
    }
    
    
    
    public String getEvaSel() {
        return evaSel;
    }

    public void setEvaSel(String evaSel) {
        this.evaSel = evaSel;
    }

    public String getCursoSel() {
        return cursoSel;
    }

    public void setCursoSel(String cursoSel) {
        this.cursoSel = cursoSel;
    }

    public ArrayList getNota() {
        return nota;
    }

    public void setNota(ArrayList nota) {
        this.nota = nota;
    }
    
    
    
    
    public ArrayList listaCurso(){
        
        ArrayList listaC = new ArrayList();
        
        Integer codProf =  miProfe.getProfe().getCodProfesor();
        
        List<Asignatura> listaAsignatura = ctrlAsig.buscarAsig(codProf.toString());
        
        /*for(Asignatura as : listaAsignatura){
            
            int codCurso = as.getIdCurso();
            
            Cursos miCurso = ctrlCurso.findCursos(codCurso);
            
            listaC.add(new SelectItem(miCurso.getIdCurso(),miCurso.getNomCursos()));
        }*/
                
                
                
        /*for(int i=0;i<=listaAsignatura.size();i++){
            Asignatura asig = listaAsignatura.get(i);
            
            
            
            Cursos miCurso =ctrlCurso.findCursos(asig.getIdCurso());
            listaAsignatura.get(i);
            //listaC.add(new SelectItem(miCurso.getIdCurso(),miCurso.getNomCursos()));
        }*/
        
        
        
        /*List<Luz> listaLuzEntera =  ctrlLuz.findLuzEntities();
        
        for(Luz lu : listaLuzEntera){
            listaL.add(new SelectItem(lu.getCodigoLuz(),(lu.getTipoLuz()+" -- "+lu.getAgua())));
        }*/
        
        List<Cursos> listaCursos = ctrlCurso.findCursosEntities();
         listaC.add(new SelectItem("","Seleccione Curso"));
        for(Cursos cu : listaCursos){
            listaC.add(new SelectItem(cu.getIdCurso(),cu.getNomCursos()));
        }
        
        return listaC;
    }
    
    public void cambiaAsig (ValueChangeEvent event){
        int miCod = Integer.parseInt((String) event.getNewValue());
        
        listaAs.clear();
        
        Profesor proff = miProfe.getProfe();
        String cod =  proff.getCodProfesor().toString();
        
        List<Asignatura> listaAsig = ctrlAsig.buscarTodasAsigProf(miCod, cod);
        
        listaAs.add(new SelectItem("","Seleccione Asignatura"));
        
        for(Asignatura as : listaAsig){
            listaAs.add(new SelectItem(as.getIdAsig(),as.getNomAsig()));
        }
        
        
        
        /*List<Flores> listaFlores = ctrlFlor.getListaFloresCod(miCod);
        
        
        Luz lu = ctrlLuz.findLuz(miCod);
        
        florDetalle = lu.getTipoLuz() + " Agua: "+lu.getAgua()+ " - "+listaFlores.size()+ " ejemplares.";
        
        
        Flores flor = ctrlFlor.findFlores(miCod);
        
        miImagen = flor.getImagen();
        
        arrayFlores.clear();
        
        for(Flores flo : listaFlores){
            arrayFlores.add(flo);
        }*/
        
    }
    
    public void cargaTabla (ValueChangeEvent event){
        int miCod = Integer.parseInt((String) event.getNewValue());
        
        listaNotas.clear();
        
        
        Asignatura asig = ctrlAsig.findAsignatura(miCod);
        
        
        
        List <Detallenota> listaDetalle = ctrlDet.buscarNotas(asig.getNomAsig());
       
        for(Detallenota de : listaDetalle){
            listaNotas.add(de);
        }
        
        listaNotas2 = listaNotas;
        
        
        
    }
    
    public void ensena(){
        
        //String eval = (String) event.getNewValue();
        
        
        switch(evaSel){
            case "1":
                prim=true;
                sec=false;
                ter=false;
                break;
            case "2":
                prim=false;
                sec=true;
                ter=false;
                break;
            case "3":
                prim=false;
                sec=false;
                ter=true;
                break;
                
        }
        
    }
    
    
    public void cargaCompleta (){
        
        carga=true;
        
        
        
    }
    
    public void verPersona(){
        
        detNot = (Detallenota) respaldoTabla.getRowData();
        
        
        
        List<Alumno> listaAlm = ctrlAlm.buscarAlum(detNot.getNomAlumno());
        
        Alumno miAlum = listaAlm.get(0);
        
        info = miAlum.getNomApell()+" "+miAlum.getLocalidad()+ "con dni: "+miAlum.getDni();
        
    }
    
    
    
}
