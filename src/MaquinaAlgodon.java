
public class MaquinaAlgodon extends Maquina {
	private int potencia;
	
	public MaquinaAlgodon(int codigo, String marca, String modelo, int potencia) {
		super(codigo,marca,modelo,150,true); //VER TARIFA
		this.potencia = potencia;
	}
	
	public void Setpotencia(int newpotencia) {
		this.potencia = newpotencia;
	}
	
	public int Getpotencia() {
		return this.potencia;
	
	}
	
	public float cotizar(int dias) {
		float costo= tarifa*dias;
		if(potencia>1000){
			costo += 60;} 
		return costo;
	}
	
	public String toString() {
		String cadena = "";
		cadena = "Codigo: "+codigo+" |Tipo: Maquina de Algodon |Marca: "+marca+" |Modelo: "+modelo+" |Tarifa: "+String.format("%.2f",tarifa)+" |Disponibilidad: ";
		if(disponibilidad){
			cadena += "Si";
		}else{cadena+="No";}
		cadena+=" |Potencia: "+potencia+" vatios";
		return cadena;
	}
}
