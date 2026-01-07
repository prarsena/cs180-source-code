package finalversion;
import java.util.*; 
import java.io.*;
import java.time.LocalDateTime;

public class Friend {
    private int id;
    private String name;
    private int age;
    private ArrayList<Friend> friends = new ArrayList<Friend>();

    public static int generateId(){
        Random r = new Random();
        return r.nextInt(99);
    }

    // OBJECT CONSTRUCTORS
    // 0-arg 'default' constructor
    public Friend(){
        this.id = generateId();
    }
    // 2-arg constructor
    public Friend(String name, int age){
        id = generateId();
        this.name = name;
        this.age = age;
    }

    // SETTER methods for changable fields
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    // GETTER methods for all fields
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public static void displayPublicUserData(Friend f){
        String name = f.getName();
        int id = f.getId();
        System.out.printf("name: %-15s id: %d %n", name, id);
    }

    public void addFriend(Friend f) {
        this.friends.add(f);
    }

    // File Writing
    public void writeUserDataToFile() throws IOException{
        File friendsDir = new File("friends");
		if (!friendsDir.exists()){
			friendsDir.mkdir();
		}

        File friendFile = new File("friends", getName() + ".txt");
        FileWriter fw = new FileWriter(friendFile, true);
        PrintWriter pw = new PrintWriter(fw);

        if (!friendFile.exists()){
            pw.println("User: " + getName());
            pw.println("ID: " + getId());
        }
        
        pw.println(LocalDateTime.now());
        pw.println("Friends: ");
        for (Friend f : friends){
            pw.printf("- %-10s %d %n", f.getName(), f.getId());
        }

        pw.close();
        System.out.printf("Successfully wrote file: %s", friendFile);
    }

    // File Reading
    public void readUserDataFromFile(){
        try {
            File friendFile = new File("friends", getName() + ".txt");
            Scanner scan = new Scanner(friendFile);
            while (scan.hasNext()){
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch(Exception e) {
            System.out.println("Cannot access file. " + e);
        }
    }

    // Custom String representation of a 'friend' object
    @Override
    public String toString(){
        String friendsString = "No friends yet!";
        if (friends.size() > 0){
            friendsString = "";
            for (Friend f : friends){
                friendsString += f.getName() + " | ";
            }
        }
        String profile = String.format("name: %s %nid: %d %nfriends: %s %n", name, id, friendsString);
        return profile;
    }
}
