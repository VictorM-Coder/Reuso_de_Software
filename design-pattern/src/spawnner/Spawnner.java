package spawnner;

import enemies.Enemy;
import spawnner.factory.EnemyFactory;
import spawnner.factory.GuardFactory;
import spawnner.factory.ZombieFactory;

public final class Spawnner {
    private Spawnner() {}

    public static void spawnEnemies(int total) {
        for (int cont = 1; cont <= total; cont++) {
            Enemy enemy = getRandomEnemy();
            enemy.makeSound();
        }
    }

    private static Enemy getRandomEnemy() {
        EnemyFactory enemyFactory;

        int random = (int) (Math.random()*1000);
        if (random%2==0) {
            enemyFactory = new GuardFactory();
        } else  {
            enemyFactory = new ZombieFactory();
        }

        return enemyFactory.createEnemy();
    }
}
