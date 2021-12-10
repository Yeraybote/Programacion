package com.company;
import static javax.swing.JOptionPane.*;
import java.awt.*;
import java.util.ArrayList;
/* PRACTICA 1 - ARRAYLIST - YERAY BOTE */
public class Main {
    static ArrayList <Float> valores = new ArrayList<>();
    public static void main(String[] args) {
        funcionMenu();
    }
    public static void funcionMenu () {
        try {
            int opcion;
            do {
                opcion = Integer.parseInt(showInputDialog(null, "Seleccione una opción: \n0. Rellenar ArrayList \n1. Visualizar el valor máximo y mínimo \n2. Buscar múmero \n3. Eliminar número \n4. Convertirlo en un Array \n5. Mostrar número de elementos \n6. Insertar elemento al final \n7. Insertar elemento en la posición deseada \n8. Borrar elemento de posición concreta \n9. Calcular suma y media \n10. Finalizar"));
                switch (opcion) {
                    case 0:
                        funcionRellenar();
                        break;
                    case 1:
                        funcionMaxMin();
                        break;
                    case 2:
                        funcionEncontrar();
                        break;
                    case 3:
                        funcionBorrar();
                        break;
                    case 4:
                        funcionConvertir();
                        break;
                    case 5:
                        funcionNumElementos();
                        break;
                    case 6:
                        funcionInsertarFinal();
                        break;
                    case 7:
                        funcionInsertarPosicion();
                        break;
                    case 8:
                        funcionBorrarPosicion();
                        break;
                    case 9:
                        funcionSumaMedia();
                        break;
                    case 10:
                        break;
                }
            } while (opcion != 10);
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionRellenar () {
        try {
            String seguir;
            do {
                Float valor = Float.valueOf(showInputDialog(null, "Introduzca un valor"));
                valores.add(valor);
                seguir = showInputDialog(null, "Desea continuar? s/n");
            } while (!seguir.equals("n"));
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionMaxMin () {
            float max = 0;
            float min = 10000;
            if (valores.size() != 0) {
                for (Float valore : valores) {
                    if (valore > max) {
                        max = valore;
                    }
                    if (valore < min) {
                        min = valore;
                    }
                }
                showMessageDialog(null, "Valor máximo: " + max + "\n Valor mínimo: " + min);
            } else {
                showMessageDialog(null, "Está vacío");
            }
    }
    public static void funcionEncontrar () {
        try {
            float num = Float.parseFloat(showInputDialog(null, "Número que desea encontrar: "));
            if (valores.contains(num)) {
                showMessageDialog(null, "Se ha encontrado!");
            } else showMessageDialog(null, "No se ha encontrado...");
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionBorrar () {
        try {
            float num = Float.parseFloat(showInputDialog(null, "Número que desea borrar: "));
            if (valores.contains(num)) {
                showMessageDialog(null, "Eliminado correctamente");
                valores.remove(num);
            } else showMessageDialog(null, "No se ha encontrado...");
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionConvertir () {
        try {
            Float[] arrayvalores = new Float[valores.size()];
            valores.toArray(arrayvalores);
        } catch (Exception e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionNumElementos () {
        if (valores.size() == 0) {
            showMessageDialog(null,"Está vacío");
        } else showMessageDialog(null,"Contiene " + valores.size() + " elementos");
    }
    public static void funcionInsertarFinal () {
        try {
            float num = Float.parseFloat(showInputDialog(null, "Número que desea insertar: "));
            valores.add(valores.size(), num);
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionInsertarPosicion () {
        try {
            float num = Float.parseFloat(showInputDialog(null, "Número que desea insertar: "));
            int posicion = Integer.parseInt(showInputDialog(null, "Posición en la que desea insertarlo: "));
            valores.add(posicion, num);
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionBorrarPosicion () {
        try {
            int posicion = Integer.parseInt(showInputDialog(null, "Posición de la que desea eliminar el elemento: "));
            valores.remove(posicion);
        } catch (NumberFormatException e) {
            showMessageDialog(null,"Error, dato númerico introducido de manera erronea.");
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
    public static void funcionSumaMedia () {
        try {
            float suma = 0;
            for (Float valore : valores) {
                suma += valore;
            }
            showMessageDialog(null, "Suma total: " + suma + "\n Media: " + (suma / valores.size()));
        } catch (HeadlessException e) {
            showMessageDialog(null,"Error, " + e.getClass());
        }
    }
}
