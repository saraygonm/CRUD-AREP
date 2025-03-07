package eci.edu.crud;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClientInterface extends CrudRepository<Client, Long> {
    //Interfaz que maneja las operaciones CRUD en la entidad Client

        // Metodo para encontrar una lista de clientes por su apellido
        List<Client> findByLastName(String lastName);
        // Metodo para encontrar un cliente por su ID
        Client findById(long id);
    }
