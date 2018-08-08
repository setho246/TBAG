public class Places {

    enum roomType {
        BEDROOM, LOUNGE, KITCHEN
    }

    private String name;    //Contains the name of the room
    private Items holds;    //Conatins all items in the room
    private roomType[] connecting;  //Contains a list of all rooms that this room connects to
    private String description; //Conatins the room Description
    private roomType type;

    /**
     * Constructor method for places, take in an enum
     * 
     * @param type Enum used for room setup
     */
    public Places(roomType type) {
        this.type = type;
        name = nameSetup(type);
        holds = roomSetup(type);
        connecting = connectionSetup(type);
        description = descriptionSetup(type);
    }

    /**
     * Sets the value of name depending on what room type is passed in
     * 
     * @param type Enum used for name determination
     * @return Name of room
     */
    private String nameSetup(roomType type) {
        String tempName = null;

        switch (type) {
        case LOUNGE:
            tempName = "Lounge Room";
            break;
        case KITCHEN:
            tempName = "Kitchen";
            break;
        case BEDROOM:
            tempName = "Bedroom";
            break;
        }

        return tempName;
    }

    /**
     * Sets the contents of room depending on what room type is passed in
     * 
     * @param type Enum used for name determination
     * @return Arraylist of items in room
     */
    private Items roomSetup(roomType type) {
        Items tempHolds = new Items();

        switch (type) {
        case LOUNGE:
            tempHolds.addItem(Items.Item.TV);
            tempHolds.addItem(Items.Item.PHONE);
            break;
        case KITCHEN:
            tempHolds.addItem(Items.Item.KNIFE);
            tempHolds.addItem(Items.Item.CUP);
            break;
        case BEDROOM:
            tempHolds.addItem(Items.Item.BOOK);
            break;
        }
        return tempHolds;
    }

    /**
     * Sets list of connected rooms depending on what room type is passed in
     * 
     * @param type Enum used for name determination
     * @return roomType array containing all connected rooms
     */
    private roomType[] connectionSetup(roomType type) {
        roomType[] tempConnections;

        switch (type) {
        case LOUNGE:
            tempConnections = new roomType[] { roomType.KITCHEN, roomType.BEDROOM };
            break;
        case BEDROOM:
            tempConnections = new roomType[] { roomType.LOUNGE };
            break;
        case KITCHEN:
        default:
            tempConnections = new roomType[] { roomType.LOUNGE };
            break;
        }
        return tempConnections;
    }

    /**
     * Sets the value of name depending on what room type is passed in
     * 
     * @param type Enum used for name determination
     * @return Description of room
     */
    private String descriptionSetup(roomType type) {
        String tempDescription = null;

        switch (type) {
        case BEDROOM:
            tempDescription = "A fairly clean Bedroom";
            break;
        case LOUNGE:
            tempDescription = "A small lounge room. Has an uncomfortable couch.";
            break;
        case KITCHEN:
            tempDescription = "A small yet well equiped kitchen";
            break;
        }

        return tempDescription;
    }

    /**
     * Returns room name
     * 
     * @return name of room
     */
    public String getRoomName() {
        return name;
    }

    /**
     * Returns the contents of the room as an Items object
     * 
     * @return Contents of the room
     */
    public Items getItemList() {
        return holds;
    }

    /**
     * Removes a given item from the room
     * 
     * @param itemToRemove Item to remove
     */
    public void removeItemFromRoom(Items.Item itemToRemove) {
        holds.removeItem(itemToRemove);
    }

    /**
     * Adds a given item to room
     * 
     * @param itemToAdd The item to add to the room
     */
    public void addItemToRoom(Items.Item itemToAdd) {
        holds.addItem(itemToAdd);
    }

    /**
     * Gets the description of the room
     * 
     * @return Description of the room
     */
    public String getRoomDescription() {
        return description;
    }
    
    /**
     * Returns room connections
     * 
     * @return List of rooms that can be accessed from current room
     */
    public roomType[] getRoomConnections() {
        return connecting;
    }
    
    public roomType getRoomType() {
        return type;
    }
}