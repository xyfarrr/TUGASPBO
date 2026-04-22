class BankBNI extends Bank {

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah: 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = bankTujuan.equalsIgnoreCase("BNI") ? 0 : 6500;
        
        System.out.println("[BNI] Mentransfer Rp" + jumlah + " ke " + rekeningTujuan + 
                           " (" + bankTujuan + "). Biaya: Rp" + biaya);
    }
}