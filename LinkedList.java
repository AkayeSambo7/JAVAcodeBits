/*Creates a Java program that demonstrates how a singly linked list works 
by simulating a dynamic music playlist.*/
public class LinkedList {
        //global variable
        Node head; //to use as the start of the linkedlist

        //node class: song title, pointer
        static class Node{
            String songTitle;
            Node next; //points to next node
            
            // constructor to create new node
            Node(String songTitle)
                {
                    this.songTitle = songTitle;
                    this.next = null;
                }
        }
        
        //appends a new song
        public void append(String songTitle){
            Node newSong = new Node(songTitle);
            Node currentSong = head; //finds the head
            
            //to know where to put the new song
            while (currentSong.next != null) {
                currentSong = currentSong.next;
            }
            currentSong.next = newSong; //attaches new song
        }
        
        //deletes a song
        public void delete(String SongTitle){
            Node currentSong = head; //searches for the song
            
            //searches through the song list
            while (currentSong.next != null) {
                //checks what to delete
                if (currentSong.next.songTitle.equals(SongTitle)){
                    currentSong.next = currentSong.next.next; //skips over B, attaches link to next song over
                    return;
                }
                currentSong = currentSong.next; //moves to the following song
            }
            
        }
        
        //class to print songs in order
        public void show(){
            Node currentSong = head; //makes the head node the current and first song
            
            //prints the linkedlist
            while (currentSong != null){
                System.out.print(currentSong.songTitle + " -> "); //references song nodes on main
                currentSong = currentSong.next; /*references the other songs, makes them 
                                                the current song to make the list*/
            }
            System.out.println("null");
        } 
        
    public static void main (String [] args){
        //LinkedList object
        LinkedList playlist = new LinkedList();
        
        //song nodes
        Node song1 = new Node("Song A");
        Node song2 = new Node("Song B");
        Node song3 = new Node("Song C");
        
        //link nodes
        playlist.head = song1; //sets first node as head
        song1.next = song2;
        song2.next = song3;
        playlist.append("Song D"); //appends new song
        playlist.delete("Song B"); //deletes the selected song
        
        playlist.show(); //prints list
            
    } 
}
