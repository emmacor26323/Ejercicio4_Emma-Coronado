public class MaquinaPalomitas extends Maquina {
	private int porciones;
	private boolean carrito;

	public MaquinaPalomitas(int codigo, String marca, String modelo, int porciones, boolean carrito) {
		super(codigo,marca,modelo,150,true); //VER TARIFA
		this.porciones = porciones;
		this.carrito = carrito; 
	}

	public void Setporciones(int newporciones) {
		this.porciones = newporciones;
	}
	
	public float Getporciones() {
		return this.porciones;
	}

	public void Setcarrito(boolean newcarrito) {
		this.carrito = newcarrito;
	}
	
	public boolean Getcarrito() {
		return this.carrito;
	}
	
	public float cotizar(int dias) {
		float costo= tarifa*dias;
		if(carrito){
			costo +=40*dias;} 
		return costo;
	}
	
	public String toString() {
		String cadena = "";
		cadena = "Codigo: "+codigo+" |Tipo: Maquina de Palomitas |Marca: "+marca+" |Modelo: "+modelo+" |Tarifa: "+String.format("%.2f",tarifa)+" |Disponibilidad: ";
			if(disponibilidad){
				cadena += "Si";
			}else{cadena+="No";}
			cadena+=" |Porciones por hora: "+porciones;
			if(carrito){
				cadena+=" |Con carrito";}
			else{cadena+=" |Sin carrito";
			}
	return cadena;
	}
}
