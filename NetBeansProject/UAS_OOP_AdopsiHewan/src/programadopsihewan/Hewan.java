package programadopsihewan;

/**
 * Parent class (abstract) -> dasar INHERITANCE
 *
 * atributKhusus = satu kolom generik yang maknanya beda-beda tergantung
 * jenis hewannya (jenis bulu utk Kucing, jenis ras utk Anjing, dst).
 * Tujuannya: kalau mau nambah jenis hewan baru, TIDAK perlu nambah
 * kolom baru lagi di database -> cukup bikin class child baru.
 */
public abstract class Hewan {

    protected int id; 
    private String nama;
    protected int umur;            
    protected double beratBadan;   
    protected boolean sudahDiadopsi;
    protected String atributKhusus;

    public Hewan(String nama, int umur, double beratBadan, boolean sudahDiadopsi, String atributKhusus) {
        this.nama = nama;
        this.umur = umur;
        this.beratBadan = beratBadan;
        this.sudahDiadopsi = sudahDiadopsi;
        this.atributKhusus = atributKhusus;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    public String getNama() { return nama; }
    public int getUmur() { return umur; }
    public double getBeratBadan() { return beratBadan; }
    public boolean isSudahDiadopsi() { return sudahDiadopsi; }
    public void setSudahDiadopsi(boolean sudahDiadopsi) { this.sudahDiadopsi = sudahDiadopsi; }
    public String getAtributKhusus() { return atributKhusus; }

    public abstract String getJenis();                
    public abstract String getLabelAtributKhusus();    
    public abstract double hitungBiayaAdopsi();
    
    public String tampilkanInfo() {
        return "Nama: " + nama
                + " | Umur: " + umur + " bulan"
                + " | Berat: " + beratBadan + " kg"
                + " | Status: " + (sudahDiadopsi ? "Sudah Diadopsi" : "Tersedia");
    }
}
