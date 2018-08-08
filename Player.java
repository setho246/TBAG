public class Player {
    
    private String name;
    private int age;
    private Items inventory = new Items();
    
    /**
     * Constructor of Player
     * 
     * @param name Name of character
     * @param age Age of character
     */
    public Player (String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Adds the item to player inventory
     * 
     * @param itemToPickUp Item to add to inventory
     */
    public void pickItemUp(Items.Item itemToPickUp) {
        inventory.addItem(itemToPickUp);
    }
    
    /**
     * Removes item from inventory
     * 
     * @param itemToPutDown Item to remove
     */
    public void putItemDown(Items.Item itemToPutDown) {
        inventory.removeItem(itemToPutDown);
    }
    
    /**
     * Returns the player inventory
     * 
     * @return The player inventory
     */
    public Items getInventory() {
        return inventory;
    }
    
    
}