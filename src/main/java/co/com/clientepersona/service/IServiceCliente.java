package co.com.clientepersona.service;

import co.com.clientepersona.modelo.ModeloRequest;
import co.com.clientepersona.modelo.ModeloResponse;

public interface IServiceCliente {

	public ModeloResponse crear(ModeloRequest request);
	
	public ModeloResponse editar(ModeloRequest request);
	
	public ModeloResponse eliminar(long idCliente);
	
	public ModeloResponse obtener(long id);
	
	public ModeloResponse listar();
	
}
