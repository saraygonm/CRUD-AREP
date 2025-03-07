package eci.edu.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "properties") // Asegúrate de que el nombre coincide con la tabla en la BD
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment en MySQL
    private Long id;

    private String address;
    private double price;
    private int size;
    private String description;

    // Constructor vacío requerido por JPA
    public Properties() {}

    // Constructor con todos los parámetros
    public Properties(Long id, String address, double price, int size, String description) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    // Constructor sin ID (para creación de nuevas entidades)
    public Properties(String address, double price, int size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Properties{id=" + id + ", address='" + address + "', price=" + price +
                ", size=" + size + ", description='" + description + "'}";
    }
}
