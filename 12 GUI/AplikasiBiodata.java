import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiBiodata extends JFrame {

    private JTextField txtNim, txtNama, txtProdi;
    private JButton btnTampilkan, btnReset;
    private JTextArea txtOutput;

    public AplikasiBiodata() {

        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblInputData = new JLabel("Input Data");
        lblInputData.setFont(new Font("Arial", Font.BOLD, 12));
        lblInputData.setBounds(20, 10, 100, 20);
        add(lblInputData);

        JLabel lblNim = new JLabel("NIM");
        lblNim.setBounds(20, 40, 100, 25);
        add(lblNim);

        txtNim = new JTextField();
        txtNim.setBounds(150, 40, 310, 25);
        add(txtNim);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(20, 75, 100, 25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(150, 75, 310, 25);
        add(txtNama);

        JLabel lblProdi = new JLabel("Program Studi");
        lblProdi.setBounds(20, 110, 100, 25);
        add(lblProdi);

        txtProdi = new JTextField();
        txtProdi.setBounds(150, 110, 310, 25);
        add(txtProdi);

        btnTampilkan = new JButton("Tampilkan");
        btnTampilkan.setBounds(150, 150, 100, 30);
        add(btnTampilkan);

        btnReset = new JButton("Reset");
        btnReset.setBounds(260, 150, 100, 30);
        add(btnReset);

        JLabel lblOutput = new JLabel("Output");
        lblOutput.setFont(new Font("Arial", Font.BOLD, 12));
        lblOutput.setBounds(20, 200, 100, 20);
        add(lblOutput);

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(20, 220, 440, 210);
        add(scrollPane);

        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();

                String hasil = "========== BIODATA MAHASISWA ==========\n\n" +
                               "NIM           : " + nim + "\n" +
                               "Nama          : " + nama + "\n" +
                               "Program Studi : " + prodi;
                
                txtOutput.setText(hasil);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");

                txtOutput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiBiodata().setVisible(true);
            }
        });
    }
}