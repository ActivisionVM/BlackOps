package zombies;
import javax.swing.*;
import java.awt.*;

public class SimuladorZombisGUI {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("---SIMULADOR PELEAS ZOMBIES---");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Área de texto para mostrar los resultados
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

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
