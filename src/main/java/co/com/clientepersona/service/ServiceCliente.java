package co.com.clientepersona.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.clientepersona.entity.EntityCliente;
import co.com.clientepersona.excepciones.LocalException;
import co.com.clientepersona.excepciones.LocalMessage;
import co.com.clientepersona.modelo.ModeloCliente;
import co.com.clientepersona.modelo.ModeloRequest;
import co.com.clientepersona.modelo.ModeloResponse;
import co.com.clientepersona.repository.IRepositoryCliente;

@Service
public class ServiceCliente implements IServiceCliente {

	@Autowired
	private IRepositoryCliente repositoryCliente;

	@Override
	public ModeloResponse crear(ModeloRequest request) {

		EntityCliente entity = convertirModeloAEntity(request.getCliente());
		entity = repositoryCliente.save(entity);

		ModeloCliente modelo = convertirEntityAModelo(entity);
		ModeloResponse response = new ModeloResponse();

		List<ModeloCliente> modeloClientes = new ArrayList<ModeloCliente>();
		modeloClientes.add(modelo);

		response.setModeloClientes(modeloClientes);

		return response;
	}

	@Override
	public ModeloResponse editar(ModeloRequest request) {

		if (request.getCliente().getIdcliente() == 0) {
//			throw new Exception();
		}

		if (repositoryCliente.findById(request.getCliente().getIdcliente()).isEmpty()) {
//			throw new Exception();
		}

		EntityCliente entity = convertirModeloAEntity(request.getCliente());
		entity = repositoryCliente.save(entity);

		ModeloCliente modelo = convertirEntityAModelo(entity);

		return setModeloCliente(modelo);
	}

	@Override
	public ModeloResponse eliminar(long idCliente) {

		repositoryCliente.deleteById(idCliente);

		return listar();
	}

	@Override
	public ModeloResponse obtener(long id) {

		ModeloResponse response = new ModeloResponse();

		Optional<EntityCliente> opcionalCliente = repositoryCliente.findById(id);

		if (opcionalCliente.isPresent()) {

			ModeloCliente modeloCliente = convertirEntityAModelo(opcionalCliente.get());

			response = setModeloCliente(modeloCliente);

		} else {

			LocalMessage localMenssage = new LocalMessage();
			localMenssage.setMensageError("Cliente no encontrado ");
			localMenssage.setCodigoError("400");

		}

		return response;
	}

	@Override
	public ModeloResponse listar() {

		List<EntityCliente> entities = repositoryCliente.findAll();
		ModeloResponse response = new ModeloResponse();
		response.setModeloClientes(entities.stream().map(e -> convertirEntityAModelo(e)).collect(Collectors.toList()));
		return response;
	}

	private EntityCliente convertirModeloAEntity(ModeloCliente modelo) {

		EntityCliente entity = new EntityCliente();
		entity.setIdcliente(modelo.getIdcliente());
		entity.setClave(modelo.getClave());
		entity.setEstado(modelo.getEstado());
		entity.setNombre(modelo.getNombre());
		entity.setGenero(modelo.getGenero());
		entity.setEdad(modelo.getEdad());
		entity.setIdentificacion(modelo.getIdentificacion());
		entity.setDireccion(modelo.getDireccion());
		entity.setTelefono(modelo.getTelefono());

		return entity;
	}

	private ModeloCliente convertirEntityAModelo(EntityCliente entity) {

		ModeloCliente modelo = new ModeloCliente();
		modelo.setIdcliente(entity.getIdcliente());
		modelo.setClave(entity.getClave());
		modelo.setEstado(entity.getEstado());
		modelo.setNombre(entity.getNombre());
		modelo.setGenero(entity.getGenero());
		modelo.setEdad(entity.getEdad());
		modelo.setIdentificacion(entity.getIdentificacion());
		modelo.setDireccion(entity.getDireccion());
		modelo.setTelefono(entity.getTelefono());

		return modelo;
	}

	private ModeloResponse setModeloCliente(ModeloCliente modelo) {

		List<ModeloCliente> modeloClientes = new ArrayList<ModeloCliente>();
		modeloClientes.add(modelo);
		ModeloResponse response = new ModeloResponse();
		response.setModeloClientes(modeloClientes);

		return response;
	}

}
