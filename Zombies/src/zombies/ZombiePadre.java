package zombies;

	public class ZombiePadre {
		//Atributos 
	  	private int vida;
	    private int velocidad;

	    // Constructor
	    public ZombiePadre(int vida, int velocidad) {
	        this.vida = vida;
	        this.velocidad = velocidad;
	    }

	    // Métodos getters para vida y velocidad
	    public int getVida() {
	        return vida;
	    }

	    public int getVelocidad() {
	        return velocidad;
	    }

	    // Método para atacar a otro zombi
	    public void atacar(ZombiePadre otroZombi) {
	        // Supongamos que el daño es proporcional a la velocidad del zombi atacante
	        int daño = this.velocidad;
	        otroZombi.recibirdaño(daño);
	    }

	    // Método para recibir daño
	    public void recibirdaño(int daño) {
	        this.vida -= daño;
	    }

	    // Método para verificar si el zombi está vivo
	    public boolean estaVivo() {
	        return this.vida > 0;
	    }
}


