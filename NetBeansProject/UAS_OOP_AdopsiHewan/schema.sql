-- Jalankan lewat HeidiSQL / phpMyAdmin bawaan Laragon
-- [DIUBAH] kolom jenis_bulu & jenis_ras digabung jadi 1 kolom generik atribut_khusus

CREATE DATABASE IF NOT EXISTS db_adopsi_hewan;
USE db_adopsi_hewan;

CREATE TABLE IF NOT EXISTS hewan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jenis VARCHAR(15) NOT NULL,           -- 'Kucing', 'Anjing', 'Burung', 'Kera'
    nama VARCHAR(50) NOT NULL,
    umur INT NOT NULL,                    -- dalam bulan
    berat_badan DOUBLE NOT NULL,          -- dalam kg
    sudah_diadopsi BOOLEAN DEFAULT FALSE,
    atribut_khusus VARCHAR(50) NULL       -- maknanya beda tergantung 'jenis' (bulu/ras/kemampuan bicara/dst)
);

CREATE TABLE IF NOT EXISTS pengadopsi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(50) NOT NULL,
    alamat VARCHAR(100) NOT NULL,
    no_telp VARCHAR(15) NOT NULL,
    email VARCHAR(50) NULL,
    tanggal_adopsi DATE NOT NULL,
    hewan_id INT NOT NULL,
    FOREIGN KEY (hewan_id) REFERENCES hewan(id)
);
