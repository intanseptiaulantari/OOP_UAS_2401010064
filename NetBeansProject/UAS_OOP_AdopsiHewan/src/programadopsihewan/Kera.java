package programadopsihewan;

public class Kera extends Hewan {

    public Kera(String nama, int umur, double beratBadan, boolean sudahDiadopsi, String tingkatJinak) {
        super(nama, umur, beratBadan, sudahDiadopsi, tingkatJinak);
    }

    public String getTingkatJinak() {
        return atributKhusus;
    }

    @Override
    public String getJenis() {
        return "Kera";
    }

    @Override
    public String getLabelAtributKhusus() {
        return "Tingkat Kejinakan";
    }

    @Override
    public double hitungBiayaAdopsi() {
        double biaya = 300000;
        if ("Sangat Jinak".equalsIgnoreCase(atributKhusus)) {
            biaya += 100000;
        }
        return biaya;
    }

    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | Jenis: Kera | " + getLabelAtributKhusus() + ": " + atributKhusus;
    }
}
