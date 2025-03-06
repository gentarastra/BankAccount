import Praktikum.BankAccount;

public class Main {
    public static void main(String[] args) {
        // Deklarasi variabel
        BankAccount akun1, akun2;

        // Instansiasi dengan constructor 4 parameter
        akun1 = new BankAccount("123456", "Andi", 1000.0, "Tabungan");

        // Instansiasi dengan constructor 3 parameter (saldo default)
        akun2 = new BankAccount("789012", "Budi", "Giro");

        // Panggil method displayInfo() untuk masing-masing akun
        System.out.println("Detail Akun 1:");
        akun1.displayInfo();
        System.out.println("\nDetail Akun 2:");
        akun2.displayInfo();

        // Transaksi: Deposit
        System.out.println("\nTransaksi Deposit:");
        akun1.deposit(500.0);  // Deposit valid
        akun1.deposit(-50.0);  // Deposit tidak valid

        // Transaksi: Withdraw
        System.out.println("\nTransaksi Withdraw:");
        akun1.withdraw(200.0);  // Withdraw valid
        akun1.withdraw(2000.0); // Withdraw tidak valid (saldo tidak cukup)

        // Transaksi: Transfer
        System.out.println("\nTransaksi Transfer:");
        akun1.transfer(akun2, 300.0);  // Transfer valid
        akun1.transfer(akun2, 2000.0); // Transfer tidak valid (saldo tidak cukup)
    }
}