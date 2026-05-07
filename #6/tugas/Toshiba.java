public class Toshiba implements Laptop {
    private int volume;
    private boolean isPowerOn;

    public Toshiba() { this.volume = 50; } // Volume awal

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Toshiba menyala... Hello User!");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Toshiba mati.");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (this.volume < MAX_VOLUME) this.volume += 10;
            System.out.println("Volume Toshiba: " + this.volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (this.volume > MIN_VOLUME) this.volume -= 10;
            System.out.println("Volume Toshiba: " + this.volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }
}