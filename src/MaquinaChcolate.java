public class MaquinaChcolate extends Maquina {
	private float capacidad;

	public MaquinaChcolate(int codigo, String marca, String modelo, float capacidad) {
		super(codigo,marca,modelo,100,true); //VER TARIFA
		this.capacidad = capacidad;
	}
	
	public void Setcapacidad(float newcapacidad) {
		this.capacidad = newcapacidad;
	}
	
	public float Getcapacidad() {
		return this.capacidad;
	}
	
	public float cotizar(int dias) {
		float costo= tarifa*dias+20*capacidad*dias;
		return costo;
	}
	
	public String toString() {
	String cadena = "";
		cadena = "Codigo: "+codigo+" |Tipo: Fuente de Chocholate |Marca: "+marca+" |Modelo: "+modelo+" |Tarifa: "+String.format("%.2f",tarifa)+" |Disponibilidad: ";
		if(disponibilidad){
			cadena += "Si";
		}else{cadena+="No";}
		cadena+=" |Capacidad: "+capacidad+" kilogramos";
		return cadena;
	}
}
