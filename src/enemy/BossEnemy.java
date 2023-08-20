package enemy;

import util.Position;

public class BossEnemy extends Enemy {
  private static final double speed = 0.2;

  public BossEnemy(String id, Position position) {
    super(id, position);
  }

  @Override
  public void update() {
    this.position.x += BossEnemy.speed;
  }
}
