import java.util.ArrayList;

public class DulceEstacion {
	private ArrayList<Maquina> maquinas;
	private float ingresos;

	public DulceEstacion() {
		maquinas = new ArrayList<Maquina>();
		ingresos = 0 ;
	}
	
	public void Setmaquinas(ArrayList<Maquina> newmaquinas) {
		this.maquinas = newmaquinas;
	}
	
	public ArrayList<Maquina> Getmaquinas() {
		return maquinas;
	}
	
	public void Setingresos(float newingresos) {
		this.ingresos = newingresos;
	}
	
	public float Getingresos() {
		return ingresos;
	}
	
	public String consultar(int codigo) {
		for(Maquina m:maquinas){
			if (m.Getcodigo()==codigo){
				return m.toString();
			}
		}

		return "No se ha encontrado ninguna maquina con este codigo.";
	}
	
	public boolean validarCodigo(int codigo) {
		for(Maquina m:maquinas){
			if (m.Getcodigo()==codigo){
				return false;}
		}
		return true;
	}
	
	public void confirmarAlquiler(int codigo, int dias) {
		if (validarCodigo(codigo)){
			throw new RuntimeException("La máquina no fue encontrada.");
		}else{
			for(Maquina m:maquinas){
				if (m.Getcodigo()==codigo){
					if (m.Getdisponibilidad()){
						ingresos += m.cotizar(dias);
						m.Setdisponibilidad(false);
					}else{
						throw new RuntimeException("La máquina que desea alquilar NO esta disponible.");
					}
				}
			}
		}

	}
	
	public void regresar(int codigo) {
		if (validarCodigo(codigo)){
			throw new RuntimeException("Maquina no encontrada.");
		}else{
			for(Maquina m:maquinas){
				if (m.Getcodigo()==codigo){
					if(m.Getdisponibilidad()){
						throw new RuntimeException("La máquina no se encontraba rentada.");
					}else{
						m.Setdisponibilidad(true);
					}
				}
			}
		}
	}
	
	public String reporte() {
		String cadena = "---------------------------Reporte---------------------------\n";
		cadena += "Cantidad de máquinas: "+maquinas.size()+"\n\n";

		int dP = 0; int oP=0; int dA = 0; int oA = 0; int dC = 0; int oC=0;
		
		for(Maquina m:maquinas){
			if (m instanceof MaquinaPalomitas){
				if (m.Getdisponibilidad()){dP+=1;}
				else{oP+=1;}
			}
			if (m instanceof MaquinaAlgodon){
				if (m.Getdisponibilidad()){dA+=1;}
				else{oA+=1;}
			}
			if (m instanceof MaquinaChcolate){
				if (m.Getdisponibilidad()){dC+=1;}
				else{oC+=1;}
			}
		}

		cadena += "Maquinas de Palomitas| Disponibles: "+dP+"|Alquiladas: "+oP+"\n";
		cadena += "Maquinas de Algodon de Azucar| Disponibles: "+dA+"|Alquiladas: "+oA+"\n";
		cadena += "Fuentes de Chocolate| Disponibles: "+dC+"|Alquiladas: "+oC+"\n";

		cadena += "\nIngresos: "+String.format("%.2f",ingresos);

		return cadena;
	}
}