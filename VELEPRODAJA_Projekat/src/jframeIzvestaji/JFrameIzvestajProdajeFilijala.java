package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import model.Zaposleni;
import table.JTableModelCenaArtikla;
import table.JTableModelProdajaPoFilijali;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class JFrameIzvestajProdajeFilijala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNabavnaVrenostIzvestajFilijala;
	private JTextField textFieldOsnovicaIzvestajFilijala;
	private JTextField txtProdajnavrednostIzvestajProdajeFilijala;
	private JTextField textFieldRucIzvestajProdajeFiljala;
	private JTable tableIzvestajProdaje;
	private JComboBox comboBoxArtikalIzvestajProdaje;
	

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldNabavnaVrenostIzvestajNabavke() {
		return textFieldNabavnaVrenostIzvestajFilijala;
	}

	public JTextField getTextFieldOsnovicaIzvestaj() {
		return textFieldOsnovicaIzvestajFilijala;
	}

	public JTextField getTxtProdajnavrednostIzvestajProdaje() {
		return txtProdajnavrednostIzvestajProdajeFilijala;
	}

	public JTextField getTextFieldRucIzvestajProdaje() {
		return textFieldRucIzvestajProdajeFiljala;
	}

	public JTable getTableIzvestajProdaje() {
		return tableIzvestajProdaje;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeFilijala frame = new JFrameIzvestajProdajeFilijala();
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
	public JFrameIzvestajProdajeFilijala() {
		setTitle("IZVE\u0160TAJ PRODAJE PO FILIJALAMA");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilijal = new JLabel("Filijala : ");
		lblFilijal.setFont(new Font("Arial", Font.BOLD, 14));
		lblFilijal.setBounds(30, 20, 170, 20);
		contentPane.add(lblFilijal);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(350, 20, 470, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelOdIzvestajProdaje = new JLabel("DO :");
		labelOdIzvestajProdaje.setFont(new Font("Arial", Font.BOLD, 14));
		labelOdIzvestajProdaje.setBounds(260, 30, 30, 20);
		panel.add(labelOdIzvestajProdaje);
		
		JLabel lblDoizvestajprodaje = new JLabel("OD :");
		lblDoizvestajprodaje.setFont(new Font("Arial", Font.BOLD, 14));
		lblDoizvestajprodaje.setBounds(10, 30, 30, 20);
		panel.add(lblDoizvestajprodaje);
		
		JDateChooser dateChooserrDoIzvestajProdaje = new JDateChooser();
		dateChooserrDoIzvestajProdaje.setBounds(310, 30, 150, 20);
		panel.add(dateChooserrDoIzvestajProdaje);
		
		JDateChooser dateChooserOdIzvestajProdaje = new JDateChooser();
		dateChooserOdIzvestajProdaje.setBounds(60, 30, 150, 20);
		panel.add(dateChooserOdIzvestajProdaje);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 120, 710, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGrupaArtiklaIzvestajProdaje = new JLabel("Grupa artikala :");
		lblGrupaArtiklaIzvestajProdaje.setFont(new Font("Arial", Font.BOLD, 14));
		lblGrupaArtiklaIzvestajProdaje.setBounds(10, 20, 110, 20);
		panel_1.add(lblGrupaArtiklaIzvestajProdaje);
		
		JComboBox comboBoxFilijalaIzvestajProdaje = new JComboBox();
		comboBoxFilijalaIzvestajProdaje.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxFilijalaIzvestajProdaje.setBounds(30, 60, 200, 20);
		contentPane.add(comboBoxFilijalaIzvestajProdaje);
		popuniComboBoxFilijala(comboBoxFilijalaIzvestajProdaje);
		comboBoxFilijalaIzvestajProdaje.setSelectedItem(null);
		
		comboBoxFilijalaIzvestajProdaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				postaviModelProdajaPoArtiklu(new ArrayList<Filijala>(), tableIzvestajProdaje);
				ArrayList lista;
				try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserOdIzvestajProdaje.getDate());
						String sd1 = sdf.format(dateChooserrDoIzvestajProdaje.getDate());
						
						lista = Kontroler.getInstance().getIzvestajProdajePoFilijali(((Filijala) 
									comboBoxFilijalaIzvestajProdaje.getSelectedItem()).getIdFilijale(),sd,sd1);
						
						postaviModelProdajaPoArtiklu(lista, tableIzvestajProdaje);
						suma(tableIzvestajProdaje);
						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
				
			}
		});
		
		
		
		
		
		JComboBox comboBoxGrupaArtikalaIzvestajProdaje = new JComboBox();
		comboBoxGrupaArtikalaIzvestajProdaje.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaIzvestajProdaje.setBounds(150, 20, 200, 20);
		panel_1.add(comboBoxGrupaArtikalaIzvestajProdaje);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaIzvestajProdaje);
		comboBoxGrupaArtikalaIzvestajProdaje.setSelectedItem(null);
		comboBoxGrupaArtikalaIzvestajProdaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviModelProdajaPoArtiklu(new ArrayList<GrupaArtikala>(), tableIzvestajProdaje);
				ArrayList lista;
				try {
					
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserOdIzvestajProdaje.getDate());
						String sd1 = sdf.format(dateChooserrDoIzvestajProdaje.getDate());
					
						lista = Kontroler.getInstance().getIzvestajProdajePoFilijaliPoGrupi(((Filijala) 
								comboBoxFilijalaIzvestajProdaje.getSelectedItem()).getIdFilijale(),((GrupaArtikala) 
								comboBoxGrupaArtikalaIzvestajProdaje.getSelectedItem()).getIdGrupeArtikala(),sd,sd1);
						postaviModelProdajaPoArtiklu(lista, tableIzvestajProdaje);
						suma(tableIzvestajProdaje);
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		comboBoxGrupaArtikalaIzvestajProdaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {
				//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
				if (comboBoxGrupaArtikalaIzvestajProdaje.getSelectedItem() != null) {
					
					//pamcenje i skidanje actionlistener-a
					ActionListener al = comboBoxArtikalIzvestajProdaje.getActionListeners()[0];
					comboBoxArtikalIzvestajProdaje.removeActionListener(al);
					
					popuniComboBoxArtikli(comboBoxArtikalIzvestajProdaje,
							((GrupaArtikala) comboBoxGrupaArtikalaIzvestajProdaje.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalIzvestajProdaje.setSelectedItem(null);
					
					//vracanje zapamcenog actionlistener-a
					comboBoxArtikalIzvestajProdaje.addActionListener(al);
				}
				else
				{
					comboBoxArtikalIzvestajProdaje.removeAllItems();
					comboBoxArtikalIzvestajProdaje.setSelectedItem(null);
				}
			}
			
		});
		
		
		
		JLabel lblArtikalIzvestajProdaje = new JLabel("Artikal :");
		lblArtikalIzvestajProdaje.setFont(new Font("Arial", Font.BOLD, 14));
		lblArtikalIzvestajProdaje.setBounds(400, 20, 70, 20);
		panel_1.add(lblArtikalIzvestajProdaje);
		
		comboBoxArtikalIzvestajProdaje = new JComboBox();
		comboBoxArtikalIzvestajProdaje.setBounds(490, 20, 200, 20);
		panel_1.add(comboBoxArtikalIzvestajProdaje);		
		//comboBoxArtikalIzvestajProdaje.setSelectedItem(null);
		
		comboBoxArtikalIzvestajProdaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				postaviModelProdajaPoArtiklu(new ArrayList<Artikli>(), tableIzvestajProdaje);
				ArrayList lista;
				try {
						
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserOdIzvestajProdaje.getDate());
						String sd1 = sdf.format(dateChooserrDoIzvestajProdaje.getDate());

						lista = Kontroler.getInstance().getIzvestajProdajePoFilijaliPoGrupiPoArtiklu(((Filijala) 
								comboBoxFilijalaIzvestajProdaje.getSelectedItem()).getIdFilijale(),((GrupaArtikala) 
								comboBoxGrupaArtikalaIzvestajProdaje.getSelectedItem()).getIdGrupeArtikala(),
								((Artikli)comboBoxArtikalIzvestajProdaje.getSelectedItem()).getIdArtikla(),sd,sd1);
						postaviModelProdajaPoArtiklu(lista, tableIzvestajProdaje);
						suma(tableIzvestajProdaje);
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		
		
		
		
		
		
		JScrollPane scrollPaneIzvestajProdaje = new JScrollPane();
		scrollPaneIzvestajProdaje.setBounds(30, 200, 1220, 230);
		contentPane.add(scrollPaneIzvestajProdaje);
		
		tableIzvestajProdaje = new JTable();
		tableIzvestajProdaje.setFont(new Font("Arial", Font.PLAIN, 13));
		postaviModelProdajaPoArtiklu(new ArrayList<>(), tableIzvestajProdaje);
		ArrayList lista;
		scrollPaneIzvestajProdaje.setViewportView(tableIzvestajProdaje);
		
		JPanel panelIzvestajFilijala = new JPanel();
		panelIzvestajFilijala.setBounds(30, 500, 1100, 50);
		contentPane.add(panelIzvestajFilijala);
		panelIzvestajFilijala.setLayout(null);
		
		JLabel lblNabavnaVrenostFilijala = new JLabel("Nabavna vrenost :");
		lblNabavnaVrenostFilijala.setFont(new Font("Arial", Font.BOLD, 14));
		lblNabavnaVrenostFilijala.setBounds(10, 20, 130, 20);
		panelIzvestajFilijala.add(lblNabavnaVrenostFilijala);
		
		textFieldNabavnaVrenostIzvestajFilijala = new JTextField();
		textFieldNabavnaVrenostIzvestajFilijala.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNabavnaVrenostIzvestajFilijala.setBounds(160, 20, 120, 20);
		panelIzvestajFilijala.add(textFieldNabavnaVrenostIzvestajFilijala);
		textFieldNabavnaVrenostIzvestajFilijala.setColumns(10);
		
		JLabel lblOsnovica = new JLabel("Osnovica :");
		lblOsnovica.setFont(new Font("Arial", Font.BOLD, 14));
		lblOsnovica.setBounds(320, 20, 80, 20);
		panelIzvestajFilijala.add(lblOsnovica);
		
		textFieldOsnovicaIzvestajFilijala = new JTextField();
		textFieldOsnovicaIzvestajFilijala.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldOsnovicaIzvestajFilijala.setBounds(420, 20, 120, 20);
		panelIzvestajFilijala.add(textFieldOsnovicaIzvestajFilijala);
		textFieldOsnovicaIzvestajFilijala.setColumns(10);
		
		JLabel lblProdajnaVrednost = new JLabel("Prodajna vrednost :");
		lblProdajnaVrednost.setFont(new Font("Arial", Font.BOLD, 14));
		lblProdajnaVrednost.setBounds(580, 20, 140, 20);
		panelIzvestajFilijala.add(lblProdajnaVrednost);
		
		txtProdajnavrednostIzvestajProdajeFilijala = new JTextField();
		txtProdajnavrednostIzvestajProdajeFilijala.setFont(new Font("Arial", Font.PLAIN, 13));
		txtProdajnavrednostIzvestajProdajeFilijala.setBounds(740, 20, 120, 20);
		panelIzvestajFilijala.add(txtProdajnavrednostIzvestajProdajeFilijala);
		txtProdajnavrednostIzvestajProdajeFilijala.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC :");
		lblRuc.setFont(new Font("Arial", Font.BOLD, 14));
		lblRuc.setBounds(900, 20, 50, 20);
		panelIzvestajFilijala.add(lblRuc);
		
		textFieldRucIzvestajProdajeFiljala = new JTextField();
		textFieldRucIzvestajProdajeFiljala.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRucIzvestajProdajeFiljala.setBounds(970, 20, 120, 20);
		panelIzvestajFilijala.add(textFieldRucIzvestajProdajeFiljala);
		textFieldRucIzvestajProdajeFiljala.setColumns(10);
		
		
	}
	private void postaviModelProdajaPoArtiklu(ArrayList lista, JTable t){
		 JTableModelProdajaPoFilijali model = new  JTableModelProdajaPoFilijali(lista);
		t.setModel(model);		
	}
	
	private  void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
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

	private  void popuniComboBoxArtikli(JComboBox<Artikli> comboBox, Integer id_grupe_artikala) {
		

		try {
			comboBox.removeAllItems();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli(id_grupe_artikala);

			// for (GlavnaGrupa gg : lista) {
			for (Artikli a : lista1) {
				comboBox.addItem(a);		

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();

			for (Filijala f : lista) {
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void suma (JTable t) {
		double sum = 0; double sum1 = 0; double sum2 = 0;
		
		for (int i = 0; i < tableIzvestajProdaje.getRowCount(); i++) { 
			sum = sum + Double.parseDouble(tableIzvestajProdaje.getValueAt(i,8).toString());
				
		}
		for (int i1 = 0; i1 < tableIzvestajProdaje.getRowCount(); i1++) {
			sum1 = sum1 + Double.parseDouble(tableIzvestajProdaje.getValueAt(i1,12).toString());
		 		
		 		}
		for (int i2 = 0; i2 < tableIzvestajProdaje.getRowCount(); i2++) {
			sum2 = sum2 + Double.parseDouble(tableIzvestajProdaje.getValueAt(i2,11).toString());
			
			}
				textFieldNabavnaVrenostIzvestajFilijala.setText(Double.toString(sum));
				textFieldRucIzvestajProdajeFiljala.setText(Double.toString(sum2-sum));
				textFieldOsnovicaIzvestajFilijala.setText(Double.toString(sum1));
				txtProdajnavrednostIzvestajProdajeFilijala.setText(Double.toString(sum2)); 
		  }
	}
