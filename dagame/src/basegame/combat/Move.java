package combat;

import entity.Entity;

public abstract class Move{
    Entity mover;
    String name;

    public abstract boolean use(Entity e);
}
