public class Mahasiswaku {
    public static void main(String[] args) {

        Mahasiswa<String, String, Integer> m = new Mahasiswa<>();
        
        m.setNim("20240040109");
        m.setName("FARDA");
        m.setClas(22);

        System.out.println(m.getNim());
        System.out.println(m.getName());
        System.out.println(m.getClas());
    }
}