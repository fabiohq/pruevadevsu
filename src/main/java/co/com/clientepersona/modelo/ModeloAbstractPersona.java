package co.com.clientepersona.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ModeloAbstractPersona {

	protected String nombre;
	protected String genero;
	protected String edad;
	protected String identificacion;
	protected String direccion;
	protected String telefono;
}
