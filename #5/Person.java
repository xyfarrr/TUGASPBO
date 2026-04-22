public class Person {
    private String name;
    private String address;

    // Konstruktor untuk inisialisasi nama dan alamat [cite: 18]
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter untuk mengambil nama [cite: 19]
    public String getName() {
        return name;
    }

    // Getter untuk mengambil alamat [cite: 20]
    public String getAddress() {
        return address;
    }

    // Setter untuk mengubah alamat [cite: 21]
    public void setAddress(String address) {
        this.address = address;
    }

    // Menampilkan format: "name (address)" [cite: 22, 23]
    @Override
    public String toString() {
        return name + "(" + address + ")";
    }
}