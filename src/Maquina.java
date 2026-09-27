public abstract class Maquina {
	protected int codigo;
	protected String marca;
	protected String modelo;
	protected float tarifa;
	protected boolean disponibilidad;

	public Maquina(int codigo, String marca, String modelo, float tarifa, boolean disponibilidad){
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.tarifa = tarifa;
		this.disponibilidad = disponibilidad;
	}
	
	public void Setcodigo(int newcodigo) {
		this.codigo = newcodigo;
	}
	
	public int Getcodigo() {
		return this.codigo;
	}
	
	public void Setmarca(String newmarca) {
		this.marca = newmarca;
	}
	
	public String Getmarca() {
		return this.marca;
	}
	
	public void Setmodelo(String newmodelo) {
		this.modelo = newmodelo;
	}
	
	public String Getmodelo() {
		return this.modelo;
	}
	
	public void Settarifa(float newtarifa) {
		this.tarifa = newtarifa;
	}
	
	public float Gettarifa() {
		return  this.tarifa;
	}
	
	public void Setdisponibilidad(boolean newdisponibilidad) {
		this.disponibilidad = newdisponibilidad;
	}
	
	public boolean Getdisponibilidad() {
		return  this.disponibilidad;
	}
	
	public abstract float cotizar(int dias);
	
	public abstract String toString();
}
