package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Suscrip;

public interface SuscripService {
	public List<Suscrip> FindAll();
    public Suscrip FindById(String clave);
    public void save(Suscrip producto);
    public void edit (Suscrip producto);
    public void delete(String email);
}
