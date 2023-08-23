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
            try {
                choice = Integer.parseInt(menu);
                isValid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!");
            }
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
    public static String getValidName(ParticipantManagement manager){
        while (true){
            String name = JOptionPane.showInputDialog("Nama:");

            if (name == null) {
                break; // Kembali ke menu utama
            }

            if (manager.participantExists(name)){
                JOptionPane.showMessageDialog(null, "Peserta dengan nama yang sama sudah ada.");
            } else {
                return name;
            }
        }
        return null;
    }

    // Validasi hanya boleh 12 digit
    public static boolean validate12DigitNumericString(String phoneNumber) {
        return phoneNumber.matches("[0-9]{12}") && !phoneNumber.contains("-");
    }

}
