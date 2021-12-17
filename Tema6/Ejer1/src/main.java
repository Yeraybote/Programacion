import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.currentTimeMillis;
import static javax.swing.JOptionPane.*;
public class main {
    static String personamayor;
    static ArrayList <Alumnos> listaalumnos = new ArrayList<>();
    static ArrayList <Persona> listapersonas = new ArrayList<>();

    public static void main(String[] args) {
        /* Parte 1
        double radio = Double.parseDouble(javax.swing.JOptionPane.showInputDialog(null,"Radio: "));
        Circunferencia circulo = new Circunferencia(radio);
        circulo.setRadio(radio);
        circulo.longitud();
        circulo.area();
        circulo.volumen();
        */
        /* Parte 2
        String seguir;
        do {
            String cod = showInputDialog(null,"Código del alumno");
            String nombre = showInputDialog(null,"Nombre del alumno");
            String domicilio = showInputDialog(null,"Domicilio: ");
            String telefono = showInputDialog(null,"Teléfono");;
            Alumnos id = new Alumnos(cod,nombre,domicilio,telefono);
            listaalumnos.add(id);
            seguir = showInputDialog(null, "Desea continuar? s/n");
        } while (!seguir.equals("n"));

        String codigo = showInputDialog(null, "Código del alumno: ");
        int x;
        for(x = 0; x < listaalumnos.size() && !listaalumnos.get(x).getCodigo().equals(codigo); x++){}
        if( x != listaalumnos.size()) JOptionPane.showMessageDialog(null,listaalumnos.get(x).toString());
        else JOptionPane.showMessageDialog(null,"Alumno no encontrado"); */
        /* Parte 3 */
        String seguir;
        do {
            String nombre = showInputDialog(null,"Nombre: ");
            String dNacimiento = showInputDialog(null,"Día de nacimiento: ");
            String mNacimiento = showInputDialog(null,"Mes de nacimiento: ");
            String aNacimiento = showInputDialog(null,"Año de nacimiento: ");
            String direccion = showInputDialog(null,"Dirección: ");
            String cpostal = showInputDialog(null,"Código postal: ");
            String ciudad = showInputDialog(null,"Ciudad: ");
            Persona a = new Persona(nombre,dNacimiento,mNacimiento,aNacimiento,direccion,cpostal,ciudad);
            listapersonas.add(a);
            seguir = showInputDialog(null, "Desea continuar? s/n");
        } while (!seguir.equals("n"));
        do {
            seguir = showInputDialog(null,"Selecciona una opción: \n1. Nombre de la persona de mayor edad \n2. Nombre de las personas que viven en Elche \n3. Número de personas mayores de edad \n0. Finalizar programa");
            switch (seguir) {
                case "1":
                    funcionMayor();
                    break;
                case "2":
                    funcionElche();
                    break;
                case "3":
                    funcionMayoresEdad();
                    break;
                case "0":
                    break;
            }
        } while (!seguir.equals("0"));
    }

    public static void funcionMayor () {
        try {
            long comparar = 999999999999999999L;
            for (int x = 0; x < listapersonas.size(); x++) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaUno = formatter.parse(listapersonas.get(x).dNacimiento+"/"+listapersonas.get(x).mNacimiento+"/" + listapersonas.get(x).aNacimiento);
                long mfecha1 = fechaUno.getTime();
                    if (mfecha1 < comparar) {
                        comparar = mfecha1;
                        personamayor = listapersonas.get(x).getNombre();
                    }
            }
            showMessageDialog(null,"La persona mas mayor es: " + personamayor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void funcionElche () {
        int contador = 0;
        for (int x = 0; x < listapersonas.size(); x++) {
            if (listapersonas.get(x).getCiudad().equals("Elche")) contador++;
        }
        showMessageDialog(null,"Viven " + contador + " persona(s) en Elche");
    }

    public static void funcionMayoresEdad () {
        try {
            long comparar = 999999999999999999L;
            for (int x = 0; x < listapersonas.size(); x++) {

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaUno = formatter.parse(listapersonas.get(x).dNacimiento+"/"+listapersonas.get(x).mNacimiento+"/" + listapersonas.get(x).aNacimiento);
                long mfecha1 = fechaUno.getTime();

                Calendar hoy = Calendar.getInstance();
                fechaUno.setTime(formatter.parse(listapersonas.get(x).dNacimiento+"/"+listapersonas.get(x).mNacimiento+"/" + listapersonas.get(x).aNacimiento));
                int dias = funcionDias(fechaUno, hoy);
                int años = dias /364;
                if (mfecha1 < comparar) {
                    comparar = mfecha1;
                    personamayor = listapersonas.get(x).getNombre();
                }
            }
            showMessageDialog(null,"La persona mas mayor es: " + personamayor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static int funcionDias(Calendar date1, Calendar date2) {
        long fecha1 = date1.getTimeInMillis();
        long fecha2 = date2.getTimeInMillis();
        return (int)Math.abs((fecha1 - fecha2) / (8640 * 10000));
    }
}
