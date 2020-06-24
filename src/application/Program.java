package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int [][]mat = new int[3][3];
		
		/*System.out.println("------- Simbolos possiveis ----------");
		System.out.println("O");
		System.out.println("X");
		System.out.println("-------------------------------------------------");		
		System.out.println();
		System.out.println("------------Tabuleiro------------");
		System.out.println("___|___|___");
		System.out.println("___|___|___");
		System.out.println("   |   |   ");
		System.out.println("---------------------------------");
		System.out.println();
		System.out.print("Digite o simbolo que o Jogador 1 ira comecar: ");
		String n = sc.next();
		int player = 0;
		
		if(n.equals("X")) {
			player = -1;
		}
		else if(n.equals("O")) {
			player = 1;
		}
		
		if(player == -1) {
			n = "X";
		}
		if(player == 1){
			n = "O";
		}
	
		System.out.println("Simbolo escolhido: " + n);
		player = switchPlayer(player);
		if(player == -1) {
			n = "X";
		}
		if(player == 1){
			n = "O";
		}
		System.out.println("Simbolo do jogador oponente: " + n);*/
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				mat[i][j] = 0;
			}
		}
		int cont = 0;
		while(!theWinner(mat)) {
			printBoard(mat);
			System.out.print("Digite a linha e a coluna desejada: ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.print("Digite o valor do simbolo (1 --> O  -1 --> X): ");
			mat[n][m] = sc.nextInt();
			if(!theWinner(mat) && mat[n][m] != 0) {
				cont ++;
			}
			
			if(cont == 9) {
				System.out.println("VELHA!");
				break;
			}
		}
	
	}	
	
	public static int switchPlayer(int jogador) {
		if(jogador == 1) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public static void printBoard(int [][] mat) {
		for(int i = 0; i < mat.length; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j] == 0) {
					System.out.print(" - ");
				}
				else {
					System.out.print(mat[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.print("   " + 0 + "  " + 1 + "  " + 2);
		System.out.println();
	}
	
	public static boolean theWinner(int [][]mat) {
		String res = "";
		int somaD = mat[0][0] + mat[1][1] + mat[2][2];
		int somaE = mat[0][2] + mat[1][1] + mat[2][0];
		for(int i = 0; i < 3; i++) {
			int soma = 0;
			int soma2 = 0;
			for(int j = 0; j < 3; j++) {
				soma += mat[i][j];
				soma2 += mat[j][i];
			}
			if(soma == -3 || somaD == -3 || somaE == -3 || soma2 == -3) {
				res += "Jogador 1 venceu!";
			}
			else if(soma == 3 || somaD == 3 || somaE == 3 || soma2 == 3){
				res += "Jogador 2 venceu!";
			}
		}	
	
		System.out.println(res);
		return res != "";
	}
	
}	

