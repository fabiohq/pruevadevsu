package co.com.clientepersona.testintegracion;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import co.com.clientepersona.controller.ControllerCliente;
import co.com.clientepersona.entity.EntityCliente;
import co.com.clientepersona.modelo.ModeloCliente;
import co.com.clientepersona.modelo.ModeloResponse;
import co.com.clientepersona.service.IServiceCliente;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
public class ControllerClienteIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IServiceCliente serviceCliente;

    @InjectMocks
    private ControllerCliente controllerCliente;

    @Test
    public void testObtenerCliente() throws Exception {
        long clienteId = 1L;
        EntityCliente cliente = new EntityCliente();
        cliente.setIdcliente(clienteId);
        cliente.setNombre("Fabio Hernandez");

        when(serviceCliente.obtener(clienteId))
                .thenReturn(setModeloCliente(cliente));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clientes/{id}", clienteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.modeloClientes[0].nombre").value("Fabio Hernandez"));
    }

    private ModeloResponse setModeloCliente(EntityCliente cliente) {
        ModeloCliente modeloCliente = convertirEntityAModelo(cliente);
        ModeloResponse response = new ModeloResponse();
        response.setModeloClientes(List.of(modeloCliente));
        return response;
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
}