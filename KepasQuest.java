package Zork2ish;

/**
 * Created by cole9798 on 5/17/2017.
 */
import java.util.*;
public class KepasQuest {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int x = 8;
        int y = 5;
        int loop = 1;
        int locker = 1;
        int key = 1;
        int flash = 1;
        int crowbar = 1;
        int card = 1;
        int door = 1;
        String act = "";
        String place = "";
        String keyOne = "";

        //item stores the description of potential items within the rooms
        String[][] item = new String[10][12];
        item[8][5] = "There is a flashlight lying on the floor.";
        item[7][5] = "The hallway is lined with lockers, which are all locked...";
        item[6][5] = "There is a drinking fountain at the corner of the hallway.";
        item[5][5] = "You see staircases lining the edge of the room. You also notice a crowbar lying in the middle of the room.";
        item[4][5] = "The hall seems completely abandoned; there is dust lining everything in sight.";
        item[3][5] = "The only defining feature of this hall is the copious amounts of dust piled up.";
        item[3][6] = "You can perceive a faint odd smell.";
        item[2][6] = "You see a small note card on the floor, covered in blood.";

        //Location stores the location's name
        String[][] location = new String[10][12];
        location[1][6] = "wall";
        location[2][5] = "wall";
        location[2][7] = "wall";
        location[4][6] = "wall";
        location[4][4] = "wall";
        location[7][6] = "wall";
        location[7][4] = "wall";
        location[6][6] = "wall";
        location[8][6] = "wall";
        location[6][4] = "wall";
        location[8][4] = "wall";
        location[9][5] = "wall";
        location[8][5] = "-Entrance Hall-" + "\n" + "You are in front of a locked door, with a corridor leading north.";
        location[7][5] = "-A Hall-" + "\n" + "You are in the middle of a hallway, the sign to your right says |A Hall|. The entrance is south from you and a particularly large room is further north.";
        location[6][5] = "-A Hall-" + "\n" + "You are further up A-Hall and there's a sign to your right that says |Lobby|. A giant room is north of you and a corridor leads south.";
        location[5][5] = "-Lobby-" + "\n" + "You are now within the giant lobby, underneath there are numbers that correspond to a direction that leads towards a hallway. 1-North 2-West 3-East 4-South.";
        location[4][5] = "-C Hall-" + "\n" + "You are in the middle of a hallway, the sign to your left says |C Hall|. The Lobby is south from you, and an intersecting hallway can be seen further north.";
        location[3][5] = "-C1- Hall-" + "\n" + "You are in the middle of C1 hallway. You can see two bathrooms and more unmarked rooms to your east and west. Another hallway is south of you.";
        location[3][6] = "-C1- Hall-" + "\n" + "You find yourself in the middle of a hallway, you see a room north of you that has a sign reading solely |Principal's office|." + "\n" + "You see a bathroom to the east of you, and a hallway to the west of you.";
        location[2][6] = "-Principal's Office-" + "\n" + "You enter the principal's office. You see a dead man sitting in the chair. He looks strangely familiar…" + "\n" + "There are numerous stab wounds, all open. This crime was recent.";

        //move stores verb actions that moves the player
        List<String> move = new ArrayList<String>();
        List<String> action = new ArrayList<String>();
        List<String> use = new ArrayList<String>();
        List<String> body = new ArrayList<String>();
        List<String> fun = new ArrayList<String>();

        List<String> invent = new ArrayList<String>();
        List<String> lockers = new ArrayList<String>();

        //directions that hold many words with similar definition to move
        List<String> north = new ArrayList<String>();
        List<String> south = new ArrayList<String>();
        List<String> east = new ArrayList<String>();
        List<String> west = new ArrayList<String>();

        fun.add("yoga");
        fun.add("moonwalk");
        fun.add("yell");
        fun.add("dance");

        body.add("hands");
        body.add("hand");
        body.add("foot");
        body.add("feet");
        body.add("mouth");

        lockers.add("locker");
        lockers.add("lockers");

        east.add("east");
        east.add("e");
        east.add("right");

        west.add("west");
        west.add("w");
        west.add("left");

        south.add("south");
        south.add("s");
        south.add("downward");

        north.add("north");
        north.add("n");
        north.add("forward");

        move.add("go");
        move.add("move");
        move.add("walk");
        move.add("run");
        move.add("travel");
        move.add("swagger");

        use.add("use");
        use.add("deploy");
        use.add("hold");

        action.add("take");
        action.add("pick");
        action.add("obtain");
        action.add("grab");

        System.out.print("Would you like to start the game? |y/n| ");
        String begin = in.nextLine();
        if (begin.contains("y") == true){
            System.out.println("-Find your way out of the school.-" + "\n" + "-Good luck.-");
            System.out.println("");
            loop = 0;
        }
        else{
            System.out.println("Restart the program if you want to play again.");
        }

        while (loop == 0){
            System.out.println(location[x][y] + "\n" + item[x][y] + "\n");
            System.out.print("Action: ");
            act = in.nextLine();
            System.out.println("");
//----------------------------------------------------------------------------------------------
            if (move.contains(act) == true){
                System.out.print("Direction: ");
                place = in.nextLine();
                System.out.println("");
                if (north.contains(place) == true){
                    if (location[x-1][y] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("Stop swaggering you creep.");
                        }
                        if (x != 3 && y != 6){
                            x--;
                        }
                        else if (x == 3 && y == 6 && door == 0){
                            x--;
                        }
                        else{
                            System.out.println("The door is locked.");
                        }
                    }
                    else{
                        System.out.println("You become very acquainted with the brick wall.");
                    }
                }
                else if (south.contains(place) == true){
                    if (location[x+1][y] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("Stop swaggering you creep.");
                        }
                        x++;
                    }
                    else{
                        System.out.println("You become very acquainted with the brick wall..");
                    }
                }
                else if (east.contains(place) == true){
                    if (location[x][y+1] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("Stop swaggering you creep.");
                        }
                        y++;
                    }
                    else{
                        System.out.println("9 out of 10 doctors say running into walls is bad for you.");
                    }
                }
                else if (west.contains(place) == true){
                    if (location[x][y-1] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("Stop swaggering you creep.");
                        }
                        y--;
                    }
                }
                else {
                    System.out.println("Sorry, I couldn’t understand that. Please speak clearly.");
                }
            }
//----------------------------------------------------------------------------------------------
            else if (act.contains("drink") && x == 6){
                if (y == 5){
                    System.out.println("Thank you, I was getting quite thirsty from narrating.");
                }
            }
//----------------------------------------------------------------------------------------------
            else if (use.contains(act) == true){
                System.out.println("Use: ");
                String deploy = in.nextLine();
                System.out.println("");
                if (invent.contains(deploy) == true){
                    System.out.print("On: ");
                    String target = in.nextLine();
                    System.out.println("");
                    if (lockers.contains(target) == true && x == 7 && y == 5 && locker == 1 && deploy.contains("crowbar") == true){
                        keyOne = " You spy a gleaming key within one of the lockers!";
                        System.out.println("After a healthy amount of labor, you have successfully pried open all the lockers." + keyOne);
                        locker = 0;
                        item[7][5] = "The lockers are now open thanks to a certain somebody.";
                    }
                    else if (target.contains("door") == true && x == 3 && y == 6 && deploy.contains("key")){
                        System.out.println("The door was unlocked!");
                        door = 0;
                    }
                    else {
                        System.out.println("You cannot use that here - Professor Oak");
                    }
                }
                else if (body.contains(deploy) == true){
                    System.out.println("You are not allowed to use that.");
                }
                else {
                    System.out.println("Sorry, I couldn’t understand that. Please speak clearly.");
                }
            }
//----------------------------------------------------------------------------------------------
            else if (act.contains("check") == true){
                System.out.println("Inventory: " + invent);
            }
//----------------------------------------------------------------------------------------------
            else if (action.contains(act) == true){
                System.out.print("Obtain: ");
                String obtain = in.nextLine();
                System.out.println("");
                if (obtain.contains("crowbar") == true && crowbar == 1){
                    if (x == 5 && y == 5){
                        System.out.println("You heft the crowbar. You feel like a certain scientist in a certain complex...");
                        invent.add("crowbar");
                        crowbar = 0;
                        item[5][5] = "";
                    }
                }
                else if (obtain.contains("key") == true && locker == 0 && x == 7 && y == 5 && key == 1){
                    System.out.println("You pick up the key.");
                    invent.add("key");
                    key--;
                }
                else if (obtain.contains("flashlight") == true && x == 8 && y == 5 && flash == 1){
                    System.out.println("You take the flashlight. At least you won’t be eaten by a grue now.");
                    invent.add("flashlight");
                    flash = 0;
                    item[8][5] = "";
                }
                else if (obtain.contains("card") == true && x == 2 && y == 6 && card == 1){
                    System.out.println("You apprehensively pick up the note card.");
                    invent.add("card");
                    card = 0;
                    item[2][6] = "";
                }
                else {
                    System.out.println("There isn't anything there.");
                }
            }
//----------------------------------------------------------------------------------------------
            else if (fun.contains(act) == true){
                System.out.println("There's not time for that! We must escape this place!");
            }
//----------------------------------------------------------------------------------------------
            else if (act.contains("read") == true){
                System.out.print("On: ");
                String read = in.nextLine();
                System.out.println("");
                if (read.contains("card") == true && invent.contains("card") == true){
                    System.out.println("You can barely read the henscratch on the card. You can finally make out" + "\n" + "-good job making it this far. if you’re reading this, i’m dead." + "\n" + "not everything is as it seems; this is not a normal school. you’ll need luck and skill to make it out of here." + "\n" + "good luck… -mt");
                }
                else {
                    System.out.println("Without the item within your inventory, you may not check its description");
                }
            }
//----------------------------------------------------------------------------------------------
            else{
                System.out.println("Sorry, this primitive code monkey can’t make out your request. Make sure you typed the right thing.");
            }
            System.out.println("-------------------------------------------------------------------------");
        }
    }
}



