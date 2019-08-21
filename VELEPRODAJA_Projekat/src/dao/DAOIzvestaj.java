package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Artikli;
import model.Izvestaj;

public class DAOIzvestaj {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}
	
	public ArrayList<Izvestaj> getStavkeRacunaOtpremniceIzvestaj(int id_racuna) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT naziv_artikla,kolicina_prodaje,jedinica_mere,neto_cena_artikla, "
				+ "rabat_prodaje, stopa_pdv_a FROM stavke_prodaje "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla WHERE id_racuna = ?");
		preparedStatement.setInt(1, id_racuna);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			String naziv = rs.getString ("naziv_artikla");			
			double kolicina_prodaje = rs.getDouble("kolicina_prodaje");	
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double rabatProdaje = rs.getDouble("rabat_prodaje");
			
			Izvestaj ga = new Izvestaj(naziv, kolicina_prodaje, jedinica_mere, neto_cena_artikla, stopa_PDV, rabatProdaje);
			
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	public ArrayList<Izvestaj> getIzvestajProdaje() throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna,"
				+ " datum_racuna, naziv_firme_kupca,username_zaposlenog , "
				+ "naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, "
				+ "naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla,"
				+ " artikal.stopa_pdv_a, SUM(kolicina_prodaje)FROM racun_otpremnica "
				+ "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "group by stavke_prodaje.id_artikla, datum_racuna");
		
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, naziv_firme_kupca, username_zaposlenog, naziv_filijale,
					grupa_artikala, idArtikla, naziv_artikla, idArtikla, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}

}
