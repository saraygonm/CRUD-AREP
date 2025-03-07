import eci.edu.crud.Properties;
import eci.edu.crud.PropertyController;
import eci.edu.crud.PropertyInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class PropertyControllerTests {

    @Mock
    private PropertyInterface propertyRepository;

    @InjectMocks
    private PropertyController propertyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPropertiesTest() {
        Properties property1 = new Properties(1L, "123 Main St", 250000, 100, "Beautiful house");
        Properties property2 = new Properties(2L, "456 Elm St", 300000, 150, "Spacious apartment");
        when(propertyRepository.findAll()).thenReturn(Arrays.asList(property1, property2));

        List<Properties> properties = propertyController.getAllProperties();
        assertEquals(2, properties.size());
    }

    @Test
    void getPropertyByIdTest() {
        Properties property = new Properties(1L, "789 Pine St", 450000, 200, "Luxury villa");
        when(propertyRepository.findById(anyLong())).thenReturn(Optional.of(property));

        ResponseEntity<Properties> response = propertyController.getPropertyById(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(property, response.getBody());
    }

    @Test
    void getPropertyByIdNotFoundTest() {
        when(propertyRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Properties> response = propertyController.getPropertyById(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void createPropertyTest() {
        Properties property = new Properties(3L, "999 Oak St", 350000, 120, "Modern home");
        when(propertyRepository.save(any(Properties.class))).thenReturn(property);

        Properties createdProperty = propertyController.creaProperties(property);
        assertNotNull(createdProperty);
        assertEquals("999 Oak St", createdProperty.getAddress());
    }

    @Test
    void updatePropertyTest() {
        Properties existingProperty = new Properties(1L, "123 Main St", 250000, 100, "Beautiful house");
        Properties updatedProperty = new Properties(1L, "Updated Address", 270000, 110, "Updated description");
        when(propertyRepository.existsById(1L)).thenReturn(true);
        when(propertyRepository.save(any(Properties.class))).thenReturn(updatedProperty);

        ResponseEntity<Properties> response = propertyController.updateProperty(1L, updatedProperty);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Updated Address", response.getBody().getAddress());
    }

    @Test
    void updatePropertyNotFoundTest() {
        Properties property = new Properties(1L, "333 Fir St", 250000, 110, "Quaint apartment");
        when(propertyRepository.existsById(anyLong())).thenReturn(false);

        ResponseEntity<Properties> response = propertyController.updateProperty(1L, property);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void deletePropertyTest() {
        when(propertyRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(propertyRepository).deleteById(anyLong());

        ResponseEntity<Void> response = propertyController.deleteProperty(1L);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void deletePropertyNotFoundTest() {
        when(propertyRepository.existsById(anyLong())).thenReturn(false);

        ResponseEntity<Void> response = propertyController.deleteProperty(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void getAllPropertiesReturnsEmptyListTest() {
        when(propertyRepository.findAll()).thenReturn(Collections.emptyList());

        List<Properties> properties = propertyController.getAllProperties();
        assertEquals(0, properties.size());
    }
}