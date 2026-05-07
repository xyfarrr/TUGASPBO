import java.util.ArrayList;
import java.util.ArrayDeque;

public class ContohCollection {
    public static void main(String[] args) {

        ArrayList<String> listMahasiswa = new ArrayList<>();
        listMahasiswa.add("Ferdi");

        ArrayDeque<String> antrian = new ArrayDeque<>();
        antrian.addLast("Antrian 1");

        System.out.println("Daftar: " + listMahasiswa);
        System.out.println("Antrian: " + antrian);
    }
}