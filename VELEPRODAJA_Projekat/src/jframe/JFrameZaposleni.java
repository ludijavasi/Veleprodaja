package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.color.CMMException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Zaposleni;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JFrameZaposleni extends JFrame {

	private JPanel contentPaneDodajZaposlenog;
	private JTextField textIme;
	private JLabel lblPrezime;
	private JTextField textPrezime;
	private JLabel lblAdresa;
	private JTextField textAdresa;
	private JLabel lblGradostina;
	private JTextField textGrad_Ostina;
	private JLabel lblPol;
	private JTextField textTelefon;
	private JTextField textEmail;
	private JPanel panelPodacioZaposlenju;
	private JLabel lblStrucnaSprema;
	private JComboBox comboBoxStrucnaSprema;
	private JLabel lblDatumPocetkaZaposlenja;
	private JLabel lblDatumPrestankaZaposlenja;
	private JLabel lblFilijalaPosla;
	private JComboBox comboBoxFilijalaPosla;
	private JLabel lblPlata;
	private JTextField textPlata;
	private JLabel lblTipZaposlenja;
	private JComboBox comboBoxTipZaposlenja;
	private JPanel panel;
	private JLabel lblUsername;
	private JTextField textUsername;
	private JLabel lblPassword;
	private JTextField textPassword;
	private JButton btnPonistiAkciju;
	private JLabel lblIdZaposlenog;
	private JTextField textIDZaposlenog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameZaposleni frame = new JFrameZaposleni();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameZaposleni() {
		setTitle("ZAPOSLENI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 532);
		contentPaneDodajZaposlenog = new JPanel();
		contentPaneDodajZaposlenog.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneDodajZaposlenog);
		contentPaneDodajZaposlenog.setLayout(null);

		JPanel panelLicnipodaci = new JPanel();
		panelLicnipodaci
				.setBorder(new TitledBorder(null, "Licni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLicnipodaci.setBounds(10, 11, 265, 318);
		contentPaneDodajZaposlenog.add(panelLicnipodaci);
		panelLicnipodaci.setLayout(null);

		JLabel lblIme = new JLabel("Ime :");
		lblIme.setBounds(10, 30, 46, 14);
		panelLicnipodaci.add(lblIme);

		textIme = new JTextField();
		textIme.setBounds(102, 27, 134, 20);
		panelLicnipodaci.add(textIme);
		textIme.setColumns(10);

		lblPrezime = new JLabel("Prezime :");
		lblPrezime.setBounds(10, 67, 61, 14);
		panelLicnipodaci.add(lblPrezime);

		textPrezime = new JTextField();
		textPrezime.setBounds(102, 58, 134, 20);
		panelLicnipodaci.add(textPrezime);
		textPrezime.setColumns(10);

		lblAdresa = new JLabel("Adresa :");
		lblAdresa.setBounds(10, 104, 61, 14);
		panelLicnipodaci.add(lblAdresa);

		textAdresa = new JTextField();
		textAdresa.setBounds(102, 95, 134, 20);
		panelLicnipodaci.add(textAdresa);
		textAdresa.setColumns(10);

		lblGradostina = new JLabel("Grad/Ostina :");
		lblGradostina.setBounds(10, 136, 82, 14);
		panelLicnipodaci.add(lblGradostina);

		textGrad_Ostina = new JTextField();
		textGrad_Ostina.setBounds(102, 133, 134, 20);
		panelLicnipodaci.add(textGrad_Ostina);
		textGrad_Ostina.setColumns(10);

		lblPol = new JLabel("Pol :");
		lblPol.setBounds(10, 178, 46, 14);
		panelLicnipodaci.add(lblPol);

		JComboBox comboBoxPol = new JComboBox();
		comboBoxPol.setModel(new DefaultComboBoxModel(new String[] {"Muski", "Zenski"}));
		comboBoxPol.setBounds(102, 178, 134, 20);
		panelLicnipodaci.add(comboBoxPol);

		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setBounds(10, 219, 61, 14);
		panelLicnipodaci.add(lblTelefon);

		textTelefon = new JTextField();
		textTelefon.setBounds(102, 216, 134, 20);
		panelLicnipodaci.add(textTelefon);
		textTelefon.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(10, 260, 46, 14);
		panelLicnipodaci.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(102, 257, 134, 20);
		panelLicnipodaci.add(textEmail);
		textEmail.setColumns(10);

		panelPodacioZaposlenju = new JPanel();
		panelPodacioZaposlenju.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Podaci o zaposlenju", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPodacioZaposlenju.setBounds(295, 22, 331, 307);
		contentPaneDodajZaposlenog.add(panelPodacioZaposlenju);
		panelPodacioZaposlenju.setLayout(null);

		lblStrucnaSprema = new JLabel("Strucna sprema :");
		lblStrucnaSprema.setBounds(10, 25, 122, 14);
		panelPodacioZaposlenju.add(lblStrucnaSprema);

		comboBoxStrucnaSprema = new JComboBox();
		comboBoxStrucnaSprema.setModel(new DefaultComboBoxModel(new String[] {"IV stepen", "V stepen", "VI stepen", "VII stepen"}));
		comboBoxStrucnaSprema.setBounds(190, 22, 131, 20);
		panelPodacioZaposlenju.add(comboBoxStrucnaSprema);

		lblDatumPocetkaZaposlenja = new JLabel("Datum pocetka zaposlenja :");
		lblDatumPocetkaZaposlenja.setBounds(10, 63, 158, 14);
		panelPodacioZaposlenju.add(lblDatumPocetkaZaposlenja);

		lblDatumPrestankaZaposlenja = new JLabel("Datum prestanka zaposlenja :");
		lblDatumPrestankaZaposlenja.setBounds(10, 109, 175, 14);
		panelPodacioZaposlenju.add(lblDatumPrestankaZaposlenja);

		lblFilijalaPosla = new JLabel("Filijala posla :");
		lblFilijalaPosla.setBounds(10, 185, 78, 14);
		panelPodacioZaposlenju.add(lblFilijalaPosla);

		comboBoxFilijalaPosla = new JComboBox();
		comboBoxFilijalaPosla.setModel(new DefaultComboBoxModel(new String[] {"Kraljevo", "Cacak", "Berlin"}));
		comboBoxFilijalaPosla.setBounds(190, 182, 131, 20);
		panelPodacioZaposlenju.add(comboBoxFilijalaPosla);

		JCheckBox chckbxDatumPrestankaPoslaNeodredjeno = new JCheckBox("Datum prestanka posla neodredjeno");
		chckbxDatumPrestankaPoslaNeodredjeno.setBounds(10, 141, 258, 23);
		panelPodacioZaposlenju.add(chckbxDatumPrestankaPoslaNeodredjeno);

		lblPlata = new JLabel("Plata :");
		lblPlata.setBounds(10, 216, 46, 14);
		panelPodacioZaposlenju.add(lblPlata);

		textPlata = new JTextField();
		textPlata.setBounds(190, 213, 131, 20);
		panelPodacioZaposlenju.add(textPlata);
		textPlata.setColumns(10);

		lblTipZaposlenja = new JLabel("Tip zaposlenja :");
		lblTipZaposlenja.setBounds(10, 246, 103, 14);
		panelPodacioZaposlenju.add(lblTipZaposlenja);

		comboBoxTipZaposlenja = new JComboBox();
		comboBoxTipZaposlenja.setModel(new DefaultComboBoxModel(new String[] {"Menadzer", "Komercijalista", "Magacioner"}));
		comboBoxTipZaposlenja.setBounds(190, 243, 131, 20);
		panelPodacioZaposlenju.add(comboBoxTipZaposlenja);

		JDateChooser dateChooserDatumZaposlenja = new JDateChooser();
		dateChooserDatumZaposlenja.setBounds(190, 63, 131, 20);
		panelPodacioZaposlenju.add(dateChooserDatumZaposlenja);

		JDateChooser dateChooserPrestankaZaposlenja = new JDateChooser();
		dateChooserPrestankaZaposlenja.setBounds(190, 103, 131, 20);
		panelPodacioZaposlenju.add(dateChooserPrestankaZaposlenja);

		lblIdZaposlenog = new JLabel("ID Zaposlenog :");
		lblIdZaposlenog.setBounds(77, 282, 90, 14);
		panelPodacioZaposlenju.add(lblIdZaposlenog);

		textIDZaposlenog = new JTextField();
		textIDZaposlenog.setBounds(190, 279, 86, 20);
		panelPodacioZaposlenju.add(textIDZaposlenog);
		textIDZaposlenog.setColumns(10);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Korisnicki podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 344, 265, 97);
		contentPaneDodajZaposlenog.add(panel);
		panel.setLayout(null);

		lblUsername = new JLabel("Username :");
		lblUsername.setBounds(10, 23, 81, 14);
		panel.add(lblUsername);

		textUsername = new JTextField();
		textUsername.setBounds(101, 20, 128, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);

		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 62, 81, 14);
		panel.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setBounds(101, 59, 128, 20);
		panel.add(textPassword);
		textPassword.setColumns(10);

		JButton btnDodajZaposlenog = new JButton("Dodaj Zaposlenog");
		btnDodajZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
				String ime = textIme.getText();
				String prezime = textPrezime.getText();
				String adresa = textAdresa.getText();
				String grad = textGrad_Ostina.getText();
				String pol = (String)comboBoxPol.getSelectedItem();
				String tel = textTelefon.getText();
				String email = textEmail.getText();
				
				String username = textUsername.getText();
				String password = textPassword.getText();
				
				String struc_sprema = (String)comboBoxStrucnaSprema.getSelectedItem();
				
				Date datum_poc = dateChooserDatumZaposlenja.getDate();
				Date datum_zav = dateChooserPrestankaZaposlenja.getDate();
				
				//boolean datum_prest = chckbxDatumPrestankaPoslaNeodredjeno.isSelected();
				
				//String filijala = (String)comboBoxFilijalaPosla.getSelectedItem();
				Double plata = Double.parseDouble(textPlata.getText());
				String tip_zaposlenja = (String)comboBoxTipZaposlenja.getSelectedItem();
				
				Zaposleni z = new Zaposleni(ime, prezime, adresa, grad, pol, tel, email, struc_sprema, datum_poc, datum_zav, plata, tip_zaposlenja, username, password);
				
				
					Kontroler.getInstance().insertZaposleni(z);
					
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novog zaposlenog!");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnDodajZaposlenog.setBounds(295, 340, 155, 23);
		contentPaneDodajZaposlenog.add(btnDodajZaposlenog);

		JButton btnObrisiZaposlenog = new JButton("Obrisi Zaposlenog");
		btnObrisiZaposlenog.setBounds(295, 374, 155, 23);
		contentPaneDodajZaposlenog.add(btnObrisiZaposlenog);

		JButton btnAzurirajZaposlenog = new JButton("Azuriraj Zaposlenog");
		btnAzurirajZaposlenog.setBounds(295, 408, 155, 23);
		contentPaneDodajZaposlenog.add(btnAzurirajZaposlenog);

		btnPonistiAkciju = new JButton("Ponisti akciju");
		btnPonistiAkciju.setBounds(295, 445, 155, 23);
		contentPaneDodajZaposlenog.add(btnPonistiAkciju);
	}
}
