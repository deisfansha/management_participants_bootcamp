package participants;

// Definisi kelas Participants
public class Participants {
    private String name;
    private String address;
    private String phoneNumber;
    private String status;

    // Konstruktor untuk menginisialisasi objek Participants
    public Participants(String name, String address, String phoneNumber, String status) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    // Metode getter untuk mendapatkan nama peserta
    public String getName() {
        return name;
    }

    // Metode getter untuk mendapatkan alamat peserta
    public String getAddress() {
        return address;
    }

    // Metode setter untuk mengatur nama peserta
    public void setName(String name) {
        this.name = name;
    }

    // Metode setter untuk mengatur alamat peserta
    public void setAddress(String address) {
        this.address = address;
    }

    // Metode setter untuk mengatur nomor telepon peserta
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Metode getter untuk mendapatkan nomor telepon peserta
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Metode getter untuk mendapatkan status peserta
    public String getStatus() {
        return status;
    }

    // Metode setter untuk mengatur status peserta
    public void setStatus(String status) {
        this.status = status;
    }
}
