-- HANYA jalankan ini kalau kamu SUDAH pernah membuat tabel 'hewan'
-- dengan skema lama (kolom jenis_bulu & jenis_ras terpisah).
-- Kalau database masih baru/kosong, pakai schema.sql saja, abaikan file ini.

USE db_adopsi_hewan;

ALTER TABLE hewan ADD COLUMN atribut_khusus VARCHAR(50) NULL AFTER sudah_diadopsi;

UPDATE hewan SET atribut_khusus = jenis_bulu WHERE jenis = 'Kucing';
UPDATE hewan SET atribut_khusus = jenis_ras  WHERE jenis = 'Anjing';

ALTER TABLE hewan DROP COLUMN jenis_bulu;
ALTER TABLE hewan DROP COLUMN jenis_ras;
