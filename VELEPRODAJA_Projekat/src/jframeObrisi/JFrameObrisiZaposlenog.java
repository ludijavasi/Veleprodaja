package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameZaposleni;
import kontroler.Kontroler;
import model.Magacin;
import model.Zaposleni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JFrameObrisiZaposlenog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdZaposlenog;
	private JButton btnNazadObrisiZaposlenog;
	
	public JButton getBtnNazadObrisiZaposlenog() {
		return btnNazadObrisiZaposlenog;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiZaposlenog frame = new JFrameObrisiZaposlenog();
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
	public JFrameObrisiZaposlenog() {
		setTitle("OBRISI ZAPOSLENOG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteZaposlenog = new JLabel("Izaberite zaposlenog :");
		lblIzaberiteZaposlenog.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIzaberiteZaposlenog.setBounds(55, 49, 251, 17);
		contentPane.add(lblIzaberiteZaposlenog);
		
		JButton btnOtvoriZaposlenog = new JButton("Otvori zaposlenog");
		btnOtvoriZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameZaposleni jfzo = new JFrameZaposleni();
				
				jfzo.getBtnDodajZaposlenog().setVisible(false);
				jfzo.getBtnAzurirajZaposlenog().setVisible(false);
				//jfzo.getBtnDodajZaposlenog().setVisible(false);
				int idz = Integer.parseInt(textFieldIdZaposlenog.getText().trim());
				
			    try {
					Zaposleni z = Kontroler.getInstance().getDetaljiZaposleni(idz);
					
					jfzo.getTextIDZaposlenog().setText(Integer.toString(z.getIdZaposlenog()));
					jfzo.getTextIme().setText(z.getImeZaposlenog());
					jfzo.getTextPrezime().setText(z.getPrezimeZaposlenog());
					jfzo.getTextJMBG().setText(z.getJmbgZaposlenog());
					jfzo.getTextAdresa().setText(z.getAdresaZaposlenog());
					jfzo.getTextGrad_Ostina().setText(z.getGradOpstinaZaposlenog());
					jfzo.getTextTelefon().setText(z.getTelefonZaposlenog());
					jfzo.getTextEMail().setText(z.getEmailZaposlenog());					
					
					jfzo.getTextPlata().setText(Double.toString(z.getPlataZaposlenog()));
					jfzo.getComboBoxTipZaposlenja().setSelectedItem(z.getTipZaposlenja());
					
					jfzo.getComboBoxStrucnaSprema().setSelectedItem(z.getStrucnaSpremaZaposlenog());
					jfzo.getDateChooserDatumZaposlenja().setDate(z.getDatumPocetkaZaposlenja());
					jfzo.getDateChooserPrestankaZaposlenja().setDate(z.getDatumZavrsetkaZaposlenja());
					
					jfzo.getTextUsername().setText(z.getUsernameZaposlenog());
					jfzo.getTextPassword().setText(z.getPasswordZaposlenog());					
					
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    
			    jfzo.getBtnObrisiZaposlenog().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int idz = Integer.parseInt(jfzo.getTextIDZaposlenog().getText().trim());
						
						try {
							Kontroler.getInstance().deleteZaposleni(idz);
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali zaposlenog!");
							jfzo.setVisible(false);
							
							
						} catch (HeadlessException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch (ClassNotFoundException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						} catch (SQLException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}					
						
					}
				});
			    
			    jfzo.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfzo.setVisible(false);
						
						
					}
				});
			    
			    jfzo.setVisible(true);		    
			    
			    
			}
		});
		btnOtvoriZaposlenog.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriZaposlenog.setBounds(213, 173, 171, 23);
		contentPane.add(btnOtvoriZaposlenog);
		
		JLabel lblIdZaposlenog = new JLabel("ID zaposlenog :");
		lblIdZaposlenog.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdZaposlenog.setBounds(55, 131, 155, 14);
		contentPane.add(lblIdZaposlenog);
		
		textFieldIdZaposlenog = new JTextField();
		textFieldIdZaposlenog.setBounds(220, 128, 86, 20);
		contentPane.add(textFieldIdZaposlenog);
		textFieldIdZaposlenog.setColumns(10);
		
		JComboBox<Zaposleni> comboBoxIzaberiteZaposlenog = new JComboBox();
		comboBoxIzaberiteZaposlenog.setBounds(55, 87, 251, 20);
		contentPane.add(comboBoxIzaberiteZaposlenog);
		popuniComboBoxZaposleni(comboBoxIzaberiteZaposlenog);
		comboBoxIzaberiteZaposlenog.setSelectedItem(null);
		
		btnNazadObrisiZaposlenog = new JButton("Nazad");
		btnNazadObrisiZaposlenog.setBounds(55, 175, 89, 23);
		contentPane.add(btnNazadObrisiZaposlenog);
		comboBoxIzaberiteZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Zaposleni z = (Zaposleni) comboBoxIzaberiteZaposlenog.getSelectedItem();
				textFieldIdZaposlenog.setText(Integer.toString(z.getIdZaposlenog()));
			}
		});
	}
	
	    private void popuniComboBoxZaposleni(JComboBox<Zaposleni> comboBox) {
		try {
			ArrayList<Zaposleni> lista = Kontroler.getInstance().getZaposleni();

			for (Zaposleni z : lista) {
				comboBox.addItem(z);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
