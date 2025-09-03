package org.example.tregeniaweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "suscripciones")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 255, message = "El nombre no debe superar los 255 caracteres")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debes ingresar un correo válido")
    @Size(max = 255, message = "El correo no debe superar los 255 caracteres")
    private String correo;

    @Column(name = "fecha_suscripcion")
    private LocalDateTime fechaSuscripcion;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public LocalDateTime getFechaSuscripcion() { return fechaSuscripcion; }
    public void setFechaSuscripcion(LocalDateTime fechaSuscripcion) { this.fechaSuscripcion = fechaSuscripcion; }
}
