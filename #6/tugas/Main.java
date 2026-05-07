import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Laptop myLaptop = new Toshiba(); 

        try (Scanner input = new Scanner(System.in)) {
            String action;

            while (true) {
                System.out.println("\n--- MENU LAPTOP ---");
                System.out.println("[ON] Nyalakan | [OFF] Matikan | [UP] Vol Up | [DOWN] Vol Down | [EXIT] Keluar");
                System.out.print("Pilih aksi: ");
                
                action = input.nextLine().toUpperCase();

                if (action.equals("ON")) {
                    myLaptop.powerOn();
                } else if (action.equals("OFF")) {
                    myLaptop.powerOff();
                } else if (action.equals("UP")) {
                    myLaptop.volumeUp();
                } else if (action.equals("DOWN")) {
                    myLaptop.volumeDown();
                } else if (action.equals("EXIT")) {
                    System.out.println("Keluar dari program...");
                    break;
                } else {
                    System.out.println("Aksi tidak dikenal! Gunakan ON, OFF, UP, atau DOWN.");
                }
            }
        }
    }
}