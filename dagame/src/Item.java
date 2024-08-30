public abstract class Item {
    Player owner;
    String name;

    public void use(){
        int itemValue = owner.inventory.get(name);
        owner.inventory.put(name, itemValue-1);
    }
}
