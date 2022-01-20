package Modelo;

import java.time.LocalDate;

public class Gato extends Mascota
{
    public Gato(String raza, String nombre, LocalDate fechaNacimiento, float peso, String sexo, float longitud, String color) {
        super(raza, nombre, fechaNacimiento, peso, sexo, longitud, color);
    }
}
