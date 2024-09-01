package basegame.combat;

import basegame.entity.Entity;

public abstract class Move{
    Entity mover;
    String name;

    public abstract boolean use(Entity e);

    public String toString(){
        return name;
    }
}
