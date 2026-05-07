public class MacBook implements Laptop {
    private int volume;
    private boolean isPowerOn;

    public MacBook() { 
        this.volume = 50;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("MacBook menyala... macOS siap digunakan!");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("MacBook mati. Goodbye!");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (this.volume < MAX_VOLUME) {
                this.volume += 10;
            }
            System.out.println("Volume MacBook: " + this.volume);
        } else {
            System.out.println("Nyalakan MacBook terlebih dahulu!");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (this.volume > MIN_VOLUME) {
                this.volume -= 10;
            }
            System.out.println("Volume MacBook: " + this.volume);
        } else {
            System.out.println("Nyalakan MacBook terlebih dahulu!");
        }
    }
}