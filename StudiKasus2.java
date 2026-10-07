import java.util.Scanner;

public class StudiKasus2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama mahasiswa : ");
        String nama = sc.nextLine();
        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        String jenis = sc.nextLine();

        boolean lomba = jenis.equalsIgnoreCase("BELMAWA")
                || jenis.equalsIgnoreCase("BAKORMA")
                || jenis.equalsIgnoreCase("MANDIRI");
        boolean pkm = jenis.equalsIgnoreCase("PKM");
        String status;

        if (lomba || pkm) {
            System.out.print("Jumlah dokumen : ");
            int dokumen = sc.nextInt();
            int peringkat = 0, statusPKM = 0;

            // data tambahan ditanyakan sesuai jenis kegiatan
            if (lomba) {
                System.out.print("Peringkat juara : ");
                peringkat = sc.nextInt();
            } else {
                System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak lolos) : ");
                statusPKM = sc.nextInt();
            }

            // baru dicek hasilnya
            if (dokumen < 4) {
                status = "Dokumen tidak lengkap (kurang " + (4 - dokumen)
                        + " dokumen). Dana penghargaan tidak diberikan.";
            } else if (lomba) {
                status = (peringkat >= 1 && peringkat <= 3)
                        ? "Dokumen lengkap dan Juara " + peringkat + ". Dana penghargaan diberikan."
                        : "Bukan Juara 1, 2, atau 3. Dana penghargaan tidak diberikan.";
            } else {
                status = (statusPKM == 1)
                        ? "Dokumen lengkap dan PKM lolos pendanaan. Dana penghargaan diberikan."
                        : "PKM tidak lolos pendanaan. Dana penghargaan tidak diberikan.";
            }
        } else if (jenis.equalsIgnoreCase("LAINNYA")) {
            status = "Kegiatan kategori Lainnya. Dana penghargaan tidak diberikan.";
        } else {
            status = "Jenis kegiatan tidak dikenali.";
        }

        System.out.println("Status : " + status);
        sc.close();
    
    }   
}