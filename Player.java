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
				p1.bet = p1.bet + input;
				
				if(p1.money<p1.bet){
					System.out.println("Not enough money. Please rebet");
					p1.bet = p1.bet - input;
					continue;
				}
				else{
					System.out.printf("%s bet %d$%n",p1.name, input);
					
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
	        p1.bet=p1.bet+p1.bet(p1);
	        System.out.printf("Total bet is %d%n",p1.bet);
		    
		    for(int i =1 ; i <4 ; ++i){
		      System.out.println("Do you want another card (Y/N)");
		      String s = in.nextLine();
		      if(s.equals("Y")){
		        human_total = human_total + card[(int)(Math.random()*12)];
		        System.out.printf("%S's total is %d%n", p1.name , human_total);
		        p1.bet=p1.bet+p1.bet(p1);
		        System.out.printf("Total bet is %d%n",p1.bet);

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

