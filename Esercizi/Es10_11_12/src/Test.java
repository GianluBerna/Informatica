import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        double raggio = 0;
        double base = 0 ;
        double altezza = 0;

        System.out.println("Inserire Raggio : ");

        try {
            raggio = Double.parseDouble(tastiera.readLine());
        } catch (IOException e) {
            System.out.println("Il numero inserito non e' corretto");
        }

        System.out.println("Inserire Base : ");

        try {
            base = Double.parseDouble(tastiera.readLine());
        } catch (IOException e) {
            System.out.println("Il numero inserito non e' corretto");
        }

        System.out.println("Inserire Altezza : ");

        try {
            altezza = Double.parseDouble(tastiera.readLine());
        } catch (IOException e) {
            System.out.println("Il numero inserito non e' corretto");
        }

        Cerchio c = new Cerchio(raggio);
        Rettangolo r = new Rettangolo(base , altezza);
        if(c.getArea() == r.getArea()) {
            System.out.println("L'area e' uguale" + "\n" + "Cerchio : " + c.getArea() + "\n" + "Rettangolo : " + r.getArea());
        }
        else {
            System.out.println("L'area non e' uguale" + "\n" + "Cerchio : " + c.getArea() + "\n" + "Rettangolo : " + r.getArea());
        }
    }
}
