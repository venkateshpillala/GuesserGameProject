import java.util.*;
//For Guesser
class Guesser{
	
	//HAS Part
	int guessNum;
	
	//DOES Part
	int guess() {
		Scanner s=new Scanner(System.in);
		System.out.println("Guesser... Guess a value :\nvalue between 1-10");
		guessNum=s.nextInt();	
		if(guessNum<11&&guessNum>0)
			return guessNum;
		else
			return guess();
}
}

//For Players

class Player{
	
	//HAS Part
	int guessNum;
	
	//DOES Part
	int player() {
		Scanner s=new Scanner(System.in);
		System.out.println("value between 1-10");

		guessNum=s.nextInt();
		if(guessNum<11&&guessNum>0)
		return guessNum;
		else 
			return player();
	}
}
// For Umpire
class Umpire{

	//HAS Part
	int fG;
    int n;
    int []numFP=new int[100];     
    
     //DOES Part
     
     void collectFromGuesser() {
    	 Guesser g=new Guesser();
    	 fG=g.guess();
    	 
     }
     
     void collectFromPlayers() {
    	 
    	 Scanner s=new Scanner(System.in);
    	 System.out.println("Enter no of players :");
    	 n=s.nextInt();
    	 if(n>0&&n<5) {
    	 Player []p=new Player[n];
    	 
    	 //Object creation for N number of Players
    	 
    	 for(int i=0;i<p.length;i++) {
    		 p[i]=new Player();
    	 }
    	 //Enter guessed values of N number players 
    	 for(int i=0;i<p.length;i++) {
    			System.out.println("Player "+(i+1)+" Enter number :");

    		 numFP[i]=p[i].player();
    	 }
    	 }
    	 else {
    		 System.out.println("Players in between 1-4 only ");
    		 collectFromPlayers();
    	 }
     }
   //Comparision
    
	 
	 void compare() {
		 int i;
		for(i=0;i<n;i++) {
			if(numFP[i]==fG) {
			
				System.out.println("Player "+(i+1)+" is winner");
			}
			else {
				System.out.println("Player "+(i+1)+" you loose the game better luck next time!");
			}
		}
	 }
	 
}
public class GuesserGame {

	public static void main(String []args) {
		
		Umpire u=new Umpire();
		u.collectFromGuesser() ;
		u.collectFromPlayers();
		u.compare();

	}

}
