package enemy;

import java.util.Objects;

/*
 * Class created to simulate an enemy of a game project
 * */
public class Enemy {

	int life;
	int damage;
	int positionX, positionY;
	String   sprite;
	
	public Enemy(int life, int damage, int positionX, int positionY, String sprite) {
		this.life = life;
		this.damage = damage;
		this.positionX = positionX;
		this.positionY = positionY;
		this.sprite = sprite;
	}
	
	public String atack() {
		return "The enemy atacked";
	}
	
	public void receiveDamage( int damage) {
		this.life = this.life - damage;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(damage, life, positionX, positionY, sprite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enemy other = (Enemy) obj;
		return damage == other.damage && life == other.life && positionX == other.positionX
				&& positionY == other.positionY && Objects.equals(sprite, other.sprite);
	}

	@Override
	public String toString() {
		return "Enemy [life=" + life + ", damage=" + damage + ", positionX=" + positionX + ", positionY=" + positionY
				+ ", sprite=" + sprite + "]";
	}
	
}
