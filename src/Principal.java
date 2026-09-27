import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		DulceEstacion sistema = new DulceEstacion();
		Scanner teclado = new Scanner(System.in);

		//Ingreso de las 6 maquinas para comenzar
		System.out.println("\n--------------Bienvenido al sistema de Dulce Estación--------------");
		sistema.Getmaquinas().add(new MaquinaPalomitas(1,"SuperPalomitas","P300",5,false));
		sistema.Getmaquinas().add(new MaquinaPalomitas(2,"SuperPalomitas","3500",10,true));
		sistema.Getmaquinas().add(new MaquinaAlgodon(3,"MaquinasPayaso","A1000",500));
		sistema.Getmaquinas().add(new MaquinaAlgodon(4,"MaquinasPayaso","A5000",1200));
		sistema.Getmaquinas().add(new MaquinaChcolate(5,"ChocoFuentes","C100",2.5f));
		sistema.Getmaquinas().add(new MaquinaChcolate(6,"ChocoFuentes","C700",10));

		//MENU
		boolean adentro = true;

		try{
		while (adentro){
			System.out.println("\n--------------------Menu--------------------");
			System.out.println("1. Registrar máquina\n2. Consultar inventario\n3. Consultar una maquina\n4. Cotizar una maquina\n5. Alquilar\n6. Registrar devolución\n7. Reporte\n8. Salir");
			System.out.println("----------------------------------------------");
			boolean error = true;
			int n = 0;
			while (error){
				try{
					System.out.println("Ingrese la opcion que desea:");
					n = teclado.nextInt();teclado.nextLine();
					if(n>8||n<0){
						System.out.println("Debe ingresar un dato numérico (de 1 a 8).");
						error = true;
					}else{error = false;}
				}catch(Exception e){
					teclado.nextLine();
					System.out.println("Debe ingresar un dato numérico (de 1 a 8).");
					error = true;
				}
			}

			System.out.println("----------------------------------------------");
			switch (n) {
				case 1:
					try{ 
						System.out.println("Ingrese el tipo de máquina: \n1.Máquina de palomitas\n2.Maquina de Algodon de Azucar\n3.Fuente de chocolate");
						int op = teclado.nextInt(); teclado.nextLine();
						System.out.print("Ingrese el código de inventario de la máquina: ");
						int cod = teclado.nextInt(); teclado.nextLine();
						if (sistema.validarCodigo(cod)==false){System.out.println("El codigo ingresado ya existe, debe cambiarlo.");throw new RuntimeException();}
						System.out.print("Ingrese la marca: ");
						String marca = teclado.nextLine();
						System.out.print("Ingrese el modelo: ");
						String modelo = teclado.nextLine();
						Maquina m;

						switch (op){
							case 1:
								System.out.print("Ingrese la cantidad de porciones por hora: ");
								int ph = teclado.nextInt(); teclado.nextLine();
								System.out.print("¿La maquina tiene carrito? (1.Si / 2.No) ");
								int c = teclado.nextInt(); teclado.nextLine();
								boolean carro = false;
								
								if(c==1){carro=true;}
								else{
								if(c==2){carro=false;}
								else{throw new RuntimeException();}
								}
								
								m = new MaquinaPalomitas(cod, marca, modelo, ph, carro);
								
								break;
							case 2:
								System.out.print("Ingrese la potencia en Vatios: ");
								int p = teclado.nextInt(); teclado.nextLine();
								m = new MaquinaAlgodon(cod, marca, modelo, p);
								break;
							case 3:
								System.out.print("Ingrese la capacidad en kilogramos: ");
								float cap = teclado.nextFloat(); teclado.nextLine();
								m = new MaquinaChcolate(cod, marca, modelo, cap);
								break;
							default:
								throw new RuntimeException();
						}
						sistema.Getmaquinas().add(m);
						System.out.println("La maquina ha sido registrada en el invertario.\n");
					} catch (Exception e) {
						System.out.println("Ha ocurrido un error. Ingreso un dato en un formado no aceptado. Vuelva a registrar la maquina.");
					}
					break;
				
				case 2:
					System.out.println("Inventario");
					System.out.println("--------------------------------");
					for(Maquina m:sistema.Getmaquinas()){
						System.out.println(m.toString());
					}
					break;

				case 3://Consulta inventario
					int co=0;
					try {
						System.out.print("Ingrese el código de la máquina que desea consultar: ");
						co = teclado.nextInt(); teclado.nextLine();
					} catch (Exception e) {
						System.out.println("Ha ingresado el dato erroneamente");
					}

					System.out.println(sistema.consultar(co));
					
					break;
				
				case 4: //Cotización
					int cod=0; int d=0; boolean datos=false;
					while(datos==false){
					try{
						System.out.print("Ingrese el código de la máquina que desea cotizar: ");
						cod = teclado.nextInt(); teclado.nextLine();
						System.out.print("Ingrese la cantidad de días que desea cotizar: ");
						d = teclado.nextInt(); teclado.nextLine();
						if(d<=0){throw new RuntimeException();}
						datos= true;
					} catch (Exception e) {
						System.out.println("Ha ingresado un dato de manera erronea");
					}
					}
					
					try {
						boolean e = false;
						for(Maquina m:sistema.Getmaquinas()){
							if(m.Getcodigo()==cod){
								e = true;
								System.out.println(m.toString());
								System.out.println("El precio seria de: Q"+String.format("%.2f",m.cotizar(d)));
							}
						}
						if (e==false){System.out.println("No se encontró la maquina a cotizar.");}
					} catch (Exception e) {
						System.out.println("No se encontró la maquina a cotizar.");
					}
					break;

				case 5: //Alquiler
					int codigoA=0; int dias=0; boolean da=false;
					while(da==false){
					try{
						System.out.print("Ingrese el código de la máquina que desea alquilar: ");
						codigoA = teclado.nextInt(); teclado.nextLine();
						System.out.print("Ingrese la cantidad de días que desea hacer el alquiler: ");
						dias = teclado.nextInt(); teclado.nextLine();
						if(dias<=0){throw new RuntimeException();}
						da=true;
					} catch (Exception e) {
						System.out.println("Ha ingresado un dato de manera erronea");
					}}

					try{
						boolean r = false;
						boolean encontrado=false;
						for(Maquina m:sistema.Getmaquinas()){
							if(m.Getcodigo()==codigoA){
								encontrado=true;
								while(r==false){
									int c=0;
									System.out.println(m.toString());
									System.out.println("La cotización del alquiler es: "+String.format("%.2f",m.cotizar(dias)));
									System.out.println("¿Desea confirmar el alquiler? (1.Si / 2.No)");
									try{
										c = teclado.nextInt(); teclado.nextLine();
									}catch(Exception e){
										System.out.println("Ha ingresado el dato erroneamente.");
										teclado.nextLine();
									}
									if(c==1){
										sistema.confirmarAlquiler(codigoA, dias); r=true;
										System.out.println("Se ha registrado el alquiler.");
									}else{
										if(c==2){System.out.println("Alquiler cancelado."); r=true;}
										else{System.out.println("La opción ingresada no es aceptada. Vuelva a intentarlo.");}
									}
								}
							}
						}
						if(encontrado==false){System.out.println("La maquina no fue encontrada.");}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;

				case 6: //Devolucion
					int codigo=0;
					try {
						System.out.print("Ingrese el código de la máquina que desea devolver: ");
						codigo = teclado.nextInt(); teclado.nextLine();
					} catch (Exception e) {
						System.out.println("Ha ingresado el dato erroneamente");
					}

					try {
						sistema.regresar(codigo);
						System.out.println("Devolucion registrada con exito.");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				
				case 7: //Reporte
					System.out.println(sistema.reporte());
					break;
				
				case 8:
					adentro = false;
					System.out.println("¡Adios!");
					break;

				default:
					break;
			}
		}
		}catch (Exception e) {
			System.out.println("Ha ocurrido un error.");
		}
	}
}
