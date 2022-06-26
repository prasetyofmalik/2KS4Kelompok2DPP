package mform;

import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

import mform.model.BadanHukum;
import mform.model.Company;
import mform.model.KIP;
import mform.form.CompanyForm;

public class Main {
    public static void main(String[] args) {
        //Buat BadanHukum
        BadanHukum[] bh = new BadanHukum[] {
            new BadanHukum(1, "Perusahaan Negara"),
            new BadanHukum(2, "Perusahaan Daerah"),
            new BadanHukum(3, "Persero"),
            new BadanHukum(4, "Perum"),
            new BadanHukum(5, "Perseroan Terbatas (PT)"),
            new BadanHukum(6, "Naamloze Vennootschap (NV)"),
            new BadanHukum(7, "Commanditaire Venootschap (CV)"),
            new BadanHukum(8, "Firma"),
            new BadanHukum(9, "Koperasi/KUD"),
            new BadanHukum(10, "Yayasan")
        };
        

        //Data Jenis Usaha Utama 
        HashMap<String, String> uu2 = new HashMap<>();
        uu2.put("1", "Padi/Palawija");
        uu2.put("2", "Hortikultura");
        uu2.put("3a", "Perkebunan Kakao/cokela");
        uu2.put("3b", "Perkebunan Karet");
        uu2.put("3c", "Perkebunan Kelapa sawit");
        uu2.put("3d", "Perkebunan Kopi");
        uu2.put("3e", "Perkebunan Teh");
        uu2.put("3f", "Perkebunan Tebu");
        uu2.put("3g", "Perkebunan Tembakau");
        uu2.put("3h", "Perkebunan Cengkeh");
        uu2.put("3i", "Perkebunan Kelapa");
        uu2.put("3j", "Perkebunan Lada");
        uu2.put("3k", "Perkebunan Tanaman Lainnya");
        uu2.put("5", "HPH/IUPHK-HT/Perhutani/Kehutanan lainnya"); 
        uu2.put("6", "Penangkaran STL"); 
        uu2.put("7a", "Budidaya Udang");
        uu2.put("7b", "Budidaya Bandeng");
        uu2.put("7c", "Budidaya Ikan lainnya di tambak");
        uu2.put("7d", "Budidaya Ikan di laut");
        uu2.put("7e", "Budidaya Ikan di air tawar");
        uu2.put("7f", "Budidaya Pembenihan");
        uu2.put("8", "Penangkapan Ikan");
        uu2.put("9", "Ternak Sapi Perah");
        uu2.put("10", "Ternak Besar/Kecil");
        uu2.put("11", "Unggas");
       

        //Buat Form
        CompanyForm cf = new CompanyForm();

        //Buat Company
        Company c1 = new Company();

        //Set company untuk form
        cf.setCompany(c1);

        //Entri Data untuk form
        cf.setKodeKab("60");
        cf.setKodeProv("02");
        cf.setNamaKab("Bandung");
        cf.setNamaProv("Jawa Barat");
        cf.setPeriodeData(2022);
        
        c1.setKIP(new KIP(cf.getKodeProv(), cf.getKodeKab(), "123", "1", 1));
        c1.setNamaPerusahaan("PT Jaya Sentosa");
        c1.setAlamatPerusahaan("Jalan Jenderal Sudirman");
        c1.setNoTelp("087765478977");
        c1.setNoFax("");
        c1.setKonfirm(1);
        c1.setStatus(1); 
        c1.setUsahaUtama(uu2);
        c1.setBadanHukum(bh[0]);

        HashMap<String, String> subSektor = new HashMap<>();
        subSektor.put("Tanaman Pangan", "1");
        subSektor.put("Hortikultura", "1" );
        subSektor.put("Perkebunan", "3d" );
        subSektor.put("Peternakan", "1" );
        subSektor.put("Kehutanan", "1" );
        subSektor.put("Perikanan", "1" );

        c1.setSubsektor(subSektor);
        c1.setInputUsahaUtama("1"); //Harus sesuai dengan KJu
        
        // Proses validasi dan print data
        if (!cf.validate()) {
            System.out.println("Data invalid. Perbaiki error di bawah ini :");
            List<String> errorMessages = cf.getErrorMessages();
            for (String errorMessage : errorMessages) {
                //JOptionPane.showMessageDialog(this, "errorMessage");
                System.out.println("- "+ errorMessage);
            }
        } else {
            cf.save();
            System.out.println("Data telah tersimpan");
            cf.headerForm();
            cf.print();

        }
        
        //Reset form
        // try {
        //     cf.reset();
        // } catch(Exception e) {
        //     System.out.println("Something went wrong");
        // }
        

        //Buat Company Baru
        // Company c2 = new Company();
        // cf.setCompany(c2);
        
        // c2.setKIP(new KIP(cf.getKodeProv(), cf.getKodeKab(), "663", "1", 1));
        // c2.setNamaPerusahaan("PT Jaya Abadi");
        // c2.setAlamatPerusahaan("Jalan Sultan Syahrir");
        // c2.setNoTelp("0890");
        // c2.setNoFax("");
        // c2.setKonfirm(1);
        // c2.setStatus(1); 
        // c2.setUsahaUtama(uu2);
        // c2.setBadanHukum(bh[3]);
        // c2.setSubsektor(subSektor);
        // c2.setInputUsahaUtama("1");

        // if (!cf.validate()) {
        //     System.out.println("Data invalid. Perbaiki error di bawah ini :");
        //     List<String> errorMessages = cf.getErrorMessages();
        //     for (String errorMessage : errorMessages) {
        //         System.out.println("- "+ errorMessage);
        //     }
        // } else {
        //     cf.save();
        //     System.out.println("Data telah tersimpan");
        //     cf.print();
        // }

    }
}
