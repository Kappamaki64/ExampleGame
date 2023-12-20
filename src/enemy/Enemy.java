package enemy;

import util.Direction;
import util.Position;

public class Enemy {
  public final String id;
  public final Position position;
  public final Direction direction;

  private static final double speed = 0.4;

  public Enemy(String id, Position position, Direction direction) {
    this.id = id;
    this.position = position;
    this.direction = direction;
  }

  public void update() {
    this.position.x += Enemy.speed;
  }
}
