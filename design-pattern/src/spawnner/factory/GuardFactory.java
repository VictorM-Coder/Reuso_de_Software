package spawnner.factory;

import enemies.Enemy;
import enemies.Guard;

public class GuardFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new Guard();
    }
}
