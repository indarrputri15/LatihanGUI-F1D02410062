import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMahasiswa extends JFrame implements ActionListener {

    // Atomic komponen
    private JLabel lblNim;
    private JLabel lblNama;
    private JLabel lblProdi;
    private JLabel lblStatus;
    private JTextField txtNim;
    private JTextField txtNama;
    private JComboBox<String> cmbProdi;
    private JButton btnSimpan;
    private JButton btnReset;

    public FormMahasiswa() {
        // top level container
        setTitle("Form Data Mahasiswa");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // intermediate container class
        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

       // judul
        JLabel lblJudul = new JLabel("FORM DATA MAHASISWA TEKNIK", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Arial", Font.BOLD, 20));
        panelUtama.add(lblJudul, BorderLayout.NORTH);

        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        lblNim = new JLabel("NIM");
        txtNim = new JTextField();
        lblNama = new JLabel("Nama");
        txtNama = new JTextField();
        lblProdi = new JLabel("Program Studi");

        String[] daftarProdi = {"Teknik Informatika", "Teknik Elektro", "Teknik Sipil", "Teknik Mesin"};
        cmbProdi = new JComboBox<>(daftarProdi);
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblProdi);
        panelForm.add(cmbProdi);
        panelUtama.add(panelForm, BorderLayout.CENTER);

        
        btnSimpan = new JButton("Simpan");
        btnReset = new JButton("Reset");
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panelTombol.add(btnSimpan);
        panelTombol.add(btnReset);

        btnSimpan.addActionListener(this);
        btnReset.addActionListener(this);
        lblStatus = new JLabel("Silakan masukkan data mahasiswa.", SwingConstants.CENTER);
        JPanel panelBawah = new JPanel(new BorderLayout());

        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(lblStatus, BorderLayout.SOUTH);
        panelUtama.add(panelBawah, BorderLayout.SOUTH);
        add(panelUtama);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSimpan) {
            String nim = txtNim.getText();
            String nama = txtNama.getText();
            String prodi = cmbProdi.getSelectedItem().toString();

            if (nim.isEmpty() || nama.isEmpty()) {
                lblStatus.setText("NIM dan Nama harus diisi.");

            } else {

                lblStatus.setText("Data berhasil disimpan.");

                JOptionPane.showMessageDialog(this, "NIM    : " + nim +  "\nNama   : " + nama + "\nProdi  : " + prodi, "Data Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == btnReset) {
            txtNim.setText("");
            txtNama.setText("");
            cmbProdi.setSelectedIndex(0);
            lblStatus.setText("Form berhasil di-reset.");
        }
    }

    public static void main(String[] args) {
        new FormMahasiswa();
    }
}