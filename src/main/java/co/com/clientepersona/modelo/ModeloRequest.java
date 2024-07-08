package co.com.clientepersona.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloRequest{

	private ModeloCliente cliente;
}
