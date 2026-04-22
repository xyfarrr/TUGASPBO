class BankBCA extends Bank {

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah: 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = bankTujuan.equalsIgnoreCase("BCA") ? 0 : 2500;
        
        System.out.println("[BCA] Mentransfer Rp" + jumlah + " ke " + rekeningTujuan + 
                           " (" + bankTujuan + "). Biaya: Rp" + biaya);
    }
}