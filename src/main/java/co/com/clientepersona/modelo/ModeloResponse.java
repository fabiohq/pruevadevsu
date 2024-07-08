package co.com.clientepersona.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.clientepersona.excepciones.LocalMessage;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModeloResponse {

	private List<ModeloCliente> modeloClientes;
	private LocalMessage localMessage;
}
