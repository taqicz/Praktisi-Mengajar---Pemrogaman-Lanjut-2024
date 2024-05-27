import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;




public class FinalProjectKH extends JFrame {
    private Queue<String> antrian;
    private int nomorAntrian;
    private JTextArea antrianTextArea;

    public FinalProjectKH() {
        antrian = new ArrayDeque<>(10);
        nomorAntrian = 1;

        setTitle("Antrian Rumah Sakit Karsa Husada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for buttons
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

        // Button to call next patient
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

        // Button to reset the queue
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

        // Text area to display the queue
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
                new FinalProjectKH();
            }
        });
    }
}



// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.util.*;
// import javax.swing.*;
