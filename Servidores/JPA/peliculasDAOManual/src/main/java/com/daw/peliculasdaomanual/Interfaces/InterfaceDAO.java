/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface InterfaceDAO {
    public boolean create(Object obj);
    public Object read(String val);
    public boolean update(Object obj);
    public boolean delete (String val);
    public ArrayList consulta(String att, String val);
    
    public ArrayList consulta ();
}
