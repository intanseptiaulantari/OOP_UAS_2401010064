package programadopsihewan;

public class Anjing extends Hewan {

    public Anjing(String nama, int umur, double beratBadan, boolean sudahDiadopsi, String jenisRas) {
        super(nama, umur, beratBadan, sudahDiadopsi, jenisRas);
    }

    public String getJenisRas() {
        return atributKhusus; 
    }

    @Override
    public String getJenis() {
        return "Anjing";
    }

    @Override
    public String getLabelAtributKhusus() { 
        return "Jenis Ras";
    }

    @Override
    public double hitungBiayaAdopsi() {
        double biaya = 250000;
        if ("Ras Besar".equalsIgnoreCase(atributKhusus)) {
            biaya += 150000; 
        }
        return biaya;
    }


    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | Jenis: Anjing | Ras: " + atributKhusus;
    }
}
