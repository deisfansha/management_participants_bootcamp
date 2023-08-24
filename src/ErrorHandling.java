import participants.Participants;

import javax.swing.*;

public class ErrorHandling {
    // Mendapatkan pilihan yang valid dari pengguna
    public static int getValidChoice() {
        int choice = 0;
        boolean isValid = false;

        while (!isValid) {
            String menu = JOptionPane.showInputDialog("Pilih Menu:" +
                    "\n1. Tambah Peserta" +
                    "\n2. Lihat Peserta" +
                    "\n3. Ubah Data Peserta" +
                    "\n4. Hapus Peserta"+
                    "\n0. Keluar\n");
            choice = Integer.parseInt(menu);
            if (menu.matches("\\d+")) {
                choice = Integer.parseInt(menu);
            } else {
                JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!");
            }

            if (isValid) {
                break;
            }

            isValid = true;
        }
        return choice;
    }

    // Mendapatkan nomor telepon yang valid
    public static String getValidPhoneNumber(ParticipantManagement manager, Participants participantToUpdate) {
        while (true) {
            String phoneNumber;
            if (participantToUpdate != null){
                phoneNumber = JOptionPane.showInputDialog("Nomor Telepon:", participantToUpdate.getPhoneNumber());
            } else {
                phoneNumber = JOptionPane.showInputDialog("Nomor Telepon:");
            }

            if (phoneNumber == null) {
                break; // Kembali ke menu utama
            }

            if (validate12DigitNumericString(phoneNumber)) {
                if (manager.phoneNumberExists(phoneNumber)) {
                    JOptionPane.showMessageDialog(null, "Nomor Telepon Sudah Ada.");
                } else {
                    return phoneNumber;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nomor Telepon tidak valid.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    // Mendapatkan nama yang valid
    public static String getValidName(ParticipantManagement manager, Participants participantToUpdate){
        while (true) {
            String name;

            if (participantToUpdate != null){
                name = JOptionPane.showInputDialog("Nama:", participantToUpdate.getName());
            } else {
                name = JOptionPane.showInputDialog("Nama:");
            }

            if (name == null) {
                return null; // Return to the main menu
            } else if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Peserta Wajib Diisi.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            } else if (manager.getParticipantByName(name) != null) {
                JOptionPane.showMessageDialog(null, "Peserta dengan nama yang sama sudah ada.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            } else if (!validateAlphabet(name)) {
                JOptionPane.showMessageDialog(null, "Hanya boleh menginputkan huruf alfabet.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            } else {
                return name;
            }
        }
    }

    // Validasi hanya boleh 12 digit
    public static boolean validate12DigitNumericString(String phoneNumber) {
        return phoneNumber.matches("[0-9]{8,13}") && !phoneNumber.contains("-");
    }

    public static boolean validateAlphabet(String name){
        return  name.matches("^[a-zA-Z -]*$");
    }


}
