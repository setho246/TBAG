import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);

    Places lounge = new Places(Places.roomType.LOUNGE); // Hold the louge room
    Places kitchen = new Places(Places.roomType.KITCHEN); // Hold the kitchen room
    Places bedroom = new Places(Places.roomType.BEDROOM); // Hold the bedroom
    Places currentRoom; // Holds the current room

    Player player; // Holds the player

    /**
     * Runs the main game
     */
    public void startGame() {
        char choice; // Holds the user's choice
        playerSetup();
        showStory();

        currentRoom = bedroom;

        do {
            System.out.print("Enter command (h for help):");
            choice = sc.next().toLowerCase().charAt(0);
            System.out.println();

            switch (choice) {
            case 'h':
                showHelpMenu();
                System.out.println();
                break;
            case 'p':
                pickUp();
                System.out.println();
                break;
            case 'd':
                putDown();
                System.out.println();
                break;
            case 'i':
                showInventory();
                System.out.println();
                break;
            case 'w':
                move();
                System.out.println();
                break;
            case 'l':
                look();
                System.out.println();
            }
        } while (choice != 'x');

    }

    /**
     * Prints a menu of potential items to the user, then adds the selected item to
     * the characters inventory and removes it from the room
     */
    public void pickUp() {
        Items roomItems = currentRoom.getItemList();
        int posToAdd;

        if (roomItems.getListLength() > 0) {
            for (int i = 0; i < roomItems.getListLength(); i++) {
                System.out.println((i + 1) + ". " + roomItems.getItemAtPosition(i));
            }

            System.out.print("Enter Position to add, or enter 0 to exit: ");
            posToAdd = sc.nextInt() - 1;

            if (posToAdd != -1) {
                player.pickItemUp(roomItems.getItemAtPosition(posToAdd));
                currentRoom.removeItemFromRoom(roomItems.getItemAtPosition(posToAdd));
            }
        } else {
            System.out.println("No more items in this room");
        }
    }

    /**
     * Prints a menu of potential items to the user, then adds the selected item to
     * the room and removes it from the characters inventory
     */
    public void putDown() {
        Items inventoryItems = player.getInventory();
        int posToDrop;

        if (inventoryItems.getListLength() > 0) {
            for (int i = 0; i < inventoryItems.getListLength(); i++) {
                System.out.println((i + 1) + ". " + inventoryItems.getItemAtPosition(i));
            }

            System.out.print("Enter Position to drop, or enter 0 to exit: ");
            posToDrop = sc.nextInt() - 1;

            if (posToDrop != -1) {
                currentRoom.addItemToRoom(inventoryItems.getItemAtPosition(posToDrop));
                player.putItemDown(inventoryItems.getItemAtPosition(posToDrop));
            }
        } else {
            System.out.println("No more items in inventory");
        }
    }

    public void showInventory() {
        Items inventoryItems = player.getInventory();
        int posToDescribe;

        if (inventoryItems.getListLength() > 0) {
            for (int i = 0; i < inventoryItems.getListLength(); i++) {
                System.out.println((i + 1) + ". " + inventoryItems.getItemAtPosition(i));
            }
            System.out.println("Enter item number to describe, or enter 0 to exit");
            posToDescribe = sc.nextInt() - 1;

            if (posToDescribe != -1) {
                System.out.println(inventoryItems.getItemDescription(inventoryItems.getItemAtPosition(posToDescribe)));
            }
        } else {
            System.out.println("No items in inventory");
        }
    }

    public void move() {
        int roomToMoveTo;

        for (int i = 0; i < currentRoom.getRoomConnections().length; i++) {
            System.out.println((i + 1) + ". " + currentRoom.getRoomConnections()[i]);
        }

        System.out.println("Enter room number to move to, or enter 0 to exit");
        roomToMoveTo = sc.nextInt() - 1;

        if (roomToMoveTo != -1) {
            Places.roomType type = currentRoom.getRoomType();

            switch (type) {
            case BEDROOM:
                bedroom = currentRoom;
                currentRoom = lounge;
                System.out.println(currentRoom.getRoomDescription());
                break;
            case KITCHEN:
                kitchen = currentRoom;
                currentRoom = lounge;
                System.out.println(currentRoom.getRoomDescription());
                break;
            case LOUNGE:
                if (currentRoom.getRoomConnections()[roomToMoveTo] == Places.roomType.KITCHEN) {
                    lounge = currentRoom;
                    currentRoom = kitchen;
                    System.out.println(currentRoom.getRoomDescription());
                } else {
                    lounge = currentRoom;
                    currentRoom = bedroom;
                    System.out.println(currentRoom.getRoomDescription());
                }
            }
        }
    }
    
    public void look() {
        Items roomItems = currentRoom.getItemList();
        int posToDescribe;
        
        if (roomItems.getListLength() > 0) {
            for (int i = 0; i < roomItems.getListLength(); i++) {
                System.out.println((i + 1) + ". " + roomItems.getItemAtPosition(i));
            }

            System.out.print("Enter Position to describe, or enter 0 to exit: ");
            posToDescribe = sc.nextInt() - 1;

            if (posToDescribe != -1) {
                System.out.println(roomItems.getItemDescription(roomItems.getItemAtPosition(posToDescribe)));
            }
        } else {
            System.out.println("No more items in this room");
        }
        
    }

    /**
     * Prints the list of possible commands
     */
    public void showHelpMenu() {
        System.out.println("(h)elp");
        System.out.println("(p)ick Up");
        System.out.println("Put (d)own");
        System.out.println("(w)alk To");
        System.out.println("(i)nventory");
        System.out.println("(l)ook");
        System.out.println("E(x)it");
    }

    /**
     * Asks the user for player name and age, then sets player to equal a new player
     * instance
     */
    public void playerSetup() {
        String name;
        int age;

        System.out.println("Enter Player Name:");
        name = sc.nextLine();

        System.out.println("Enter player age:");
        age = sc.nextInt();

        player = new Player(name, age);
    }

    /**
     * Prints the story line at the start of the game
     */
    public void showStory() {
        System.out.println();
        System.out.println("You awake in a strange place you've never seen before");
        System.out.println("You have no memories of what happened or how you got here");
        System.out.println("You have nothing in your pockets, and you feel fully rested");
        System.out.println("You look around the bedroom looking for clues of what happened");
        System.out.println();
    }

}