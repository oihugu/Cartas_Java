import java.util.*;
import java.io.*;



public class App {

    public static Vector<Carta> merge(Vector<Carta> v1, Vector<Carta> v2) {
        Vector<Carta> v3 = new Vector<Carta>();
        v3.addAll(v1);
        v3.addAll(v2);
        return v3;
    }

    public static Vector<Carta> sort(Vector<Carta> original, Vector<Carta> left, Vector<Carta> right){
        Vector<Carta> sorted = new Vector<Carta>();
        
        if (left.size() == 0) {
            sorted.addAll(right);
        } else if (right.size() == 0) {
            sorted.addAll(left);
        } else {
            if (left.get(0).compare(right.get(0)) != 1) {
                sorted.add(left.get(0));
                left.remove(0);
            } else {
                sorted.add(right.get(0));
                right.remove(0);
            }
            sorted.addAll(sort(original, left, right));
        }
        return sorted;
    }

    public static Vector<Carta> mergeSort(Vector<Carta> original) {
        if (original.size() == 1) {
            return original;
        }

        Vector<Carta> left = new Vector<Carta>();
        Vector<Carta> right = new Vector<Carta>();

        for (int i = 0; i < original.size() / 2; i++) {
            left.add(original.get(i));
        }

        for (int i = original.size() / 2; i < original.size(); i++) {
            right.add(original.get(i));
        }
        return sort(original, mergeSort(left), mergeSort(right));
    }

    public static void main(String[] args) throws Exception {
        
        Vector<Carta> cartas = new Vector<Carta>();
        File file = new File("cartas.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].toLowerCase().equals("curinga")){
                Carta carta = new Carta();
                cartas.add(carta);
            }
            else{
                Carta carta = new Carta(parts[0], parts[2]);
                cartas.add(carta);
            }
        }

        sc.close();

        cartas = mergeSort(cartas);
        for (Carta carta : cartas) {
            System.out.println(carta.getCardName());
        }

    }
}
