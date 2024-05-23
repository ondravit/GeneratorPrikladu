package org.generator.prikladu;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainFrame extends JFrame {

    private final JTextField pocetPrikladu = new JTextField(10);
    private final JTextField maxHodnota = new JTextField(10);
    JTextArea txt = new JTextArea();
    Priklady priklady = new Priklady();

    public MainFrame() {
        setTitle("Generátor příkladů");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel lbPocetPrikladu = new JLabel("Počet příkladů");
        lbPocetPrikladu.setLabelFor(pocetPrikladu);
        panel.add(lbPocetPrikladu);
        panel.add(pocetPrikladu);

        JLabel lbMaxHodnota = new JLabel("Max číslo");
        lbMaxHodnota.setLabelFor(maxHodnota);
        panel.add(lbMaxHodnota);
        panel.add(maxHodnota);

        JButton generate = new JButton("Vygenerovat příklady");
        generate.addActionListener((e -> generovat(Integer.parseInt(pocetPrikladu.getText()), Integer.parseInt(maxHodnota.getText()))));
        panel.add(generate);

        JButton exportJSON = new JButton("Export JSON");
        exportJSON.addActionListener((e -> JsonCode.saveJSON(priklady.getPriklady())));
        panel.add(exportJSON);


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(txt);

        getRootPane().setDefaultButton(generate);
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void generovat(int pocetPrikladu, int maxHodnota) {
        Random random = new Random();
        for (int i = 0; i < pocetPrikladu; i++) {
            int a = random.nextInt(maxHodnota)+1;
            int b = random.nextInt(maxHodnota)+1;
            Priklad priklad = new Priklad(a, "+", b);
            priklady.pridatPriklad(priklad);
        }
        vypsatPriklady();

    }

    private void vypsatPriklady() {
        for (Priklad x: priklady.getPriklady()) {
            txt.append(String.format("%d %s %d\n", x.getA(), x.getOper(), x.getB()));
        }
    }
}
