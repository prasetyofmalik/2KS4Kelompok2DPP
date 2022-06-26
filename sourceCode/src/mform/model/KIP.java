package mform.model;

public class KIP {
    private String kodeProv;
    private String kodeKab;
    private String kodeKec;
    private String kodeKJU;
    private int noUrutKab;

    public KIP(String kodeProv, String kodeKkab, String kodeKec, String kodeKJU, int noUrutKab) {
        this.kodeProv = kodeProv;
        this.kodeKab = kodeKkab;
        this.kodeKec = kodeKec;
        this.kodeKJU = kodeKJU;
        this.noUrutKab = noUrutKab;
    }
    
    public KIP() {
    }
    
    public String getKodeProv() {
        return this.kodeProv;
    }

    public void setKodeProv(String kodeProv) {
        this.kodeProv = kodeProv;
    }

    public String getKodeKab() {
        return this.kodeKab;
    }

    public void setKodeKab(String kodeKab) {
        this.kodeKab = kodeKab;
    }

    public String getKodeKec() {
        return this.kodeKec;
    }

    public void setKodeKec(String kodeKec) {
        this.kodeKec = kodeKec;
    }

    public String getKodeKJU() {
        return this.kodeKJU;
    }

    public void setKodeKJU(String kodeKJU) {
        this.kodeKJU = kodeKJU;
    }

    public int getNoUrutKab() {
        return this.noUrutKab;
    }

    public void setNoUrutKab(int noUrutKab) {
        this.noUrutKab = noUrutKab;
    }
}
