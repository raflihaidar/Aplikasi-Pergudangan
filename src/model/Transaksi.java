package model;

public class Transaksi {

    private int id;
    private User user = new User();
    private Distributor distributor = new Distributor();
    private Status status = new Status();
    private String tanggal;
    private int total;
    private int jumlah;
    private String keterangan;

    public Transaksi(int id, int idUser, int idDistributor, String tanggal, int total, int jumlah,
            String keterangan, int idStatus) {
        this.id = id;
        this.user.setId(idUser);
        this.distributor.setId(idDistributor);
        this.tanggal = tanggal;
        this.total = total;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public Transaksi(int id, int idDistributor, int total) {
        this(id, 0, idDistributor, null, total, 0, null, 0);
    }

    public Transaksi(int idUser, int idDistributor, String tanggal, int jumlah) {
        this(0, idUser, idDistributor, tanggal, 0, jumlah, null, 0);
    }

    public Transaksi(int idUser) {
        this.user.setId(idUser);
    }

    public Transaksi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Status getStatus() {
        return status;
    }
}
