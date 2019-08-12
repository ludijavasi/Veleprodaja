package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import table.JTableModelProdajnaCenaArtikla;
import table.JTableModelRacunOtpremnica;
import table.JTableModelStavkeRacunaOtpremnice;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JFrameStavkeRacunaPregled extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJedinicaMere;
	private JTextField textFieldDostupnaKolicina;
	private JTextField textFieldKolicina;
	private JTextField textFieldRabat;
	private JTable tableRacunOtpremnica;
	private JButton btnPrekidStavkeRacuna;
	

	public JButton getBtnPrekidStavkeRacuna() {
		return btnPrekidStavkeRacuna;
	}
	
	public JTable getTableRacunOtpremnica() {
		return tableRacunOtpremnica;
	}

	public void setTableRacunOtpremnica(JTable tableRacunOtpremnica) {
		this.tableRacunOtpremnica = tableRacunOtpremnica;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameStavkeRacunaPregled frame = new JFrameStavkeRacunaPregled();
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
	public JFrameStavkeRacunaPregled() {
		setTitle("RACUN / OTPREMNICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupaArtikala = new JLabel("Grupa artikala :");
		lblGrupaArtikala.setBounds(10, 25, 114, 14);
		contentPane.add(lblGrupaArtikala);
		
		JLabel lblArtikal = new JLabel("Artikal :");
		lblArtikal.setBounds(10, 50, 77, 14);
		contentPane.add(lblArtikal);
		
		JLabel lblJedinicaMere = new JLabel("Jedinica mere :");
		lblJedinicaMere.setBounds(10, 75, 98, 14);
		contentPane.add(lblJedinicaMere);
		
		JLabel lblDostupnaKolicina = new JLabel("Dostupna kolicina :");
		lblDostupnaKolicina.setBounds(10, 100, 114, 14);
		contentPane.add(lblDostupnaKolicina);
		
		JLabel lblKolicina = new JLabel("Kolicina :");
		lblKolicina.setBounds(10, 125, 77, 14);
		contentPane.add(lblKolicina);
		
		JLabel lblRabat = new JLabel("Rabat :");
		lblRabat.setBounds(10, 150, 77, 14);
		contentPane.add(lblRabat);
		
		textFieldJedinicaMere = new JTextField();
		textFieldJedinicaMere.setBounds(184, 72, 137, 20);
		contentPane.add(textFieldJedinicaMere);
		textFieldJedinicaMere.setColumns(10);
		
		textFieldDostupnaKolicina = new JTextField();
		textFieldDostupnaKolicina.setBounds(184, 97, 137, 20);
		contentPane.add(textFieldDostupnaKolicina);
		textFieldDostupnaKolicina.setColumns(10);
		
		textFieldKolicina = new JTextField();
		textFieldKolicina.setBounds(184, 122, 137, 20);
		contentPane.add(textFieldKolicina);
		textFieldKolicina.setColumns(10);
		
		textFieldRabat = new JTextField();
		textFieldRabat.setBounds(184, 147, 137, 20);
		contentPane.add(textFieldRabat);
		textFieldRabat.setColumns(10);
		
		JScrollPane scrollPaneRacunOtpremnica = new JScrollPane();
		scrollPaneRacunOtpremnica.setBounds(10, 191, 600, 151);
		contentPane.add(scrollPaneRacunOtpremnica);
		
		tableRacunOtpremnica = new JTable();
		scrollPaneRacunOtpremnica.setViewportView(tableRacunOtpremnica);	
		postaviModelStavkeProdaje(new ArrayList<>(), tableRacunOtpremnica);
		ArrayList lista;
		
				
		JButton btnSacuvajStavkeRacuna = new JButton("Sacuvaj");
		btnSacuvajStavkeRacuna.setBounds(10, 376, 89, 23);
		contentPane.add(btnSacuvajStavkeRacuna);
		
		btnPrekidStavkeRacuna = new JButton("Prekid");
		btnPrekidStavkeRacuna.setBounds(158, 376, 89, 23);
		contentPane.add(btnPrekidStavkeRacuna);
		
		JComboBox comboBoxArtikalRacunStavke = new JComboBox();
		comboBoxArtikalRacunStavke.setEditable(true);
		comboBoxArtikalRacunStavke.setBounds(184, 47, 137, 20);
		org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(comboBoxArtikalRacunStavke);

		contentPane.add(comboBoxArtikalRacunStavke);
		
		JComboBox comboBoxGrupaArtikalaRacunStavke = new JComboBox();
		comboBoxGrupaArtikalaRacunStavke.setBounds(184, 22, 137, 20);
		contentPane.add(comboBoxGrupaArtikalaRacunStavke);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaRacunStavke);
		comboBoxGrupaArtikalaRacunStavke.setSelectedItem(null);
		
		
		
		comboBoxGrupaArtikalaRacunStavke.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxGrupaArtikalaRacunStavke.getSelectedItem() != null) {
					popuniComboBoxArtikli(comboBoxArtikalRacunStavke,
							((GrupaArtikala) comboBoxGrupaArtikalaRacunStavke.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalRacunStavke.setSelectedItem(null);
				}
				else
				{
					comboBoxArtikalRacunStavke.removeAllItems();
					comboBoxArtikalRacunStavke.setSelectedItem(null);
				}
				
			}
		});
	}
		
	private void postaviModel(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
	}	
	
	private void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
		try {
			ArrayList<GrupaArtikala> lista = Kontroler.getInstance().getGrupaArtikala();

			for (GrupaArtikala ga : lista) {
				comboBox.addItem(ga);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void popuniComboBoxArtikli(JComboBox<String> comboBox, Integer id_grupe_artikala) {

		// ArrayList<GlavnaGrupa> lista =
		// Kontroler.getInstance().getGlavnaGrupaArtikala();

		try {
			comboBox.removeAllItems();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli(id_grupe_artikala);

			// for (GlavnaGrupa gg : lista) {
			for (Artikli a : lista1) {
				comboBox.addItem(a.getNaziv_artikla());				

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	private void postaviModelStavkeProdaje(ArrayList lista, JTable t){
		JTableModelStavkeRacunaOtpremnice model = new JTableModelStavkeRacunaOtpremnice(lista);
		t.setModel(model);
	}
}
