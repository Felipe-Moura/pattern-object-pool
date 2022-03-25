package screen;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import enemy.Enemy;
import objectpool.EnemyPool;

/*
 * Class created to simulate the creation of a screen from a game project
 * */
public class Screen {
	
	int numberOfEnemies;
	ArrayList<Enemy> screenEnemies = new ArrayList<Enemy>();
	
	public Screen(int numberOfEnemies) {
		this.numberOfEnemies = numberOfEnemies;
	}
	
	/*
	 * Method that pick the elements of the pool
	 * */
	public void pullEnemies(EnemyPool pool) {
		for(int i = 0; i < numberOfEnemies; i++) {
			screenEnemies.add(pool.acquire());
		}
	}
	
	/*
	 * Method that returns the elements to the pool
	 * */
	public void giveBackEnemies(EnemyPool pool) {
		for(int i = 0; i < numberOfEnemies; i++) {
			pool.releasy(screenEnemies.remove(0));
		}
	}
	
	/*
	 * Method that randomizes the position of the enemies in the screen
	 * */
	public void setEnemiesPosition() {
		Random rnd = new Random();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			screenEnemies.get(i).setPositionX(rnd.nextInt(100));
			screenEnemies.get(i).setPositionY(rnd.nextInt(100));
		}
		
	}
	
	/*
	 * Method that sets the positions of the enemies to (0, 0)
	 * */
	public void resetEnemiesPosition() {
		Random rnd = new Random();
		
		for(int i = 0; i < numberOfEnemies; i++) {
			screenEnemies.get(i).setPositionX(0);
			screenEnemies.get(i).setPositionY(0);
		}
		
	}
	
	/*
	 * Method that show the enemies on the screen
	 * */
	public void display() {
		for(int i = 0; i < numberOfEnemies; i++) {
			System.out.println("Enemy "+ i + " position: x = " + screenEnemies.get(i).getPositionX() + " y = " + screenEnemies.get(i).getPositionY());
		}
	}
	

	public int getNumberOfEnemies() {
		return numberOfEnemies;
	}
	

	public void setNumberOfEnemies(int numberOfEnemies) {
		this.numberOfEnemies = numberOfEnemies;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(numberOfEnemies, screenEnemies);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return numberOfEnemies == other.numberOfEnemies && Objects.equals(screenEnemies, other.screenEnemies);
	}
	

	@Override
	public String toString() {
		return "Screen [numberOfEnemies=" + numberOfEnemies + ", screenEnemies=" + screenEnemies + "]";
	}
	

}
