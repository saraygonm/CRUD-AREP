package eci.edu.crud;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    
    @Test
    void propertyCreationTest() {
        // Prueba para verificar la creación de una nueva propiedad
        Properties property = new Properties("123 Main St", 250000, 100, "Beautiful house"); // Crea una nueva propiedad
        assertNotNull(property);
        //Verificaciones
        assertEquals("123 Main St", property.getAddress());
        assertEquals(250000, property.getPrice());
        assertEquals(100, property.getSize());
        assertEquals("Beautiful house", property.getDescription());
    }


    @Test
    void propertyIdTest() {
        // Prueba para verificar el ID de una propiedad
        Properties property = new Properties("456 Elm St", 300000, 150, "Spacious apartment");
        property.setId(1L); // Establece un ID
        assertEquals(1L, property.getId()); // Verifica que el ID se haya establecido correctamente
    }


    @Test
    void defaultConstructorTest() {
        // Prueba para verificar el constructor por defecto
        Properties property = new Properties();
        assertNotNull(property);
    }


    @Test
    void propertyAddressTest() {
        // Prueba para verificar la dirección de una propiedad
        Properties property = new Properties("321 Oak St", 150000, 80, "Cozy cottage");
        assertEquals("321 Oak St", property.getAddress());
    }


    @Test
    void propertyPriceTest() {
        // Prueba para verificar el precio de una propiedad
        Properties property = new Properties("654 Maple St", 350000, 120, "Modern home");
        assertEquals(350000, property.getPrice());
    }


    @Test
    void setSizeTest() {
        // Prueba para establecer un nuevo tamaño en una propiedad
        Properties property = new Properties("987 Birch St", 500000, 250, "Spacious mansion");
        property.setSize(300);
        assertEquals(300, property.getSize());
    }


    @Test
    void setDescriptionTest() {
        // Prueba para establecer una nueva descripción en una propiedad
        Properties property = new Properties("111 Cedar St", 275000, 90, "Charming bungalow");
        property.setDescription("Updated charming bungalow");
        assertEquals("Updated charming bungalow", property.getDescription());
    }


    @Test
    void propertyIdIsNullInitially() {
        // Prueba para verificar que el ID de una propiedad es nulo inicialmente
        Properties property = new Properties("222 Spruce St", 120000, 70, "Lovely studio");
        assertNull(property.getId());
    }


    @Test
    void propertySetIdTest() {
        // Prueba para establecer y verificar el ID de una propiedad
        Properties property = new Properties("333 Fir St", 250000, 110, "Quaint apartment");
        property.setId(3L);
        assertEquals(3L, property.getId());
    }
}
