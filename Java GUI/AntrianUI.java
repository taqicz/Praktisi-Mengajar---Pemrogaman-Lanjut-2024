import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.time.LocalDate;


public class AntrianUI extends JFrame {
    private Queue<String> antrian;
    private int nomorAntrian;
    private JTextArea antrianTextArea;

    public AntrianUI() {
        antrian = new ArrayDeque<>(10);
        nomorAntrian = 1;

        setTitle("Antrian Rumah Sakit XYZ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton tambahButton = new JButton("Masukkan pasien ke antrian");
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaPasien = JOptionPane.showInputDialog("Masukkan nama pasien:");
                if (namaPasien != null && !namaPasien.isEmpty()) {
                    antrian.offer(namaPasien);
                    simpanDataAntrian(namaPasien, nomorAntrian);
                    nomorAntrian++;
                    updateAntrianTextArea();
                    JOptionPane.showMessageDialog(null, "Pasien berhasil ditambahkan ke antrian.");
                }
            }
        });
        buttonPanel.add(tambahButton);

        JButton panggilButton = new JButton("Panggil pasien berikutnya");
        panggilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!antrian.isEmpty()) {
                    String pasienBerikutnya = antrian.poll();
                    updateAntrianTextArea();
                    JOptionPane.showMessageDialog(null, "Pasien berikutnya: " + pasienBerikutnya);
                } else {
                    JOptionPane.showMessageDialog(null, "Antrian kosong.");
                }
            }
        });
        buttonPanel.add(panggilButton);

        JButton resetButton = new JButton("Reset Antrian");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                antrian.clear();
                nomorAntrian = 1;
                updateAntrianTextArea();
                JOptionPane.showMessageDialog(null, "Antrian berhasil direset.");
            }
        });
        buttonPanel.add(resetButton);

        antrianTextArea = new JTextArea();
        antrianTextArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(antrianTextArea);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void updateAntrianTextArea() {
        StringBuilder sb = new StringBuilder();
        for (String pasien : antrian) {
            sb.append(pasien).append("\n");
        }
        antrianTextArea.setText(sb.toString());
    }

    private void simpanDataAntrian(String namaPasien, int nomorAntrian) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data_antrian1.txt", true));
            bw.write("Nomor Antrian: " + nomorAntrian + "\n");
            bw.write("Nama Pasien: " + namaPasien + "\n");
            bw.write("Tanggal: " + LocalDate.now() + "\n");
            bw.write("--------------------\n");
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data antrian: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AntrianUI();
            }
        });
    }
}



