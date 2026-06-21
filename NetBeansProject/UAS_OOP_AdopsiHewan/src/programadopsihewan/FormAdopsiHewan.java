package programadopsihewan;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 * Window utama. Hanya berperan sebagai wadah JTabbedPane yang menampung
 * dua JPanel Form: PanelDataHewan dan PanelProsesAdopsi. Desain visual
 * kedua panel itu sekarang bisa dibuka & diedit lewat NetBeans GUI Builder
 * (klik kanan PanelDataHewan.java / PanelProsesAdopsi.java -> Open, lalu
 * pilih tab "Design").
 */
public class FormAdopsiHewan extends JFrame {

    private final PanelDataHewan panelDataHewan;
    private final PanelProsesAdopsi panelProsesAdopsi;

    public FormAdopsiHewan() {
        setTitle("Program Adopsi Hewan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 650);
        setLocationRelativeTo(null);

        panelDataHewan = new PanelDataHewan();
        panelProsesAdopsi = new PanelProsesAdopsi();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Data Hewan", panelDataHewan);
        tabbedPane.addTab("Proses Adopsi", panelProsesAdopsi);

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 0) {
                panelDataHewan.refreshData();
            } else {
                panelProsesAdopsi.refreshData();
            }
        });

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormAdopsiHewan().setVisible(true));
    }
}
