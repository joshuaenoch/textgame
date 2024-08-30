public abstract class Move{
    Entity mover;
    String name;

    public abstract <T> T use(Entity e);
}
