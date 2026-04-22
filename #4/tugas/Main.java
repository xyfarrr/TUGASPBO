public class Main {
    public static void main(String[] args) {
        Bank bankUmum = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        bankUmum.sukuBunga();
        bankUmum.transferUang(50000, "12345");

        bni.sukuBunga();
        bca.sukuBunga();
    }
}