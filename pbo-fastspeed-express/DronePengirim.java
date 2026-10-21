public class DronePengirim extends Armada {
    private int batasKetinggianMaksimal;

    public DronePengirim(String noPlat, String merk, double kapasitasKg, int batasKetinggianMaksimal) {
        super(noPlat, merk, kapasitasKg);
        this.batasKetinggianMaksimal = batasKetinggianMaksimal;
    }

    @Override
    public double hitungBiayaOperasional() {
        return (this.kapasitasKg * 10000) + 50000;
    }

    @Override
    public void tampilkanInfoArmada() {
        System.out.println("DRONE PENGIRIM");
        super.tampilkanInfoArmada();
        System.out.println("Batas Ketinggian Maks: " + batasKetinggianMaksimal + " meter");
        System.out.println("Biaya/Hari: Rp " + String.format("%,.2f", hitungBiayaOperasional()));
    }
}
