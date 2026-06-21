package programadopsihewan;

public class Burung extends Hewan {

    public Burung(String nama, int umur, double beratBadan, boolean sudahDiadopsi, String kemampuanBicara) {
        super(nama, umur, beratBadan, sudahDiadopsi, kemampuanBicara);
    }

    public String getKemampuanBicara() {
        return atributKhusus;
    }

    @Override
    public String getJenis() {
        return "Burung";
    }

    @Override
    public String getLabelAtributKhusus() {
        return "Kemampuan Bicara";
    }

    @Override
    public double hitungBiayaAdopsi() {
        double biaya = 150000;
        if ("Bisa Bicara".equalsIgnoreCase(atributKhusus)) {
            biaya += 200000; 
        }
        return biaya;
    }

    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | Jenis: Burung | " + getLabelAtributKhusus() + ": " + atributKhusus;
    }
}
