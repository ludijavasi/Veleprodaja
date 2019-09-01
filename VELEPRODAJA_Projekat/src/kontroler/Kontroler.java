package kontroler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import dao.DAOArtikli;
import dao.DAOFilijala;
import dao.DAOGrupaArtikala;
import dao.DAOIzvestaj;
import dao.DAOKupac;
import dao.DAOMagacin;
import dao.DAORacunOtpremnica;
import dao.DAOStavkeRacunaOtpremnice;
import dao.DAOZaposleni;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import model.Magacin;
import model.RacunOtpremnica;
import model.StavkeRacunaOtpremnice;
import model.Zaposleni;


public class Kontroler {
	
	public static Kontroler kontroler;

	private Kontroler() {
	}

	public static Kontroler getInstance() {
		if (kontroler == null)
			kontroler = new Kontroler();
		return kontroler;
	}
	
	public ArrayList<Artikli> getArtikliSVI() throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		ArrayList<Artikli> lista = da.getArtikliSVI();
		return lista;
	}	
	
	public ArrayList<Artikli> getArtikli(int id_grupe_artikala) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		ArrayList<Artikli> lista = da.getArtikli(id_grupe_artikala);
		return lista;
	}	
	
	public ArrayList<Artikli> getArtikli(int id_grupe_artikala, int id_artikla) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		ArrayList<Artikli> lista = da.getArtikli(id_grupe_artikala, id_artikla);
		return lista;
	}	
	
	public  void insertArikli(Artikli a) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		da.insertArtikli(a);
	}
	
	public  Artikli getDetaljiArtikli(int ida) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
	    return da.getDetaljiArtikli(ida);
	}
	
	public void deleteArtikal(int rba) throws ClassNotFoundException, SQLException{
		DAOArtikli da = new DAOArtikli();
		da.deleteArtikal(rba);
	}
	
	public ArrayList<Zaposleni> getZaposleni() throws ClassNotFoundException, SQLException {
		DAOZaposleni dz = new DAOZaposleni();
		ArrayList<Zaposleni> lista = dz.getZaposleni();
		return lista;
	}
	
	public void insertZaposleni(Zaposleni z) throws ClassNotFoundException, SQLException {
		DAOZaposleni dz = new DAOZaposleni();
		dz.insertZaposleni(z);
	}
	
	public  Zaposleni getDetaljiZaposleni(int idz) throws ClassNotFoundException, SQLException {
		DAOZaposleni dz = new DAOZaposleni();
	    return dz.getDetaljiZaposleni(idz);
	}	
	
	public void deleteZaposleni(int idz) throws ClassNotFoundException, SQLException{
		DAOZaposleni dz = new DAOZaposleni();
		dz.deleteZaposleni(idz);
	}
	
	public void updateZaposleni(Zaposleni z) throws ClassNotFoundException, SQLException{
		DAOZaposleni dz = new DAOZaposleni();
		dz.updateZaposleni(z);
	}	
	
	public ArrayList<Filijala> getFilijala() throws ClassNotFoundException, SQLException {
		DAOFilijala df = new DAOFilijala();
		ArrayList<Filijala> lista = df.getFilijala();
		return lista;
	}
	
	public void insertFilijala(Filijala f) throws ClassNotFoundException, SQLException {
		DAOFilijala df = new DAOFilijala();
		df.insertFilijala(f);
	}
	
	public void obrisiFilijalu(int rbf) throws ClassNotFoundException, SQLException{
		DAOFilijala df = new DAOFilijala();
		df.obrisiFilijalu(rbf);
	}
	
	public  Filijala getDetaljiFilijale(int idf) throws ClassNotFoundException, SQLException {
		DAOFilijala df = new DAOFilijala();
		return df.getDetaljiFilijale(idf);
	}	
	
	public ArrayList<Kupac> getKupac() throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		ArrayList<Kupac> lista = dk.getKupac();
		return lista;
	}
	
	public void insertKupac(Kupac k) throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		dk.insertKupac(k);
	}
	
	public void obrisiKupca(int idk) throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		dk.obrisiKupca(idk);
	}
	
	public Kupac getDetaljiKupca(int idk) throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		return dk.getDetaljiKupca(idk);
		
	}
	
	public ArrayList<Magacin> getMagacin() throws ClassNotFoundException, SQLException {
		DAOMagacin dm = new DAOMagacin();
		ArrayList<Magacin> lista = dm.getMagacin();
		return lista;
	}
	
	public void insertMagacin(Magacin m) throws ClassNotFoundException, SQLException {
		DAOMagacin dm = new DAOMagacin();
		dm.insertMagacin(m);
	}

	public void obrisiMagacin(int rbn) throws ClassNotFoundException, SQLException{
		DAOMagacin dm = new DAOMagacin();
		dm.obrisiMagacin(rbn);
	}
	public  Magacin getDetaljiMagacina(int idm) throws ClassNotFoundException, SQLException {
		DAOMagacin mg = new DAOMagacin();
		return mg.getDetaljiMagacina(idm);
	}		
	
	
	public ArrayList<GrupaArtikala> getGrupaArtikala() throws ClassNotFoundException, SQLException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		ArrayList<GrupaArtikala> lista = dga.getGrupaArtikala();
		return lista;
	}
	
	public ArrayList<GrupaArtikala> getGrupaArtikala(int id_grupe_artikla) throws ClassNotFoundException, SQLException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		ArrayList<GrupaArtikala> lista = dga.getGrupaArtikala(id_grupe_artikla);
		return lista;
	}
	
	public void insertGrupaArtikala(GrupaArtikala ga) throws SQLException, ClassNotFoundException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		dga.insertGrupaArtikala(ga);
	}	
	
	public  GrupaArtikala getDetaljiGrupaArtikala(int idga) throws ClassNotFoundException, SQLException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		return dga.getDetaljiGrupeArtikala(idga);
	}	
	
	public void deleteGrupaArtikala(int idga) throws ClassNotFoundException, SQLException{
		DAOGrupaArtikala dga = new DAOGrupaArtikala();		
		dga.deleteGrupaArtikala(idga);
	}
	
	public ArrayList<RacunOtpremnica> getRacun() throws ClassNotFoundException, SQLException {
		DAORacunOtpremnica dro = new DAORacunOtpremnica();
		ArrayList<RacunOtpremnica> lista = dro.getRacun();
		return lista;
	}
	public int insertRacunOtpremnicu(RacunOtpremnica ro) throws ClassNotFoundException, SQLException {
		DAORacunOtpremnica dro = new DAORacunOtpremnica();
		return dro.insertRacunOtpremnicu(ro);
	}
	public void insertStavkaRacuna(StavkeRacunaOtpremnice sro) throws SQLException, ClassNotFoundException {
		DAOStavkeRacunaOtpremnice dsro = new DAOStavkeRacunaOtpremnice();
		dsro.insertStavkaRacuna(sro);
	}
	public ArrayList<Izvestaj> getStavkeRacunaOtpremniceIzvestaj(int id_racuna) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getStavkeRacunaOtpremniceIzvestaj(id_racuna);
	}
	public void updateRacun(int idr, double poreska_osnovica_racuna, double ukupan_iznos_obracunatog_pdv_a_racuna, 
			double ukupna_vrednost_racuna ) throws SQLException, ClassNotFoundException {
		DAORacunOtpremnica ro = new DAORacunOtpremnica();
		ro.updateRacun(idr, poreska_osnovica_racuna, ukupan_iznos_obracunatog_pdv_a_racuna, ukupna_vrednost_racuna);
	}
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijali(int id_filijale, String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getIzvestajProdajePoFilijali(id_filijale,d,d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijaliPoGrupi(Integer id_filijale, Integer id_grupe_artikala,String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getIzvestajProdajePoFilijaliPoGrupi(id_filijale, id_grupe_artikala, d, d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijaliPoGrupiPoArtiklu(Integer id_filijale, Integer id_grupe_artikala, Integer id_artikla,String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getIzvestajProdajePoFilijaliPoGrupiPoArtiklu(id_filijale, id_grupe_artikala, id_artikla, d, d1);
	}

	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcu(Integer id_kupca,String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getIzvestajProdajePoKupcu(id_kupca,d,d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupi(Integer id_kupca, Integer id_grupe_artikala,String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getIzvestajProdajePoKupcuPoGrupi(id_kupca, id_grupe_artikala,d,d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoArtiklu(Integer id_kupca, Integer id_grupe_artikala, Integer id_artikla,String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getIzvestajProdajePoKupcuPoGrupiPoArtiklu(id_kupca, id_grupe_artikala, id_artikla,d,d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenom(Integer id_zaposlenog) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getIzvestajProdajePoZposlenom(id_zaposlenog);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenomPoGrupi(Integer id_zaposlenog, Integer id_grupe_artikala) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getIzvestajProdajePoZposlenomPoGrupi(id_zaposlenog, id_grupe_artikala);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenomPoGrupiPoArtiklu(Integer id_zaposlenog, Integer id_grupe_artikala, Integer id_artikla) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
		return di.getIzvestajProdajePoZposlenomPoGrupiPoArtiklu(id_zaposlenog, id_grupe_artikala, id_artikla);
	}
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcuRacun(Integer id_kupca, String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getIzvestajProdajePoKupcuRacun(id_kupca,d,d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoRacunu(Integer id_kupca, Integer id_grupe_artikala, String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getIzvestajProdajePoKupcuPoGrupiPoRacunu(id_kupca, id_grupe_artikala,d,d1);
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoArtikluPoRacunu(Integer id_kupca, Integer id_grupe_artikala, Integer id_artikla,String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getIzvestajProdajePoKupcuPoGrupiPoArtikluPoRacunu(id_kupca, id_grupe_artikala, id_artikla,d,d1);
	}
	public ArrayList<Izvestaj> getRacunPregledRacuna(String d, String d1) throws ClassNotFoundException, SQLException {
		DAOIzvestaj di = new DAOIzvestaj();
	    return di.getRacunPregledRacuna(d,d1);
	}

}
