package programadopsihewan;

public class Kucing extends Hewan {

    public Kucing(String nama, int umur, double beratBadan, boolean sudahDiadopsi, String jenisBulu) {
        super(nama, umur, beratBadan, sudahDiadopsi, jenisBulu);
    }

    public String getJenisBulu() {
        return atributKhusus; 
    }

    @Override
    public String getJenis() {
        return "Kucing";
    }

    @Override
    public String getLabelAtributKhusus() { 
        return "Jenis Bulu";
    }

    @Override
    public double hitungBiayaAdopsi() {
        double biaya = 200000;
        if ("Panjang".equalsIgnoreCase(atributKhusus) || "Anggora".equalsIgnoreCase(atributKhusus)) {
            biaya += 100000; 
        }
        return biaya;
    }


    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | Jenis: Kucing | Bulu: " + atributKhusus;
    }
}
