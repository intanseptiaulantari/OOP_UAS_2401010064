package programadopsihewan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PengadopsiDAO {

    private final HewanDAO hewanDAO = new HewanDAO();

    public boolean simpanAdopsi(Pengadopsi p) {
        String sql = "INSERT INTO pengadopsi (nama, alamat, no_telp, email, tanggal_adopsi, hewan_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNama());
            ps.setString(2, p.getAlamat());
            ps.setString(3, p.getNoTelp());
            ps.setString(4, p.getEmail());
            ps.setDate(5, p.getTanggalAdopsi());
            ps.setInt(6, p.getHewanId());

            ps.executeUpdate();

            hewanDAO.tandaiSudahDiadopsi(p.getHewanId());

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String[]> tampilkanSemua() {
        List<String[]> daftar = new ArrayList<>();
        String sql = "SELECT p.id, p.nama, p.alamat, p.no_telp, p.tanggal_adopsi, h.nama AS nama_hewan, h.jenis "
                + "FROM pengadopsi p JOIN hewan h ON p.hewan_id = h.id ORDER BY p.id DESC";

        try (Connection conn = KoneksiDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                daftar.add(new String[]{
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("no_telp"),
                    rs.getString("tanggal_adopsi"),
                    rs.getString("nama_hewan") + " (" + rs.getString("jenis") + ")"
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftar;
    }
}
