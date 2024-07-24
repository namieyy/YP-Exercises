import java.util.ArrayList;
import java.util.Scanner;

class playList{
    ArrayList<String> songName = new ArrayList<String>();
    int playingSong;

    public playList(String songName, int playingSong){
        this.songName.add(songName);
        this.songName.add(0, "Perfect by Ed Sheeran");
        this.songName.add(0, "Sugar by Maroon 5");
        this.playingSong = 0;
    }

    public void addSongName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter song name to be add: ");
        String newsongName = scanner.nextLine();
        int Index = songName.size();
        this.songName.add(Index,newsongName);
        System.out.println("\nAdded song: " + songName.get(Index));
        action();
    }

    public void removeSongName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter song number to be remove: ");
        int remIndex = scanner.nextInt();
        remIndex -= 1;
        System.out.println("\nDeleted song: " + songName.get(remIndex));
        this.songName.remove(remIndex);
        action();
    }

    public void playSong(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter song number to play: ");
        int playSongIndex = scanner.nextInt();
        playSongIndex -= 1;
        if(playSongIndex >= songName.size()){
            System.out.println("\nThe song is no available.");
        }else{
            this.playingSong = playSongIndex;
        }
        action();
    }

    public void viewSongs(){
        int index = 1;
        for(String i : songName){
            System.out.println(index + " - " + i);
            index++;
        }
        action();
    }

    public void action(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCurrent play: " + songName.get(playingSong));
        System.out.println("\n1 - View Song" +
                "\n2 - Add a Song" +
                "\n3 - Remove a Song" +
                "\n4 - Choose Song to be play" +
                "\n5 - Exit");

        System.out.print("\nEnter your choice (Number 1-5): ");
        int menu = scanner.nextInt();
        switch (menu){
            case 1:
                viewSongs();
                break;
            case 2:
                addSongName();
                break;
            case 3:
                removeSongName();
                break;
            case 4:
                playSong();
                break;
            case 5:
                break;
        }
        //To avoid user cannot go out if they added/remove song.
        menu = 5;
    }
}

public class Exercise36 {
    public static void main(String[] args) {
        playList playList = new playList("Flower by Miley Cyrus", 0);
        playList.action();
    }
}
