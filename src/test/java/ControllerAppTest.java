package eci.edu.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.CommandLineRunner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerAppTest {

    @Mock
    private PropertyInterface propertyRepository; // Simula PropertyInterface

    @InjectMocks
    private ControllerApp controllerApp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void contextLoads() {
        // Verifica que el contexto se carga correctamente
        assertNotNull(controllerApp);
    }


    @Test
    void demoWithPropertiesTest() throws Exception {
        // Prueba para verificar el comportamiento de demo() cuando hay propiedades
        Properties property = new Properties(1L, "123 Main St", 250000, 100, "Beautiful house");
        when(propertyRepository.findAll()).thenReturn(Arrays.asList(property));

        CommandLineRunner runner = controllerApp.demo(propertyRepository);
        // Captura la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        runner.run();
        // Verifica que la salida contiene el mensaje esperado
        assertTrue(outContent.toString().contains("Properties found with findAll():"));
        assertTrue(outContent.toString().contains(property.toString()));
    }


    @Test
    void demoWithEmptyListTest() throws Exception {
        // Prueba para verificar el comportamiento de demo() cuando no hay propiedades
        when(propertyRepository.findAll()).thenReturn(Collections.emptyList());

        CommandLineRunner runner = controllerApp.demo(propertyRepository);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        runner.run();

        // Verifica que se imprime solo el encabezado
        assertTrue(outContent.toString().contains("Properties found with findAll():"));
    }


    @Test
    void demoCallsFindAllOnce() throws Exception {
        // Prueba para verificar que findAll() se llama exactamente una vez
        CommandLineRunner runner = controllerApp.demo(propertyRepository);
        runner.run();

        verify(propertyRepository, times(1)).findAll();
    }


    @Test
    void demoHandlesException() {
        // Prueba para manejar excepciones en el metodo demo()
        when(propertyRepository.findAll()).thenThrow(new RuntimeException("Error inesperado"));

        CommandLineRunner runner = controllerApp.demo(propertyRepository);

        // Verifica que la excepción se lanza correctamente
        assertThrows(RuntimeException.class, runner::run);
    }


    @Test
    void demoWithMultiplePropertiesTest() throws Exception {
        // Prueba para verificar el comportamiento de demo() con múltiples propiedades
        Properties property1 = new Properties(1L, "123 Main St", 250000, 100, "Beautiful house");
        Properties property2 = new Properties(2L, "456 Elm St", 300000, 150, "Spacious apartment");

        when(propertyRepository.findAll()).thenReturn(Arrays.asList(property1, property2));
        CommandLineRunner runner = controllerApp.demo(propertyRepository);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        runner.run();

        // Verifica que ambas propiedades aparecen en la salida
        assertTrue(outContent.toString().contains(property1.toString()));
        assertTrue(outContent.toString().contains(property2.toString()));
    }


    @Test
    void loggerNotNull() throws NoSuchFieldException {
        // Prueba para verificar que el logger no es nulo
        assertNotNull(ControllerApp.class.getDeclaredField("log"));
    }

}
