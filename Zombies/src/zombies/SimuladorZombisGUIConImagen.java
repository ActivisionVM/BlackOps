package zombies;
import javax.swing.*;
import java.awt.*;

public class SimuladorZombisGUIConImagen {

	public static void main(String[] args) {
		// Crear la ventana
		JFrame frame = new JFrame("---SIMULADOR PELEAS ZOMBIES---");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400); // Ajusta el tamaño si es necesario para tu imagen

		// Panel principal
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// Área de texto para mostrar los resultados
		JTextArea textArea = new JTextArea(10, 40);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);

		// Cargar la imagen
		ImageIcon imageIcon = new ImageIcon("/img/pikachu.png"); // Asegúrate de que la ruta sea correcta
		JLabel imageLabel = new JLabel(imageIcon);

		// Ajustar tamaño de la imagen (opcional)
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		imageLabel.setIcon(imageIcon);

		// Añadir la imagen al panel
		panel.add(imageLabel);

		// Añadir el panel a la ventana
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		// Mostrar la ventana
		frame.setVisible(true);

		// Mostrar la ventana
		frame.setVisible(true);

		// Simulación
		int eleccion1 = JOptionPane.showOptionDialog(frame, "Elige el tipo de zombi para el Jugador 1:",
				"Selección de Zombi 1", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new String[]{"ZombiCaminante", "ZombiCorredor", "ZombiSaltarin", "ZombiTanque"}, "ZombiCaminante") + 1;

		Zombi zombi1 = crearZombi(eleccion1);

		int eleccion2 = JOptionPane.showOptionDialog(frame, "Elige el tipo de zombi para el Jugador 2:",
				"Selección de Zombi 2", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new String[]{"ZombiCaminante", "ZombiCorredor", "ZombiSaltarin", "ZombiTanque"}, "ZombiCaminante") + 1;

		Zombi zombi2 = crearZombi(eleccion2);

		// Bucle de combate
		while (zombi1.estaVivo() && zombi2.estaVivo()) {
			zombi1.atacar(zombi2);
			if (zombi2.estaVivo()) {
				zombi2.atacar(zombi1);
			}

			textArea.append("Zombi 1 vida: " + zombi1.getVida() + "\n");
			textArea.append("Zombi 2 vida: " + zombi2.getVida() + "\n");
		}

		// Determinar el ganador
		if (zombi1.estaVivo()) {
			JOptionPane.showMessageDialog(frame, "Zombi 1 gana la pelea!");
		} else if (zombi2.estaVivo()) {
			JOptionPane.showMessageDialog(frame, "Zombi 2 gana la pelea!");
		} else {
			JOptionPane.showMessageDialog(frame, "Ambos zombis han caído en combate.");
		}
	}

	private static Zombi crearZombi(int eleccion) {
		switch (eleccion) {
		case 1:
			return new ZombiCaminante();
		case 2:
			return new ZombiCorredor();
		case 3:
			return new ZombiSaltarin();
		case 4:
			return new ZombiTanque();
		default:
			JOptionPane.showMessageDialog(null, "Selección no válida. Creando Zombi Equilibrado por defecto.");
			return new ZombiCaminante();
		}
	}


}
