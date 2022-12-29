import java.util.*;
public class DiceGame extends Account {

	
	@SuppressWarnings("resource")
	public DiceGame(){
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Scanner choice = new Scanner(System.in);
		Scanner playAgain= new Scanner(System.in);
		Account account = new Account();
		
		
		int playerDiceTotal; // The Cards to the player's Die / Dice
		int playerDice;
		int dealerDiceTotal; // The cards to the Dealer's Die / Dice
		int dealerDice;
		int min=1; // SIngle Dot on the Die
		int max=6; // 2,3,4,5,6
		int playerChoice = 0;
		boolean continuePlaying = true;
		
		//The Amount you are going to bet for.
		int bet;
		
		

		try {
			System.out.println("Would you like to start the game?"
					+ "\nEnter 1 to start or any other buttons to exit.");
			playerChoice = choice.nextInt();
			if(playerChoice != 1)
			{
				continuePlaying = false;
				System.out.println("Exited Dice Game");
			}
		}catch(InputMismatchException e)
		{
			continuePlaying = false;
			System.out.println("Exited Dice Game.");
		}
		
		
		while(continuePlaying == true)
		{
			
			
			if(playerChoice == 1)
			{
				System.out.println("How much are you going to bet?:");
				bet = keyboard.nextInt();
					 
				if(bet < balance && bet >0)
				{
					playerDice =(int)Math.floor(Math.random()*(max-min+1)+min);
					dealerDice=(int)Math.floor(Math.random()*(max-min+1)+min);
						
					playerDiceTotal=playerDice; // In the case you want to roll more than one die, maybe having the total will be helpful(?)
					dealerDiceTotal = dealerDice;
						
					if (playerDiceTotal> dealerDiceTotal)
					{
						System.out.println("Your Die / Dice :"+playerDiceTotal);
						System.out.println("AI Die / Dice :"+dealerDiceTotal);
						balance = balance + bet*2;
						wins = wins + 1;
						System.out.println("You Win!\nYour current balance is "+ account.getBalance());
						
							
					
						try {
							System.out.println("Type 1 to play again or any other buttons to exit.");
							int again = playAgain.nextInt();
							if(again != 1)
							{
								continuePlaying = false;
							}
						}catch(InputMismatchException e)
						{
							continuePlaying = false;
							System.out.println("Exited Dice Game.");
						}
						
					}
					else if (playerDiceTotal == dealerDiceTotal)
					{
						System.out.println("Your Die / Dice :"+playerDiceTotal);
						System.out.println("AI Die / Dice :"+dealerDiceTotal);
						System.out.println("Tie\nYour current balance is "+ account.getBalance() );
						
							
						try {
							System.out.println("Type 1 to play again or any other buttons to exit.");
							int again = playAgain.nextInt();
							if(again != 1)
							{
								continuePlaying = false;
							}
						}catch(InputMismatchException e)
						{
							continuePlaying = false;
							System.out.println("Exited Dice Game.");
						}
					}
					else
					{
						System.out.println("Your Die / Dice :"+playerDiceTotal);
						System.out.println("AI Die / Dice :"+dealerDiceTotal);
						balance = balance - bet;
						loss = loss+1;
						System.out.println("You Lose!\nYour current balance is "+ account.getBalance());
						
									
						try {
							System.out.println("Type 1 to play again or any other buttons to exit.");
							int again = playAgain.nextInt();
							if(again != 1)
							{
								continuePlaying = false;
							}
						}catch(InputMismatchException e)
						{
							continuePlaying = false;
							System.out.println("Exited Dice Game.");
						}
					}
					
				}
				else {
					System.out.println("Enter a valid bet");
				}
				//Randomly generate Card
				
			}
			else
			{
				continuePlaying = false;
			}
		}
		
	}

}
