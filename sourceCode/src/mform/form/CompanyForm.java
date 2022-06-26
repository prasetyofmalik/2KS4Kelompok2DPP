package mform.form;

import mform.model.Company;

public class CompanyForm extends Form {
    private String kodeProv;
    private String namaProv;
    private String kodeKab;
    private String namaKab;
    private int periodeData;
    private Company company;
    private int i = 1;

    public String getKodeProv() {
        return this.kodeProv;
    }

    public void setKodeProv(String kodeProv) {
        this.kodeProv = kodeProv;
    }

    public String getNamaProv() {
        return this.namaProv;
    }

    public void setNamaProv(String namaProv) {
        this.namaProv = namaProv;
    }

    public String getKodeKab() {
        return this.kodeKab;
    }

    public void setKodeKab(String kodeKab) {
        this.kodeKab = kodeKab;
    }

    public String getNamaKab() {
        return this.namaKab;
    }

    public void setNamaKab(String namaKab) {
        this.namaKab = namaKab;
    }

    public int getPeriodeData() {
        return this.periodeData;
    }

    public void setPeriodeData(int periodeData) {
        this.periodeData = periodeData;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //Proses validasi data form
    @Override
    public boolean validate() {
        //Cek apakah objek company tersedia
        if (company == null) {
            super.addErrorMesssages("Object company tidak tersedia. Silahkan buat terlebih dahulu");
        }

        if (company.getKIP() == null) {
            super.addErrorMesssages("Kode Identitas Perusahaan tidak boleh kosong");
        }

        //Validasi kodeProv, kodekab, kodeKec
        if (this.getKodeProv().length() > 2 || this.getKodeKab().length() > 2 || company.getKIP().getKodeKec().length() > 3) {
            super.addErrorMesssages("Invalid kode daerah");
        }

        // //Validasi nomor telepon
        // if (!(company.getNoTelp().substring(0,2).equals("08"))) {
        //     super.addErrorMesssages("Invalid nomor telepon");
        // }

        //Validasi isKonfirm
        if (company.isKonfirm() == 0) {
            company.setStatus(0);
        }

        // if (!(company.getBadanHukum() instanceof BadanHukum)) {
        //     super.addErrorMesssages("Bentuk badan hukum tidak tersedia");
        // }

        //Validasi input KJU harus sesuai dengan usaha utama
        if (!(company.getKIP().getKodeKJU().contains(company.getInputUsahaUtama()))) {
            super.addErrorMesssages("Kode KJU harus sesuai kode usaha utama");
        }
        
        //Validasi usaha utama apakah sudah sesuai dengan usaha utama yang sudah tersedia
        boolean check = false;
        
        for (String j : company.getUsahaUtama().keySet()) {
            if (j.equals(company.getInputUsahaUtama())) {
                check = true;
                break;
            }
        }

        if (check == false) {
                 super.addErrorMesssages("Jenis usaha utama tidak tersedia");
        }


        //validasi subsektor jika subsector tanaman pangan, hortikultura, peternakan, kehutanan dan
        //perikanan harus memiliki nilai 0 atau 1, jika tidak maka inputan tidak valid
        for (String i: company.getSubsektor().keySet()) {
            if (i.equals("Perkebunan")) {
                continue;
            } else {
                if(! (company.getSubsektor().get(i).equals("1") || company.getSubsektor().get(i).equals("0"))) {
                    super.addErrorMesssages("Subsektor tidak tersedia");
                }
            }
        }

        return super.getErrorMessages().isEmpty();
    }

    //Simpan form
    @Override
    public boolean save() {
        System.out.println("Save data...");
        return true;
    }
    
    //Header form
    @Override
    public void headerForm() {
        System.out.println("=".repeat(40));
        System.out.println("Company Form");
        System.out.println("=".repeat(40));
        System.out.println("Kode Prov \t: " + this.getKodeProv());
        System.out.println("Nama Prov \t: " + this.getNamaProv());
        System.out.println("Kode Kab \t: " + this.getKodeKab());
        System.out.println("Nama Kab \t: " + this.getNamaKab());
        System.out.println("Periode Data \t: " + this.getPeriodeData());
        System.out.println("=".repeat(40));
    }
    
    //Display data form
    @Override
    public void print() {
        System.err.println("Perusahaan ke - " + i);
        i++;
        System.out.println("-".repeat(40));
        System.out.println("Kode Prov \t\t: " + company.getKIP().getKodeProv());
        System.out.println("Kode Kab \t\t: " + company.getKIP().getKodeKab());
        System.out.println("Kode Kec \t\t: " + company.getKIP().getKodeKec());
        System.out.println("Kode KJU \t\t: " + company.getKIP().getKodeKJU());
        System.out.println("No Urut di Kab/Kot \t: " + company.getKIP().getNoUrutKab());

        System.out.println("Nama Perusahaan \t: " + company.getNamaPerusahaan());
        System.out.println("Alamat Perusahaan \t: " + company.getAlamatPerusahaan());
        System.out.println("Nomor Telepon \t\t: " + company.getNoTelp());
        System.out.println("Nomor Faksimile \t: " + company.getNoFax());
        System.out.println("Bentuk Badan Hukum \t: " + company.getBadanHukum().getKode()
            + " (" + company.getBadanHukum().getNama() + ")");
        
        System.out.println("Pencacahan dengan DPP \t: " + company.isKonfirm());
        System.out.println("Status \t\t\t: " + company.getStatus());
        System.out.println("\nSubsektor");
        
        //Print Subsektor
        for (String i: company.getSubsektor().keySet()) {
            // if((company.getInputUsahaUtama().equals(i)))
                System.out.println(i + " \t\t: " + company.getSubsektor().get(i));
        }
        
        System.out.println("Bentuk Usaha Utama \t: " + company.getUsahaUtama().get(company.getInputUsahaUtama()));

        System.out.println("-".repeat(40));
        System.out.println();
    }

    //Reset form
    @Override
    public void reset() {
        this.company = null;
        this.kodeProv = null;
        this.namaProv = null;
        this.kodeKab = null;
        this.namaKab = null;
        this.periodeData = 0;

        throw new UnsupportedOperationException("Not supported yet");
    }

    
}
