
import java.util.Scanner;



public class Tablero {

	Scanner sc = new Scanner(System.in);
	private final int filasTablero = Constantes.NUMERO_FILAS_COLUMNAS,columnasTablero = Constantes.NUMERO_FILAS_COLUMNAS ;
	private char tablero[][] = new char[filasTablero][columnasTablero];
	private char tableroUsuario[][] = new char[filasTablero][columnasTablero];
	private boolean debug;
	private String numerosVerticales [] = {
			"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
	private int numeros [] = {
				0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	
	public Tablero(boolean debug) {
		this.debug = debug;
		//~ => AGUA
		//x => Barco tocado
		//1/2/3 => Parte del barco
		System.out.println("Dentro");
		for (int i = 0; i < filasTablero; i++) {
			for (int j = 0; j < columnasTablero; j++) {
				tablero[i][j] ='~' ;
				tableroUsuario[i][j]=' ';
			}
		}
		colocaBarcos();
		
	}
	
	public char[][] getMatrizTablero(){
		return this.tablero;
	}
	
	public void setMatrizTableros(char car, int f, int c) {
		tablero[f][c]=car;
		tableroUsuario[f][c] = car;
	}
	
	
	
	public int getFilas() {
		return filasTablero;
	}
	public int getColumnas() {
		return columnasTablero;
	}
	public void imprimeTablero() {
			if(this.debug) {
			System.out.println("Dentro de imprime tablero");
			for (int i = 0; i < numeros.length; i++) {
				if (i + 1 == numeros.length) {
					System.out.print("| " + numeros[i] + " | ");
				} else {
					if(i==0) {
						System.out.print("   | " + numeros[i] + " ");
					}else {
						if(i>=9) {
							System.out.print("| " + numeros[i] + " ");
						}else {
							System.out.print("| " + numeros[i] + " ");
						}
						
					}
					
				}
			}
			
			System.out.println("");
			for (int i = 0; i < filasTablero; i++) {
				for (int j = 0; j < columnasTablero; j++) {
					if(j==0) {
						if(i<=9) {
							System.out.print(numerosVerticales[i]+"  ");
						}else {
							System.out.print(numerosVerticales[i]+" ");
						}
						
					}
					
					if (j + 1 == columnasTablero) {
							System.out.print("| " + tablero[i][j] + "  | ");
					} else {
						if(j>=9) {
							System.out.print("| " + tablero[i][j] + "  ");
						}else {
							System.out.print("| " + tablero[i][j] + " ");
						}
						
					}
				}
				System.out.println(" ");
			}

		}else {
			imprimeTableroUsuario();
		}
		
	}
	
	public void imprimeTableroUsuario() {
		System.out.println("Dentro de imprime tablero");
		for(int i=0;i<numeros.length;i++) {
			if (i + 1 == numeros.length) {
				System.out.print("| " + numeros[i] + " | ");
			} else {
				if(i==0) {
					System.out.print("   | " + numeros[i] + " ");
				}else {
					if(i>=9) {
						System.out.print("| " + numeros[i] + " ");
					}else {
						System.out.print("| " + numeros[i] + " ");
					}
					
				}
				
			}
		}
		System.out.println("");
		for (int i = 0; i < filasTablero; i++) {
			for (int j = 0; j < columnasTablero; j++) {
				if(j==0) {
					if(i<=9) {
						System.out.print(numerosVerticales[i]+"  ");
					}else {
						System.out.print(numerosVerticales[i]+" ");
					}
					
					
				}
				
				if (j + 1 == columnasTablero) {
						System.out.print("| " + tableroUsuario[i][j] + "  | ");
				} else {
					if(j>=9) {
						System.out.print("| " + tableroUsuario[i][j] + "  ");
					}else {
						System.out.print("| " + tableroUsuario[i][j] + " ");
					}
					
				}
			}
			System.out.println(" ");
		}

	}
	
	public void colocaBarcos() {
			//TODO: Crear tres bucles para colocar barcos
		for(int i=0;i<=Constantes.NUMERO_BARCOS_TRES_CASILLAS;i++) {
			colocaBarco('1',3); //Barcos en forma de unos
		}
		for(int i=0;i<=Constantes.NUMERO_BARCOS_DOS_CASILLAS;i++) {
			colocaBarco('2',2); //Barcos en forma de doses
		}		
		for(int i=0;i<=Constantes.NUMERO_BARCOS_UNA_CASILLA;i++) {
			colocaBarco('3',1); //Barcos en forma de treses
		}		
			
	}
		
	public void colocaBarco(char tipoRepresentacion,int longitudBarco) {
		int filaBarco,columnaBarco; 
		int orientacion = (int)(Math.random()*2); //1 Vertical, 0 Horizontal 
		do {
			filaBarco = (int)(Math.random()*filasTablero);
			columnaBarco = (int)(Math.random()*columnasTablero);
		}while(posicionInvalida(filaBarco,columnaBarco,orientacion,longitudBarco));
		
		char barcoPosiciones [] = new char [longitudBarco];
		
		for(int i = 0;i<barcoPosiciones.length;i++) {
			barcoPosiciones[i]=tipoRepresentacion;
		}
		for(int i = 0 ; i<barcoPosiciones.length;i++) {
			if(orientacion==0) {
				tablero[filaBarco][columnaBarco] = barcoPosiciones[i];
				columnaBarco++;		
			}else {
				tablero[filaBarco][columnaBarco] = barcoPosiciones[i];
				filaBarco++;	
			}
		}
			
	}

	//1 Vertical, 0 Horizontal 
	private boolean posicionInvalida(int fila,int columna,int orientacion,int longitudBarco) {
		if(tablero[fila][columna]=='1' || tablero[fila][columna]=='2' || tablero[fila][columna]=='3') {
			return true;
		}else if(orientacion==1){
			for(int i=1;i<longitudBarco;i++) {
				if((fila+i)<filasTablero) { //Comprueba todas las posibles posiciones del barco en vertical
					if(tablero[fila+i][columna]=='1' || tablero[fila+i][columna]=='2' || tablero[fila+i][columna]=='3') {
						return true;
					}
				}else {
					return true;
				}
			}
		}else if(orientacion==0){
			for(int i=1;i<longitudBarco;i++) {
				if((columna+i)<columnasTablero) {//Comprueba todas las posibles posiciones del barco en horizontal
					if(tablero[fila][columna+i]=='1' || tablero[fila][columna+i]=='2' || tablero[fila][columna+i]=='3') {
						return true;
					}
				}else {
					return true;
				}
				
			}	
		}else {
			return false;
		}
		return false;
	}
}
	


