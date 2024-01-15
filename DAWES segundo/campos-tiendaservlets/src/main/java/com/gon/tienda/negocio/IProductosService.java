package com.gon.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.gon.tienda.dtos.ProductoDTO;

public interface IProductosService {
	
	public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion,String precio,String cantidadStock, String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException;

	public Integer insertarProductos(String nombre, String descripcion,String precio,String cantidadStock, String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException;

	public Integer actualizarProductos(String id, String nombre, String descripcion,String precio,String cantidadStock, String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException;
	

}
