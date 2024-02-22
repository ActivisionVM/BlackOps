package zombies;
import java.util.Scanner;

public class SimuladorZombis {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);

		System.out.println("---SIMULADOR PELEAS ZOMBIES---");
	
		      
		        
		        System.out.println("\nElige el tipo de zombi para el Jugador 1:");
		        System.out.println("1. ZombiCaminante");
		        System.out.println("2. ZombiCorredor");
		        System.out.println("3. ZombiSaltarin");

		        System.out.print("Selecciona el número del zombi: ");
		        int eleccion1 = sc.nextInt();

		        Zombi zombi1 = crearZombi(eleccion1);

		        System.out.println("Elige el tipo de zombi para el Jugador 2:");
		        System.out.println("1. ZombiCaminante");
		        System.out.println("2. ZombiCorredor");
		        System.out.println("3. ZombiSaltarin");

		        System.out.print("Selecciona el número del zombi: ");
		        int eleccion2 = sc.nextInt();

		        Zombi zombi2 = crearZombi(eleccion2);

		        // Bucle de combate (igual que antes)
		        while (zombi1.estaVivo() && zombi2.estaVivo()) {
		            zombi1.atacar(zombi2);
		            if (zombi2.estaVivo()) {
		                zombi2.atacar(zombi1);
		            }

		            System.out.println("Zombi 1 vida: " + zombi1.getVida());
		            System.out.println("Zombi 2 vida: " + zombi2.getVida());
		        }

		        // Determinar el ganador (igual que antes)
		        if (zombi1.estaVivo()) {
		            System.out.println("Zombi 1 gana la pelea!");
		        } else if (zombi2.estaVivo()) {
		            System.out.println("Zombi 2 gana la pelea!");
		        } else {
		            System.out.println("Ambos zombis han caído en combate.");
		        }

		        sc.close();
		    }

		    private static Zombi crearZombi(int eleccion) {
		        switch (eleccion) {
		            case 1:
		                return new ZombiCaminante();
		            case 2:
		                return new ZombiCorredor();
		            case 3:
		                return new ZombiSaltarin();
		            default:
		                System.out.println("Selección no válida. Creando Zombi Equilibrado por defecto.");
		                return new ZombiCaminante();
		        }
		    }
		
	}


