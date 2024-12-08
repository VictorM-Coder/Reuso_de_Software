package spawnner.factory;

import enemies.Enemy;
import enemies.Zombie;

public class ZombieFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new Zombie();
    }
}
