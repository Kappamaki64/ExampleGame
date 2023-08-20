import util.Position;

public class Enemy {
  public final String id;
  public final Position position;

  private static final double speed = 0.4;

  public Enemy(String id, Position position) {
    this.id = id;
    this.position = position;
  }

  public void update() {
    this.position.x += Enemy.speed;
  }
}
