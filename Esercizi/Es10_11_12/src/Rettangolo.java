public class Rettangolo {
    private double base;
    private double altezza;

    public Rettangolo(){
        base = 1;
        altezza = 1;
    }

    public Rettangolo(double base , double altezza){
        if(base > 0) {
            this.base = base;
        }
        else {
            this.base = 1;
        }
        if(altezza > 0) {
            this.altezza = altezza;
        }
        else {
            this.altezza = 1;
        }
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getArea(){
        double area;
        area = base * altezza;
        return area;
    }

    public double getPerimetro(){
        double perimetro;
        perimetro = (base * 2) + (altezza * 2);
        return  perimetro;
    }

    public String rett(){
        if(base == altezza)
            return "E' un quadrato";
        else
            return "E' un rettangolo";
    }

    @Override
    public String toString() {
        return "Rettangolo" +
                "base=" + base +
                ", altezza=" + altezza;

    }
}
