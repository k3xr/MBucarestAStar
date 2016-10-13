package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

import Algoritmo.IniciarMetroBucharest;
import Metro.Estacion;


public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7472737679558981928L;
	private IniciarMetroBucharest llamante;
	private JPanel contentPane;
	private final Action action = new SwingAction(this);

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro Bucarest");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(76, 31, 181, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblEstacinOrigen = new JLabel("Estaci\u00F3n Origen");
		lblEstacinOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstacinOrigen.setBounds(113, 101, 111, 20);
		contentPane.add(lblEstacinOrigen);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M1 - Republica", "M1 - Costin Georgian", "M1 - Titan", "M1 - Nicolae Grigorescu", "M1 - Dristor2", "M1 - Mihai Bravu", "M1 - Timpuri Noi", "M1 - Piata Unirii", "M1 - Izvor", "M1 - Eroilor", "M1 - Grozavesti", "M1 - Semanatoarea", "M1 - Crangasi", "M1 - Basarab", "M1 - Gara de Nord", "M1 - Piata Vitorie", "M1 - Stefan cel Mare", "M1 - Obor", "M1 - Iancului", "M1 - Piata Muncii", "M1 - Dristor1", "M2 - Pipera", "M2 - Aurel Vlaicu", "M2 - Aviatorilor", "M2 - Piata Victoriei", "M2 - Piata Romana", "M2 - Universitatii", "M2 - Piata Unirii", "M2 - Tineretului", "M2 - Eroii Revolutiei", "M2 - Constantin Brancoveanu", "M2 - Piata Sudului", "M2 - Aparatorii Patriei", "M2 - IMGB", "M2 - Depou IMGB", "M3 - Industriilor", "M3 - Pacii", "M3 - Gorjului", "M3 - Armata Poporului", "M3 - Politehnia", "M3 - Eroilor", "M4 - 1 Mai", "M4 - Gravita", "M4 - Basarab", "M4 - Gara de Nord"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(76, 132, 181, 20);
		contentPane.add(comboBox);
		
		JLabel lblEstacinDestino = new JLabel("Estaci\u00F3n Destino");
		lblEstacinDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstacinDestino.setBounds(113, 202, 111, 20);
		contentPane.add(lblEstacinDestino);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"M1 - Republica", "M1 - Costin Georgian", "M1 - Titan", "M1 - Nicolae Grigorescu", "M1 - Dristor2", "M1 - Mihai Bravu", "M1 - Timpuri Noi", "M1 - Piata Unirii", "M1 - Izvor", "M1 - Eroilor", "M1 - Grozavesti", "M1 - Semanatoarea", "M1 - Crangasi", "M1 - Basarab", "M1 - Gara de Nord", "M1 - Piata Vitorie", "M1 - Stefan cel Mare", "M1 - Obor", "M1 - Iancului", "M1 - Piata Muncii", "M1 - Dristor1", "M2 - Pipera", "M2 - Aurel Vlaicu", "M2 - Aviatorilor", "M2 - Piata Victoriei", "M2 - Piata Romana", "M2 - Universitatii", "M2 - Piata Unirii", "M2 - Tineretului", "M2 - Eroii Revolutiei", "M2 - Constantin Brancoveanu", "M2 - Piata Sudului", "M2 - Aparatorii Patriei", "M2 - IMGB", "M2 - Depou IMGB", "M3 - Industriilor", "M3 - Pacii", "M3 - Gorjului", "M3 - Armata Poporului", "M3 - Politehnia", "M3 - Eroilor", "M4 - 1 Mai", "M4 - Gravita", "M4 - Basarab", "M4 - Gara de Nord"}));
		comboBox_1.setBounds(76, 236, 181, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Calcular Trayecto");
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(76, 376, 181, 36);
		contentPane.add(btnNewButton);
	}
	
	

	public IniciarMetroBucharest getLlamante() {
		return llamante;
	}

	public void setLlamante(IniciarMetroBucharest llamante) {
		this.llamante = llamante;
	}



	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7938210264264697165L;
		private JFrame contenedor;
		public SwingAction(JFrame contenedor) {
			putValue(NAME, "Calcular Trayecto");
			putValue(SHORT_DESCRIPTION, "Pantalla principal de la aplicación.");
			this.contenedor = contenedor;
		}
		public void actionPerformed(ActionEvent e) {
			/* Obtener los combo box donde el usuario elige las estaciones */
			JComboBox estacionOrigen = (JComboBox) this.contenedor.getContentPane().getComponentAt(76, 132);
			JComboBox estacionDestino = (JComboBox) this.contenedor.getContentPane().getComponentAt(76, 236);
			/*+++*/
			//System.out.println(estacionOrigen.getSelectedItem().toString());
			//System.out.println(estacionDestino.getSelectedItem().toString());
			Principal pantallaPrincipal = (Principal) this.contenedor; //Obtener la pantalla principal
			IniciarMetroBucharest llamante = pantallaPrincipal.getLlamante(); //Obtener la clase llamante
			//Buscar el objeto estación que se corresponde a la que selecciona el usuario y prepararla para el algoritmo
			Estacion origen = llamante.buscarEstacion(estacionOrigen.getSelectedItem().toString());
			llamante.setOrigen(origen);
			Estacion destino = llamante.buscarEstacion(estacionDestino.getSelectedItem().toString());
			llamante.setDestino(destino);
			llamante.hayDatos.release();
			
			this.contenedor.dispose(); //Cerrar la ventana
		}
	}
}
