package Praktikum;

// Deklarasi kelas BankAccount
public class BankAccount {
    // Field
    public String noRek;        // Nomor rekening
    public String namaPemilik;  // Nama pemilik rekening
    public double saldo;        // Saldo rekening
    public String jenisAkun;    // Jenis akun ("Tabungan" atau "Giro")

    // Constructor dengan 4 parameter
    public BankAccount(String noRek, String namaPemilik, double saldo, String jenisAkun) {
        this.noRek = noRek;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.jenisAkun = jenisAkun;
    }

    // Constructor dengan 3 parameter (saldo default berdasarkan jenis akun)
    public BankAccount(String noRek, String namaPemilik, String jenisAkun) {
        this.noRek = noRek;
        this.namaPemilik = namaPemilik;
        this.jenisAkun = jenisAkun;
        if (jenisAkun.equalsIgnoreCase("Tabungan")) {
            this.saldo = 100.0;
        } else if (jenisAkun.equalsIgnoreCase("Giro")) {
            this.saldo = 500.0;
        } else {
            this.saldo = 0.0; // Default jika jenis akun tidak valid
        }
    }

    // Instance Method 1: displayInfo()
    public void displayInfo() {
        System.out.println("Informasi Rekening:");
        System.out.println("Nomor Rekening: " + noRek);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp " + saldo);
        System.out.println("Jenis Akun: " + jenisAkun);
    }

    // Instance Method 2: deposit(double nominal)
    public void deposit(double nominal) {
        if (nominal <= 0) {
            System.out.println("Nominal deposit harus lebih dari 0 !");
        } else {
            saldo += nominal;
            System.out.println("Deposit berhasil: Rp " + nominal + " telah ditambahkan. Saldo sekarang: Rp " + saldo);
        }
    }

    // Instance Method 3: withdraw(double nominal)
    public void withdraw(double nominal) {
        if (nominal <= 0) {
            System.out.println("Nominal penarikan harus lebih dari 0 !");
        } else if (nominal > saldo) {
            System.out.println("Saldo tidak mencukupi!");
        } else {
            saldo -= nominal;
            System.out.println("Penarikan berhasil: Rp " + nominal + " telah ditarik. Saldo sekarang: Rp " + saldo);
        }
    }

    // Instance Method 4: transfer(BankAccount tujuan, double nominal)
    public void transfer(BankAccount tujuan, double nominal) {
        if (nominal <= 0) {
            System.out.println("Nominal transfer harus lebih dari 0 !");
        } else if (nominal > saldo) {
            System.out.println("Saldo tidak mencukupi untuk transfer!");
        } else {
            saldo -= nominal;
            tujuan.saldo += nominal;
            System.out.println("Transfer berhasil: Rp " + nominal + " dari " + noRek + " ke " + tujuan.noRek + ". Saldo pengirim: Rp " + saldo + ", Saldo penerima: Rp " + tujuan.saldo);
        }
    }
}