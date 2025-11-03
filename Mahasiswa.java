// Impor baru yang dibutuhkan
import java.util.ArrayList;
import java.util.List;

public class Mahasiswa {
    // --- Atribut dari Sprint 1 ---
    private String nama;
    private String nim;
    private Dosen pembimbing; // Asosiasi dari US-002

    // --- ATRIBUT BARU UNTUK SPRINT 2 ---
    private List<String> catatanBimbingan; // Untuk US-005 & US-006
    private String status;                 // Untuk US-007

    // --- Constructor dimodifikasi untuk inisialisasi atribut baru ---
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.pembimbing = null; // Default
        this.catatanBimbingan = new ArrayList<>(); // Inisialisasi list (US-005)
        this.status = "Aktif"; // Default status (US-007)
    }

    // --- Metode dari Sprint 1 (US-002) ---
    public void setPembimbing(Dosen dosen) {
        this.pembimbing = dosen;
    }

    public void lihatDosenPembimbing() {
        if (this.pembimbing != null) {
            System.out.println("INFO: Dosen pembimbing " + this.nama + " adalah " + this.pembimbing.getNama());
        } else {
            System.out.println("INFO: " + this.nama + " belum memiliki dosen pembimbing.");
        }
    }

    // --- METODE BARU UNTUK SPRINT 2 ---

    // METODE UNTUK MEMENUHI US-004 (Hapus Bimbingan)
    public void hapusPembimbing() {
        this.pembimbing = null;
    }

    // METODE UNTUK MEMENUHI US-005 (Tambah Catatan)
    public void tambahCatatan(String catatan) {
        this.catatanBimbingan.add(catatan);
    }

    // METODE UNTUK MEMENUHI US-006 (Lihat Catatan)
    public void lihatCatatanBimbingan() {
        System.out.println("--- Catatan Bimbingan untuk: " + this.nama + " ---");
        if (this.catatanBimbingan.isEmpty()) {
            System.out.println("Belum ada catatan.");
        } else {
            for (String catatan : this.catatanBimbingan) {
                System.out.println("- " + catatan);
            }
        }
    }

    // METODE UNTUK MEMENUHI US-007 (Ubah Status)
    public void setStatus(String status) {
        this.status = status;
        System.out.println("INFO: Status " + this.nama + " diubah menjadi: " + this.status);
    }

    // ... getter untuk nama, nim, status ...
    public String getNama() { return this.nama; }
    public String getNim() { return this.nim; }
    public String getStatus() { return this.status; }
}