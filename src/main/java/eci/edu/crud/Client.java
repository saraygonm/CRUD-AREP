package eci.edu.crud;

import jakarta.persistence.Entity; // Importación de la anotación Entity para definir una entidad JPA
import jakarta.persistence.GeneratedValue; // Importación de la anotación para indicar que el valor es generado automáticamente
import jakarta.persistence.GenerationType; // Importación de la clase que define las estrategias de generación de ID
import jakarta.persistence.Id; // Importación de la anotación para definir la clave primaria de la entidad

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // valor del ID generado automáticamente
    private Long id;
    private String firstName;
    private String lastName;
    protected Client() {} //Constructor protegido


    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        //representacion de la entidad como cadena
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']", // Formato de la representación
                id, firstName, lastName); // Inserción de valores en el formato
    }

    // Métodos getter (accede)

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //Metodos seter modifican
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
