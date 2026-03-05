import javax.swing.JOptionPane;

public class Latihan2 {
    public static void main(String[] args) {
        String pelajaran = JOptionPane.showInputDialog("Anda sedang belajar apa?");
        if (pelajaran != null) {
            JOptionPane.showMessageDialog(null, "Belajar " + pelajaran + " sangat mudah");
        }
    }
}