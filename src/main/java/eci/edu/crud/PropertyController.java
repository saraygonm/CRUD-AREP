package eci.edu.crud;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/properties") //EndPoint
public class PropertyController {
    @Autowired
    private PropertyInterface interfaces; //inyección de dependencias
    @GetMapping
    public List<Properties> getAllProperties() {
        return interfaces.findAll(); //lista de las TODAS las propiedades
    }

    //solicitudes GET para obtener una propiedad por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Properties> getPropertyById(@PathVariable Long id) {
        return interfaces.findById(id).map(properties -> ResponseEntity.ok().body(properties)) // Si se encuentra, devuelve una respuesta 200 OK
                .orElse(ResponseEntity.notFound().build()); // Si no se encuentra, devuelve 404 Not Found
    }

    //Solicitudes POST para crear una propiedad
    @PostMapping
    public Properties creaProperties(@RequestBody Properties properties){
        //metodo que guarda y devuelve la nueva propiedad
        return interfaces.save(properties);
    }
    //solicitudes PUT para actualizar una propiedad
    @PutMapping("/{id}")
    public ResponseEntity<Properties> updateProperty(@PathVariable Long id, @RequestBody Properties properties) {
        if (!interfaces.existsById(id)) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no existe
        }
        properties.setId(id);
        return ResponseEntity.ok(interfaces.save(properties));
    }

    // Solicitudes DELETE para eliminar una propiedad por  ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        if (!interfaces.existsById(id)) {
            return ResponseEntity.notFound().build(); //  404 si no existe
        }
        interfaces.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content despues de eliminar
    }
}
