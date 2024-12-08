package spawnner.factory;

import enemies.Enemy;

public abstract interface EnemyFactory {
    public abstract Enemy createEnemy();
}
