# Program Manajemen Peserta

Program Manajemen Peserta adalah sebuah aplikasi konsol sederhana yang memungkinkan Anda mengelola daftar peserta. Dengan program ini, Anda dapat menambahkan, melihat, mengubah informasi, dan menghapus peserta.

## Penggunaan Program
Pada saat program dijalankan, Anda akan melihat menu utama dengan pilihan:

- Tambah Peserta
- Lihat Peserta
- Perbarui Peserta
- Hapus Peserta
- Keluar
Pilih opsi yang sesuai dengan tindakan yang ingin Anda lakukan.

Ikuti petunjuk yang muncul di layar untuk menambahkan, melihat, mengubah, atau menghapus peserta.

## Catatan Penting
Pastikan Anda memasukkan input yang valid sesuai dengan petunjuk yang diberikan.
Jika Anda ingin menghentikan program, pilih opsi "Keluar" pada menu utama.
Kontribusi
Anda dapat mengajukan perubahan atau peningkatan melalui pull request. Silakan rujuk panduan kontribusi di repositori ini.

## Penjelasan Kode
Kode program dan penggunaannya dijelaskan dengan detail di bagian berikut:

Kelas ParticipantManagement
Kelas ini bertanggung jawab untuk mengelola peserta. Beberapa metode yang ada di kelas ini meliputi:

- addPaticipants(manager): Menambahkan peserta baru ke dalam daftar.
- viewParticipants(): Menampilkan informasi peserta yang aktif.
- updateParticipants(manager): Mengubah informasi peserta yang ada.
- getParticipantByName(name): Mendapatkan peserta berdasarkan nama (dan status "Active").
- participantExists(name): Memeriksa apakah peserta dengan nama tertentu ada dalam daftar.
- phoneNumberExists(phoneNumber): Memeriksa apakah nomor telepon tertentu ada dalam daftar.
- deleteParticipants(): Menghapus peserta dengan menandainya sebagai "non-aktif".
