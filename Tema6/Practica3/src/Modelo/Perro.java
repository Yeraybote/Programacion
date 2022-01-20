package Modelo;

import java.time.LocalDate;

public class Perro extends Mascota
{
    public Perro(String raza, String nombre, LocalDate fechaNacimiento, float peso, String sexo, float longitud, String color) {
        super(raza, nombre, fechaNacimiento, peso, sexo, longitud, color);
    }
}
