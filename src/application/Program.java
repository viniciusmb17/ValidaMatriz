package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		String msg = "";
		int left, right, up, down;
		int count = -1;

		System.out.print("Numero de linhas: ");
		int a = sc.nextInt();
		System.out.printf("Numero de colnas: ");
		int b = sc.nextInt();

		int[][] mat = new int[a][b];

		System.out.println("Preencha a matriz:");
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				mat[x][y] = sc.nextInt();
			}
		}

		System.out.printf("%n%nMatriz:");
		for (int x = 0; x < mat.length; x++) {
			System.out.printf("%n");
			for (int y = 0; y < mat[x].length; y++) {
				System.out.print(mat[x][y] + " ");
			}
		}

		System.out.println(" ");

		for (int linha = 0; linha < mat.length; linha++) {
			for (int col = 0; col < mat[linha].length; col++) {
				for (int linha2 = 0; linha2 < mat.length; linha2++) {
					for (int col2 = 0; col2 < (mat[linha2].length); col2++) {
						if (mat[linha][col] == mat[linha2][col2] && !list.contains(mat[linha][col])) {
							count++;
							System.out.println("--------------------------");
							System.out.println("mat[" + linha2 + "][" + col2 + "]: " + mat[linha2][col2]);
							if (col2 == 0) {
								System.out.println("Não tem numero à esquerda");
							} else {
								left = mat[linha2][col2 - 1];
								System.out.println("Left:" + left);
							}

							if (col2 == mat[linha2].length - 1) {
								System.out.println("Não tem numero à direita");
							} else {
								right = mat[linha2][col2 + 1];
								System.out.println("Right:" + right);
							}

							if (linha2 == 0) {
								System.out.println("Não tem numero em cima");
							} else {
								up = mat[linha2 - 1][col2];
								System.out.println("Up:" + up);
							}

							if (linha2 == mat.length - 1) {
								System.out.println("Não tem numero em baixo");
							} else {
								down = mat[linha2 + 1][col2];
								System.out.println("Down:" + down);
							}
							System.out.println("--------------------------");
						}
					}
				}
				if (count > 0) {
					msg += "Numero ";
					msg += mat[linha][col];
					msg += " repetiu mais ";
					msg += count;
					msg += " vez(es)\n";
					list.add(mat[linha][col]);
				}
				count = -1; // Resetando contador
			}
		}
		System.out.printf(msg);
		sc.close();
	}

}
