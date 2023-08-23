import participants.Participants;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ParticipantManagement manager = new ParticipantManagement();

        // Perulangan tak terbatas untuk menjalankan program terus-menerus
        while (true) {
            // Dapatkan pilihan yang valid dari pengguna menggunakan ErrorHandling.getValidChoice()
            int choice = ErrorHandling.getValidChoice();
            // Gunakan pernyataan switch untuk melakukan berbagai tindakan berdasarkan pilihan pengguna
            switch (choice) {
                case 1:
                    // Panggil method addParticipants dari manager untuk menambahkan peserta baru
                    manager.addPaticipants(manager);
                    break;
                case 2:
                    // Panggil method viewParticipants dari manager untuk melihat detail peserta
                    manager.viewParticipants();
                    break;
                case 3:
                    // Panggil method updateParticipants dari manager untuk mengubah informasi peserta
                    manager.updateParticipants(manager);
                    break;
                case 4:
                    // Panggil method deleteParticipants dari manager untuk menghapus peserta
                    manager.deleteParticipants();
                    break;
                case 0:
                    // Keluar dari program ketika pengguna memilih untuk keluar
                    System.exit(0);
                default:
                    // Tampilkan pesan kesalahan untuk pilihan yang tidak valid
                    JOptionPane.showMessageDialog(null, "Pilihan Tidak Valid");
            }
        }


    }
}