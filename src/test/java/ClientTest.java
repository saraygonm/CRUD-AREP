import eci.edu.crud.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    void newClientTest() {
        //verificar Creacionde un nuevo cliente
        Client cliente = new Client("John", "Doe"); // Crea un nuevo cliente
        assertNotNull(cliente); // Verifica que el cliente no sea nulo
        assertEquals("John", cliente.getFirstName()); // Verifica el nombre
        assertEquals("Doe", cliente.getLastName()); // Verifica el apellido
    }

    @Test
    void ClientIDTest() {
        //verificaion de ID de un cliente
        Client cliente = new Client("Jane", "Smith");
        cliente.setId(1L); // Establece un ID
        assertEquals(1L, cliente.getId()); // Verifica que el ID se haya establecido correctamente
    }


    @Test
    void ClientToStringTest() {
        // Prueba para verificar la representación en cadena del cliente
        Client cliente = new Client("Alice", "Wonderland");
        cliente.setId(2L); // Establece un ID
        String expected = "Customer[id=2, firstName='Alice', lastName='Wonderland']"; // Representación esperada
        assertEquals(expected, cliente.toString()); // Verifica la representación en cadena
    }



    @Test
    void customerFirstNameTest() {
        // Prueba para verificar el nombre de pila del cliente
        Client cliente = new Client("Tom", "Jones");
        assertEquals("Tom", cliente.getFirstName()); // Verifica el nombre de pila
    }


    @Test
    void customerLastNameTest() {
        // Prueba para verificar el apellido del cliente
        Client cliente = new Client("Tom", "Jones");
        assertEquals("Jones", cliente.getLastName()); // Verifica el apellido
    }


    @Test
    void setFirstNameTest() {
        // Prueba para establecer un nuevo nombre
        Client client = new Client("John", "Doe");
        client.setFirstName("Johnny"); // Establece un nuevo nombre de pila
        assertEquals("Johnny", client.getFirstName()); // Verifica el nuevo nombre de pila
    }

    @Test
    void setLastNameTest() {
        // Prueba para establecer un nuevo  apellido
        Client cliente = new Client("John", "Doe");
        cliente.setLastName("Doe Jr."); // Establece un nuevo apellido
        assertEquals("Doe Jr.", cliente.getLastName()); // Verifica el nuevo apellido
    }


    @Test
    void customerIdIsNullInitially() {
        //verificar que el ID del cliente es nulo inicialmente
        Client cliente = new Client("John", "Doe");
        assertNull(cliente.getId()); // Verifica que el ID sea nulo al inicio
    }


    @Test
    void customerSetIdTest() {
        //establecer y verificar el ID de un cliente
        Client cliente = new Client("Alice", "Smith");
        cliente.setId(3L); // Establece un ID
        assertEquals(3L, cliente.getId()); // Verifica que el ID se haya establecido correctamente
    }
}
