public class Circunferencia {
    double radio;

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void longitud () {
        double longi = 2 * 3.14 * radio;
        longi = Math.round(longi*100.0)/100.0;
        System.out.println("La longitud es " + longi);
    }

    public void area () {
        double area = 3.14 * radio * radio;
        area = Math.round(area*100.0)/100.0;
        System.out.println("El area es " + area);
    }

    public void volumen () {
        double vol = 4 * 3.14 * radio * radio * radio/3;
        vol = Math.round(vol*100.0)/100.0;
        System.out.println("El volumen es " + vol);
    }
}
