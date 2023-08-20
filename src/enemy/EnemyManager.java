package enemy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import util.Position;
import util.Utils;

public class EnemyManager {
  private final Map<String, Enemy> enemyMap;
  private final double width, height;
  private int level = 0;

  public EnemyManager(double width, double height) {
    this.enemyMap = new HashMap<>();
    this.width = width;
    this.height = height;
  }

  public Collection<Enemy> getEnemies() {
    return enemyMap.values();
  }

  public Enemy addEnemy(Position position) {
    String id = Utils.createNewId();
    if (position == null) {
      position = Utils.createRandomPosition(width, height);
    }
    return enemyMap.put(id, new Enemy(id, position));
  }

  public Enemy removeEnemy(String id) {
    return enemyMap.remove(id);
  }

  public void update(Optional<Predicate<Enemy>> filter, int newLevel) {
    Collection<Enemy> enemiesToUpdate = enemyMap.values();
    if (filter.isPresent()) {
      enemiesToUpdate = enemyMap.values().stream().filter(filter.get())
          .collect(Collectors.toList());
    }
    enemiesToUpdate.forEach((enemy) -> enemy.update());

    if (level == newLevel)
      return;
    level = newLevel;

    int sizeX = 1;
    for (int i = 1; i < Math.sqrt(newLevel); i++) {
      if (newLevel % i == 0)
        sizeX = i;
    }
    int sizeY = newLevel / sizeX;
    for (int i = 0; i < newLevel; i++) {
      int countX = i / sizeX;
      int countY = i % sizeX;
      double x = (width / 2) / sizeX * countX;
      double y = height / sizeY * countY;
      addEnemy(new Position(x, y));
    }
  }
}
