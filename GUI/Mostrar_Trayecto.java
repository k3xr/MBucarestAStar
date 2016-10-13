package GUI;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import net.datastructures.ArrayIndexList;


public class Mostrar_Trayecto extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5829936520827710026L;
	private ArrayIndexList<String> recorrido;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar_Trayecto frame = new Mostrar_Trayecto();
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
	public Mostrar_Trayecto(ArrayIndexList<String> recorrido) {
		this.recorrido = recorrido;
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 525);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro Bucarest");
		lblNewLabel.setBounds(76, 11, 181, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 65, 319, 421);
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Trayecto más corto", generarResultados());
		
	}

	private Component generarResultados() {
		JLabel contenedor = new JLabel();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
		
		for(int i = 0; i < this.recorrido.size(); i++){
			JLabel estacion = new JLabel(recorrido.get(i));
			contenedor.add(estacion);
		}
		return contenedor;
	}
}
