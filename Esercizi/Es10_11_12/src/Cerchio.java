public class Cerchio {
    private double raggio;
    private static final double pigreco = 3.14;

    public Cerchio(){
        raggio = 0;
    }

    public Cerchio(double raggio){
        if(raggio > 0)
            this.raggio = raggio;
        else
            this.raggio = 0;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public double getArea(){
        double area;
        area = (raggio * raggio) * pigreco;
        return area;
    }

    public double getCirconferenza(){
        double circonferenza;
        circonferenza = 2 * (pigreco * raggio);
        return circonferenza;
    }

    @Override
    public String toString() {
        return "Cerchio : " +
                "raggio=" + raggio;
    }
}
