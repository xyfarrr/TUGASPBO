class Bank {
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan);
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (" + bankTujuan + ")");
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (" + bankTujuan + ") Pesan: " + berita);
    }

    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }
}