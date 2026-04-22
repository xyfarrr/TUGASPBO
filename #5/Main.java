import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== INPUT DATA MAHASISWA ===");
        System.out.print("Nama Mahasiswa: ");
        String sName = scanner.nextLine();
        System.out.print("Alamat: ");
        String sAddress = scanner.nextLine();
        
        Student mhs = new Student(sName, sAddress);
        mhs.addCourseGrade("PBO", 90);
        mhs.addCourseGrade("Basis Data", 85);

        System.out.println(mhs.toString());
        mhs.printGrades();
        System.out.println("Rata-rata: " + mhs.getAverageGrade());

        System.out.println("\n=== INPUT DATA DOSEN ===");
        System.out.print("Nama Dosen: ");
        String tName = scanner.nextLine();
        System.out.print("Alamat: ");
        String tAddress = scanner.nextLine();

        Teacher dosen = new Teacher(tName, tAddress);
        System.out.println(dosen.toString());

        System.out.print("Tambah Mata Kuliah: ");
        String matkul = scanner.nextLine();
        if (dosen.addCourse(matkul)) {
            System.out.println("Berhasil menambahkan " + matkul);
        } else {
            System.out.println("Mata kuliah sudah ada!");
        }

        scanner.close();
    }
}