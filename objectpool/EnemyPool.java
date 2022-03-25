package objectpool;

import java.util.ArrayList;
import java.util.Objects;

import enemy.Enemy;

/*
 * Implementation of the ObjectPool pattern,
 * It stores objects of the Enemy type
 * */
public class EnemyPool {
	
	ArrayList<Enemy> pool = new ArrayList<Enemy>();
	int max;
	
	
	public EnemyPool(int max) {
		this.max = max;
		creatPool(max);
		
	}
	
	/*
	 * Method that initializes the pool 
	 * */
	private void creatPool(int poolSize) {
		
		for(int i = 0; i < poolSize; i++) {
			pool.add(new Enemy(10, 1, 0, 0, "Zombie"));
		}
		
	}
	
	/*
	 * Method that delivers pool elements when called 
	 * */
	public Enemy acquire() {
		
		if(!pool.isEmpty()) {
			return pool.remove(0);
		}
		
		return null;
	}
	
	/*
	 * Method that return elements to the pool
	 * */
	public void releasy(Enemy returned) {
		if(pool.size() < max) {
			pool.add(returned);
		}
	}
	
	
	public int getMax() {
		return max;
	}
	
	
	public void setMax(int max) {
		this.max = max;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(max, pool);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnemyPool other = (EnemyPool) obj;
		return max == other.max && Objects.equals(pool, other.pool);
	}
	

	@Override
	public String toString() {
		return "EnemyPool [pool=" + pool + ", max=" + max + "]";
	}
	

}
