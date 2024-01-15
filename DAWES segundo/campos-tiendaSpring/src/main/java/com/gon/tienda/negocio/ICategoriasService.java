package com.gon.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import com.gon.tienda.dtos.CategoriaDTO;

public interface ICategoriasService {
	
	
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion,String activo) throws ClassNotFoundException, SQLException;

	public Integer insertarCategorias( String nombre,String descripcion, String activo) throws ClassNotFoundException, SQLException;

	public Integer actualizarCategorias(String id, String nombre, String descripcion,String activo) throws ClassNotFoundException, SQLException;
	
	public Integer borrarCategorias(String id)throws ClassNotFoundException, SQLException;

}
