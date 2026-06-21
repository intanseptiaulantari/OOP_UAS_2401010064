package programadopsihewan;

import java.sql.Date;

public class Pengadopsi {

    private int id;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private Date tanggalAdopsi;
    private int hewanId;

    public Pengadopsi(String nama, String alamat, String noTelp, String email, Date tanggalAdopsi, int hewanId) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.tanggalAdopsi = tanggalAdopsi;
        this.hewanId = hewanId;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getNoTelp() { return noTelp; }
    public String getEmail() { return email; }
    public Date getTanggalAdopsi() { return tanggalAdopsi; }
    public int getHewanId() { return hewanId; }
}
