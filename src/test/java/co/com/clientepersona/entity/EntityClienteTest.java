package co.com.clientepersona.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EntityClienteTest {

	private EntityCliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new EntityCliente();
        cliente.setIdcliente(1L);
        cliente.setNombre("Juan");
        cliente.setGenero("Masculino");
        cliente.setEdad("30");
        cliente.setIdentificacion("12345");
        cliente.setDireccion("Calle 123");
        cliente.setTelefono("1234567890");
        cliente.setClave("clave123");
        cliente.setEstado("Activo");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1L, cliente.getIdcliente());
        assertEquals("Juan", cliente.getNombre());
        assertEquals("Masculino", cliente.getGenero());
        assertEquals("30", cliente.getEdad());
        assertEquals("12345", cliente.getIdentificacion());
        assertEquals("Calle 123", cliente.getDireccion());
        assertEquals("1234567890", cliente.getTelefono());
        assertEquals("clave123", cliente.getClave());
        assertEquals("Activo", cliente.getEstado());
    }

    @Test
    public void testToString() {
        String expectedString = "co.com.devsu.entity.Cliente[ idcliente=1 ]";
        assertEquals(expectedString, cliente.toString());
    }

    @Test
    public void testConstructorWithId() {
        EntityCliente clienteConId = new EntityCliente(2);
        assertEquals(2, clienteConId.getIdcliente());
    }

    @Test
    public void testDefaultConstructor() {
        EntityCliente cliente = new EntityCliente();
        assertNotNull(cliente);
    }
}
