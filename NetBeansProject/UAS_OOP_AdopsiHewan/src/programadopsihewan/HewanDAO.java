package programadopsihewan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HewanDAO {

    public boolean simpan(Hewan h) {
        String sql = "INSERT INTO hewan (jenis, nama, umur, berat_badan, sudah_diadopsi, atribut_khusus) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, h.getJenis());
            ps.setString(2, h.getNama());
            ps.setInt(3, h.getUmur());
            ps.setDouble(4, h.getBeratBadan());
            ps.setBoolean(5, h.isSudahDiadopsi());
            ps.setString(6, h.getAtributKhusus());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Hewan h) {
        String sql = "UPDATE hewan SET nama=?, umur=?, berat_badan=?, atribut_khusus=? WHERE id=?";
        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, h.getNama());
            ps.setInt(2, h.getUmur());
            ps.setDouble(3, h.getBeratBadan());
            ps.setString(4, h.getAtributKhusus());
            ps.setInt(5, h.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hapus(int id) {
        String sql = "DELETE FROM hewan WHERE id=?";
        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean tandaiSudahDiadopsi(int hewanId) {
        String sql = "UPDATE hewan SET sudah_diadopsi = TRUE WHERE id=?";
        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, hewanId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Hewan> tampilkanSemua() {
        return ambilData("SELECT * FROM hewan ORDER BY id DESC");
    }

    public List<Hewan> tampilkanTersedia() {
        return ambilData("SELECT * FROM hewan WHERE sudah_diadopsi = FALSE ORDER BY id DESC");
    }

    private Hewan buatObjekHewan(String jenis, String nama, int umur, double berat,
                                  boolean sudahDiadopsi, String atributKhusus) {
        switch (jenis) {
            case "Kucing": return new Kucing(nama, umur, berat, sudahDiadopsi, atributKhusus);
            case "Anjing": return new Anjing(nama, umur, berat, sudahDiadopsi, atributKhusus);
            case "Burung": return new Burung(nama, umur, berat, sudahDiadopsi, atributKhusus);
            case "Kera":   return new Kera(nama, umur, berat, sudahDiadopsi, atributKhusus);
            default: throw new IllegalArgumentException("Jenis hewan tidak dikenali: " + jenis);
        }
    }

    private List<Hewan> ambilData(String sql) {
        List<Hewan> daftar = new ArrayList<>();
        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Hewan h = buatObjekHewan(
                        rs.getString("jenis"),
                        rs.getString("nama"),
                        rs.getInt("umur"),
                        rs.getDouble("berat_badan"),
                        rs.getBoolean("sudah_diadopsi"),
                        rs.getString("atribut_khusus")
                );
                h.setId(rs.getInt("id"));
                daftar.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftar;
    }
}
