import java.util.ArrayList;
import java.util.List;

public class MainSistemEkspedisi {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("   SISTEM OPERASIONAL EXPEDITION - FASTSPEED EXPRESS   ");
        System.out.println("");

        List<Armada> daftarArmada = new ArrayList<>();
        daftarArmada.add(new MotorExpress("L 1234 ABC", "Honda Supra", 50, true));
        daftarArmada.add(new MobilBox("B 9988 XYZ", "Isuzu Elf", 2000, 6));
        daftarArmada.add(new DronePengirim("DRN-001", "DJI FlyChart", 10, 500));

        System.out.println(">>> REKAP BIAYA OPERASIONAL ARMADA <<<");
        double totalBiayaOperasional = 0;
        for (Armada a : daftarArmada) {
            a.tampilkanInfoArmada();
            totalBiayaOperasional += a.hitungBiayaOperasional();
            System.out.println("");
        }
        System.out.println("TOTAL OPERASIONAL ARMADA/HARI: Rp " + String.format("%,.2f", totalBiayaOperasional));
        System.out.println();

        List<Kurir> daftarKurir = new ArrayList<>();
        daftarKurir.add(new KurirTetap("K-001", "Rudi Hermawan", 120, 3500000, 5000));
        daftarKurir.add(new KurirMitra("M-501", "Bambang Perkasa", 85, 12000));

        System.out.println(">> DAFTAR GAJI & KAPABILITAS KURIR <<<");
        for (Kurir k : daftarKurir) {
            k.tampilkanProfil();
            System.out.println("\nUJI HAK AKSES & DYNAMIC CASTING");

            if (k instanceof AksesSistem) {
                AksesSistem akun = (AksesSistem) k; // Downcasting
                akun.login(k.getIdKurir(), "password123");
            } else {
                System.out.println("Info: Kurir " + k.getNama() + " TIDAK MEMILIKI akses login dashboard.");
            }

            if (k instanceof PresensiDigital) {
                PresensiDigital presensi = (PresensiDigital) k; // Downcasting
                presensi.rekamKehadiran();
            }
            System.out.println("");
        }
    }
}