package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import model.Filijala;
import model.Magacin;

public class DAOFilijala {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Filijala> getFilijala() throws ClassNotFoundException, SQLException {
		ArrayList<Filijala> lista = new ArrayList<Filijala>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from filijala");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("id_filijale");
			String nazivFilijale = rs.getString("naziv_filijale");
			String adresaFilijale = rs.getString("adresa_filijale");
			String gradOpstinaFilijale = rs.getString("grad_opstina_filijale");
			String telefonFilijale = rs.getString("telefon_filijale");
			String emailFilijale = rs.getString("e_mail_filijale");
			int pibFilijale = rs.getInt("pib_filijale");
			String tekuciRacunFilijale = rs.getString("tekuci_racun_filijale");
			String status = rs.getString("status");	
						

			Filijala f = new Filijala(idFilijale, nazivFilijale, adresaFilijale, gradOpstinaFilijale, telefonFilijale, emailFilijale, pibFilijale, tekuciRacunFilijale, status);

			lista.add(f);
		}
		konekcija.close();
		return lista;
	}

	public void insertFilijala(Filijala f) throws SQLException, ClassNotFoundException {
		connect();
		
		preparedStatement = konekcija
				.prepareStatement("INSERT INTO filijala (naziv_filijale, adresa_filijale, grad_opstina_filijale, telefon_filijale, "
		                           +" e_mail_filijale, pib_filijale, tekuci_racun_filijale, status)"
						           +" VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		preparedStatement.setString(1, f.getNazivFilijale());
		preparedStatement.setString(2, f.getAdresaFilijale());
		preparedStatement.setString(3, f.getGradOpstinaFilijale());
		preparedStatement.setString(4, f.getTelefonFilijale());
		preparedStatement.setString(5, f.getEmailFilijale());
		preparedStatement.setInt(6, f.getPibFilijale());
		preparedStatement.setString(7, f.getTekuciRacunFilijale());
		preparedStatement.setString(8, f.getStatus());
		
		preparedStatement.execute();

		konekcija.close();		
	}
	
	public void obrisiFilijalu(int idf) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = konekcija.prepareStatement("delete from filijala where id_filijale = ?");

		preparedStatement.setInt(1, idf);

		preparedStatement.execute();

		konekcija.close();
	}
	
	/*public ComboBoxModel<Filijala> getDetaljiFilijale(Filijala f) throws ClassNotFoundException, SQLException {
		ComboBoxModel<Filijala> lista = (ComboBoxModel<Filijala>) new ArrayList<Filijala>();
		int fid = f.getIdFilijale();
		connect();
		preparedStatement = konekcija.prepareStatement("select * from filijala where id_filijale =?");
		preparedStatement.setInt(1, fid);

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("id_filijale");
			String nazivFilijale = rs.getString("naziv_filijale");
			String adresaFilijale = rs.getString("adresa_filijale");
			String gradOpstinaFilijale = rs.getString("grad_opstina_filijale");
			String telefonFilijale = rs.getString("telefon_filijale");
			String emailFilijale = rs.getString("e_mail_filijale");
			int pibFilijale = rs.getInt("pib_filijale");
			String tekuciRacunFilijale = rs.getString("tekuci_racun_filijale");
			String status = rs.getString("status");	
						

			Filijala fil = new Filijala(idFilijale, nazivFilijale, adresaFilijale, gradOpstinaFilijale, telefonFilijale, emailFilijale, pibFilijale, tekuciRacunFilijale, status);
			((ArrayList<Filijala>) lista).add(fil);
	
		}
		konekcija.close();
		return lista;
	}*/

}
