import java.util.ArrayList;
import java.util.List;

public class Dosen {
    // --- Atribut dari Sprint 1 ---
    private String nama;
    private String nidn;
    private List<Mahasiswa> mahasiswaBimbingan; // Agregasi [cite: 140]

    // --- Constructor (Sama seperti Sprint 1) ---
    public Dosen(String nama, String nidn) {
        this.nama = nama;
        this.nidn = nidn;
        this.mahasiswaBimbingan = new ArrayList<>();
    }

    // --- Metode dari Sprint 1 (US-001 & US-003) ---
    public void tambahMahasiswaBimbingan(Mahasiswa mhs) {
        this.mahasiswaBimbingan.add(mhs);
        // Kita juga set pembimbing di mahasiswa agar relasi 2 arah
        mhs.setPembimbing(this);
        System.out.println("INFO: " + mhs.getNama() + " berhasil menjadi bimbingan " + this.nama);
    }

    public void lihatDaftarBimbingan() {
        System.out.println("--- Daftar Bimbingan Dosen: " + this.nama + " ---");
        if (this.mahasiswaBimbingan.isEmpty()) {
            System.out.println("Belum memiliki mahasiswa bimbingan.");
            return;
        }
        for (Mahasiswa mhs : this.mahasiswaBimbingan) {
            System.out.println("- " + mhs.getNama() + " (" + mhs.getNim() + ") - Status: " + mhs.getStatus());
        }
    }

    // --- METODE BARU UNTUK SPRINT 2 ---

    // METODE UNTUK MEMENUHI US-004 (Hapus Bimbingan)
    public void hapusMahasiswaBimbingan(Mahasiswa mhs) {
        if (this.mahasiswaBimbingan.remove(mhs)) {
            // Putuskan relasi 2 arah
            mhs.hapusPembimbing();
            System.out.println("INFO: " + mhs.getNama() + " berhasil dihapus dari bimbingan " + this.nama);
        } else {
            System.out.println("ERROR: " + mhs.getNama() + " tidak ditemukan dalam daftar bimbingan.");
        }
    }

    // METODE UNTUK MEMENUHI US-005 (Tambah Catatan)
    public void tambahCatatanUntukMahasiswa(Mahasiswa mhs, String catatan) {
        // Dosen memanggil metode di Mahasiswa
        if (this.mahasiswaBimbingan.contains(mhs)) {
            mhs.tambahCatatan(catatan);
            System.out.println("INFO: Catatan ditambahkan untuk " + mhs.getNama());
        } else {
            System.out.println("ERROR: Tidak bisa menambah catatan, " + mhs.getNama() + " bukan bimbingan Anda.");
        }
    }

    // METODE UNTUK MEMENUHI US-007 (Ubah Status)
    public void ubahStatusMahasiswa(Mahasiswa mhs, String statusBaru) {
        if (this.mahasiswaBimbingan.contains(mhs)) {
            // Dosen memanggil metode di Mahasiswa
            mhs.setStatus(statusBaru);
        } else {
            System.out.println("ERROR: Tidak bisa mengubah status, " + mhs.getNama() + " bukan bimbingan Anda.");
        }
    }

    // ... getter untuk nama dan nidn ...
    public String getNama() { return this.nama; }
    public String getNidn() { return this.nidn; }
}