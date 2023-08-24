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
        String name = "";
        // Mendapatkan peserta berdasarkan nama jika ada dalam daftar
        Participants participantToUpdate = getParticipantByName(name);
        // Meminta dan memvalidasi nama peserta
        name = ErrorHandling.getValidName(manager,participantToUpdate);

        // Memeriksa apakah nama null (pengguna mengklik "Cancel")
        if (name == null) {
            return; // Kembali ke menu utama
        }

        // Meminta dan memvalidasi alamat peserta
        String address;
        while (true){
            address = JOptionPane.showInputDialog("Alamat:");
            if (address == ""){
                JOptionPane.showMessageDialog(null, "Alamat wajib diisi!!!.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }else {
                break;
            }
        }

        if (address == null) {
            return; // Return to the main menu
        }

        // Meminta dan memvalidasi nomor telepon peserta
        String phoneNumber = ErrorHandling.getValidPhoneNumber(manager, participantToUpdate);

        // Memeriksa apakah nomor telepon null (pengguna mengklik "Cancel")
        if (phoneNumber == null) {
            return; // Kembali ke menu utama
        }

        // Membuat objek peserta baru dan menambahkannya ke dalam daftar
        Participants newParticipant = new Participants(name.trim(), address.trim(), phoneNumber.trim(), "Active");
        participants.add(newParticipant);

        JOptionPane.showMessageDialog(null, "Peserta berhasil ditambahkan!");
    }

    // Metode untuk menampilkan informasi peserta yang aktif
    public void viewParticipants(){
        StringBuilder info = new StringBuilder();
        int no = 1;

        // Iterasi melalui peserta dan menambahkan informasi ke dalam StringBuilder
        for (Participants participant : participants){
            if (participant.getStatus().equals("Active")){
                info.append(no + ". " + participant.getName() + " | " + participant.getAddress() + " | " + participant.getPhoneNumber() + "\n");
                no++;
            }
        }

        // Cek apakah ada peserta aktif atau tidak
        if (info.length() == 0 || participants.isEmpty()) {
            // Tampilkan pesan bahwa tidak ada data peserta aktif
            JOptionPane.showMessageDialog(null, "Data Kosong!!!.", "Daftar Peserta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Tampilkan informasi peserta aktif
            JOptionPane.showMessageDialog(null, info.toString(), "Daftar Peserta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Metode untuk mengubah informasi peserta
    public void updateParticipants(ParticipantManagement manager){
        String name = JOptionPane.showInputDialog("Input Nama Yang Ingin Diubah:");
        if (name == null) {
            return; // Return to the main menu
        }
        Participants participantToUpdate = getParticipantByName(name);
        if (participantToUpdate!= null){
            participantToUpdate.setStatus("non-active");

            String newName = ErrorHandling.getValidName(manager, participantToUpdate);
            String newAddress;
            while (true){
                newAddress = JOptionPane.showInputDialog("Alamat Baru:", participantToUpdate.getAddress());
                if (newAddress == ""){
                    JOptionPane.showMessageDialog(null, "Alamat wajib diisi!!!.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }else {
                    break;
                }
            }

            if (newAddress == null) {
                return; // Return to the main menu
            }
            String newPhoneNumber = ErrorHandling.getValidPhoneNumber(manager, participantToUpdate);

            Participants newParticipant = new Participants(newName.trim(), newAddress.trim(), newPhoneNumber.trim(), "Active");
            participants.add(newParticipant);
            JOptionPane.showMessageDialog(null, "Data Peserta Berhasil Di Ubah!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Data Peserta tidak ditemukan.");
        }

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
        Participants dataParticipant = getParticipantByName(name);
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "==== Informasi Data ====" +
                "\nNama: " +dataParticipant.getName()+
                "\nAlamat: " +dataParticipant.getAddress()+
                "\nNomor Telepon: " +dataParticipant.getPhoneNumber()+
                "\nYakin ingin menghapus data ini?","WARNING", dialogButton);
        if(dialogButton == JOptionPane.YES_OPTION) {
            // Jika peserta ditemukan, tandai statusnya sebagai "non-aktif" dan tampilkan pesan sukses
            if (dataParticipant != null) {
                dataParticipant.setStatus("non-aktif");
                JOptionPane.showMessageDialog(null, "Informasi peserta dihapus dengan sukses!");
            } else {
                // Jika peserta tidak ditemukan, tampilkan pesan yang mengindikasikan hal tersebut
                JOptionPane.showMessageDialog(null, "Peserta tidak ditemukan.");
            }
            if(dialogButton == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }

    }
}
