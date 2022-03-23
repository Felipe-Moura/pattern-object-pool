import java.util.Scanner;

import objectpool.EnemyPool;
import screen.Screen;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Criar um ObjectPool que armazene inimigos
		 * Criar telas que peguem os inimigos do pool e devolva ao final da tela
		 * */
		
		Scanner input = new Scanner(System.in);
		
		EnemyPool pool = new EnemyPool(10);
		
		Screen screen1 = new Screen(3);
		Screen screen2 = new Screen(5);
		
		int control;
		
			
		System.out.println("Menu");
		System.out.println(" - Screen1 (1)");
		System.out.println(" - Screen2 (2)");
		System.out.print("Choose: ");
		control = input.nextInt();
			
		if(control == 1) {
			System.out.printf("\nScreen 1: \n");
			screen1.pullEnemies(pool);
			screen1.setEnemiesPosition();
			screen1.display();
			screen1.resetEnemiesPosition();
			screen1.giveBackEnemies(pool);
		}
		else if(control == 2) {
			System.out.printf("\nScreen 2: \n");
			screen2.pullEnemies(pool);
			screen2.setEnemiesPosition();
			screen2.display();
			screen2.resetEnemiesPosition();
			screen2.giveBackEnemies(pool);
		}
		

	}

}
