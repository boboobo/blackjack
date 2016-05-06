import java.util.InputMismatchException;
import java.util.Scanner;


public class Player {
	
	String name;
	int money;
	int bet;
	int total;
	
	public Player(String name){
		
		this.name=name;
		
	}
	
	
	public int bet(Player p1){
		while(true){
			System.out.println("How much do you want to bet?");
			try{
				Scanner scanner = new Scanner(System.in);
				int input = scanner.nextInt();
				
				if(p1.money<input){
					System.out.println("Not enough money. Please rebet");
					continue;
				}
				else{
					System.out.printf("%s bet %d$%n",p1.name, input);
					
					p1.money=p1.money-p1.bet;
					
					return input;
					
				}
			}
			catch(InputMismatchException a){
				System.out.println("Please input number");
				continue;
				
			
			}	
		}
	}
	
	
	  public static int play_human(Player p1){
		    Scanner in = new Scanner(System.in);
		    int card[] = new int []{1,2,3,4,5,6,7,8,9,10,10,10,10};
		    
		    int human_card1 = card[(int)(Math.random()*12)];
		    int human_card2 = card[(int)(Math.random()*12)];
		    int human_total = human_card1 + human_card2;
		    System.out.printf(p1.name+" got ");
		    System.out.println(human_card1+" and "+human_card2);
		    
		    for(int i =1 ; i <4 ; ++i){
		      System.out.println("Do you want another card (Y/N)");
		      String s = in.nextLine();
		      if(s.equals("Y")){
		        human_total = human_total + card[(int)(Math.random()*12)];
		        System.out.printf("%S's total is %d%n", p1.name , human_total);
		        p1.bet=p1.bet(p1);

		      }
		      if(s.equals("N")){
		        break;
		      }
		      if(human_total>21){
		        break; 
		      }
		    }
		    return human_total;
	  }
		  
}


class Computer extends Player{

	public Computer(String name) {
		super(name);
		}
	
	
	public static int bet(){
		
		int ran = (int)(Math.random()*10+1);
		System.out.printf("Computer bet %d$%n", ran);
		return ran;
	}
	
	
	
	 public static int play_computer(){
	    Scanner in = new Scanner(System.in);
	    int card[] = new int []{1,2,3,4,5,6,7,8,9,10,10,10,10};
		    
	    int computer_card1 = card[(int)(Math.random()*12)];
	    int computer_card2 = card[(int)(Math.random()*12)];
	    int computer_total = computer_card1 + computer_card2;
	    System.out.println("Computer player got");
	    System.out.println(computer_card1+" and "+computer_card2);
	    return computer_total;
	 	}
	
	
}

