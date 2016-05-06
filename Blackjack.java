import java.util.Scanner;
public class Blackjack {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your name?");
		String input = scanner.nextLine();
		
		
		Player p1 = new Player(input);
		System.out.printf("P1 is %s%n", p1.name);
		p1.money = 10;
		
		Computer c1 = new Computer("c1");
		c1.money = 10;
		
		do{
		System.out.printf("%s has %d$%n", p1.name, p1.money);
		p1.bet = p1.bet(p1);
		p1.total = p1.play_human(p1);
		

		System.out.printf("Computer has %d$%n",c1.money);
		c1.bet = c1.bet();
		c1.total = c1.play_computer();
		
		Cal_Win(p1, c1);
		
		System.out.println("Play again? (Y/N)");
		
		String answer;
		answer = scanner.nextLine();
		
		if (answer!="Y"){
			System.out.println("Good bye");
			break;
		}
		
		}while(p1.money>0 && c1.money>0);

	}
	

	  
	  public static void Cal_Win(Player p1, Computer c1){
		  if(p1.total>c1.total && p1.total<22){
			  System.out.printf("%S Win!%n", p1.name);
			  p1.money = p1.money + p1.bet;
			  c1.money = c1.money - c1.bet;
			  System.out.printf("%s get %d$. Total is %d$%n",p1.name,p1.bet,p1.money);
			  System.out.printf("Computer lose %d$. Total is %d$%n", c1.bet,c1.money);
		  }
		  else{
			  System.out.printf("Computer Win!%n");
			  c1.money = c1.money + c1.bet;
			  p1.money = p1.money - p1.bet;
			  System.out.printf("%s lose %d$. Total is %d$%n",p1.name,p1.bet,p1.money);
			  System.out.printf("Computer get %d$. Total is %d$%n", c1.bet,c1.money);			  
		  }
		  
		  
		  
	  }
	
	
	

}
