import java.util.ArrayList;
import java.util.List;
import participants.Participants;

import javax.swing.*;

public class ParticipantManagement {
    private List<Participants> participants;

    // Konstruktor untuk menginisialisasi daftar peserta saat objek ParticipantManagement dibuat
    public ParticipantManagement() {
        participants = new ArrayList<>();
    }

    // Metode untuk menambahkan peserta baru ke dalam daftar peserta
    public void addPaticipants(ParticipantManagement manager) {
        // Meminta dan memvalidasi nama peserta
        String name = ErrorHandling.getValidName(manager);

        // Memeriksa apakah nama null (pengguna mengklik "Cancel")
        if (name == null) {
            return; // Kembali ke menu utama
        }

        // Mendapatkan peserta berdasarkan nama jika ada dalam daftar
        Participants participantToUpdate = getParticipantByName(name);

        // Meminta dan memvalidasi alamat peserta
        String address = JOptionPane.showInputDialog("Alamat:");

        // Meminta dan memvalidasi nomor telepon peserta
        String phoneNumber = ErrorHandling.getValidPhoneNumber(manager, participantToUpdate);

        // Memeriksa apakah nomor telepon null (pengguna mengklik "Cancel")
        if (phoneNumber == null) {
            return; // Kembali ke menu utama
        }

        // Membuat objek peserta baru dan menambahkannya ke dalam daftar
        Participants newParticipant = new Participants(name, address, phoneNumber, "Active");
        participants.add(newParticipant);

        JOptionPane.showMessageDialog(null, "Peserta berhasil ditambahkan!");
    }

    // Metode untuk menampilkan informasi peserta yang aktif
    public void viewParticipants(){
        StringBuilder info = new StringBuilder();
        int no = 1;

        // Memeriksa apakah daftar peserta kosong
        if (participants.isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Kosong!!!");
        } else {
            // Iterasi melalui peserta dan menambahkan informasi ke dalam StringBuilder
            for (Participants participant : participants){
                if (participant.getStatus().equals("Active")){
                    info.append(no + ". " + participant.getName() + " | " + participant.getAddress() + " | " + participant.getPhoneNumber() + "\n");
                    no++;
                }
            }
            JOptionPane.showMessageDialog(null, info.toString());
        }
    }

    // Metode untuk mengubah informasi peserta
    public void updateParticipants(ParticipantManagement manager){
        // Meminta nama peserta yang ingin diperbarui
        String name = JOptionPane.showInputDialog("Masukkan nama peserta yang ingin Anda perbarui:");

        // Memeriksa apakah nama null (pengguna mengklik "Cancel")
        if (name == null) {
            return; // Kembali ke menu utama
        }

        // Mendapatkan peserta berdasarkan nama
        Participants participantToUpdate = getParticipantByName(name);

        // ...
        // Bagian lain dari metode updateParticipants, termasuk validasi input lainnya
        // ...

    }

    // Metode untuk mendapatkan peserta berdasarkan nama (dan status "Active")
    public Participants getParticipantByName(String name){
        for (Participants participant : participants){
            if (participant.getName().equals(name) && participant.getStatus().equals("Active")){
                return participant;
            }
        }
        return null;
    }

    // Metode untuk memeriksa apakah peserta dengan nama tertentu ada dalam daftar
    public boolean participantExists(String name) {
        for (Participants participant : participants) {
            if (participant.getName().equalsIgnoreCase(name) && participant.getStatus().equals("Active")) {
                return true;
            }
        }
        return false;
    }

    // Metode untuk memeriksa apakah nomor telepon tertentu ada dalam daftar
    public boolean phoneNumberExists(String phoneNumber) {
        for (Participants participant : participants) {
            if (String.valueOf(participant.getPhoneNumber()).equals(phoneNumber) && participant.getStatus().equals("Active")) {
                return true;
            }
        }
        return false;
    }


    public void deleteParticipants() {
        // Minta pengguna memasukkan nama peserta yang ingin dihapus
        String name = JOptionPane.showInputDialog("Masukkan nama peserta yang ingin Anda hapus:");

        // Jika pengguna membatalkan masukan, kembali ke menu utama
        if (name == null) {
            return;
        }

        // Cari peserta dengan nama yang diberikan dalam daftar peserta
        Participants participantToUpdate = getParticipantByName(name);

        // Jika peserta ditemukan, tandai statusnya sebagai "non-aktif" dan tampilkan pesan sukses
        if (participantToUpdate != null) {
            participantToUpdate.setStatus("non-aktif");
            JOptionPane.showMessageDialog(null, "Informasi peserta dihapus dengan sukses!");
        } else {
            // Jika peserta tidak ditemukan, tampilkan pesan yang mengindikasikan hal tersebut
            JOptionPane.showMessageDialog(null, "Peserta tidak ditemukan.");
        }
    }
}
