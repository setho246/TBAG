import java.util.ArrayList;

public class Items {
    enum Item {
        BOOK,
        KNIFE,
        CUP,
        PHONE,
        TV
    }
    
    private ArrayList<Item> Holds = new ArrayList<Item>();
    
    /**
     * Adds item to the item array
     */
    public void addItem(Item item) {
        Holds.add(item);
    }
    
    /**
     * If item is currently in array, removes it
     */
    public void removeItem(Item item){
        Holds.remove(item);
    }
    
    /**
     * Removes all items from array
     */
    public void clear() {
        Holds.clear();
    }
    
    /**
     * Returns the item description as a string
     */
    public String getItemDescription(Item item){
        String description = null;
        
        switch (item) {
            case BOOK:
            description = "A book, title reads \"Seth's guide to Java\". Seems interesting";
            break;
            case KNIFE:
            description = "Just a regular old kitchen knife. Could do with a sharpen";
            break;
            case CUP:
            description = "A dirty cup in need of a wash";
            break;
            case PHONE:
            description = "An old fashion rotary phone, things like these belong in museums nowdays";
            break;
            case TV:
            description = "Just a normal TV. Currently showing some stupid reality show";
        }
        
        return description;
    }
    
    /**
     * Returns the Arraylist Size
     */
    public int getListLength() {
        return Holds.size();
    }
    
    /**
     * Returns the Item at a given positon
     */
    public Item getItemAtPosition(int pos) {
        return Holds.get(pos);
    }
    
}