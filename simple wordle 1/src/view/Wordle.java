package view;

import model.WordleModel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.WordleController;

public class Wordle {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner usr_input = new Scanner(System.in);
		boolean play_game = true;
		while (play_game == true)
		{
			//start game
			
			WordleModel gamemodel = new WordleModel();
			WordleController gamecontroller = new WordleController(gamemodel);
			
			//while game not over, play game
			String usr_guess = null;
			while (gamecontroller.isGameOver(null) == false)
			{
				boolean valid_guess = false;
				while (valid_guess == false)
				{
					//take user input
					System.out.print("Enter a guess with a length of ");
					System.out.print(gamemodel.word_length);
					System.out.print(" characters: ");
					usr_guess = usr_input.nextLine();
					System.out.print("\n");
					
					//check/handle guess length
					if (usr_guess.length() == gamemodel.word_length)
					{
						valid_guess = true;
					}
					else
					{
						System.out.print("ERROR: Please enter a guess with a length of ");
						System.out.print(gamemodel.word_length);
						System.out.println(" characters.");
					}
				}
				//make guess all lowercase to match answer
				usr_guess = usr_guess.toLowerCase();
				
				//handle guess
				gamecontroller.makeGuess(usr_guess);
							
				//print guess arrays
				Character[][] guess_progress = gamecontroller.getProgress();
				for (Character[] i : guess_progress)
				{
					for (Character j : i)
					{
						if (j == null)
						{
							System.out.print("_");
						}
						else
						{
							System.out.print(j);
						}
					}
					System.out.print("\n");
				}
				
				//print unguessed characters
				Character[] guessed_characters = gamecontroller.getGuessedCharacters();
				
				String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				for (int i = 0; i < alphabet.length(); i++)
				{
					if (guessed_characters[i] == null)
					{
						System.out.print(alphabet.charAt(i));
					}
					else
					{
						System.out.print("_");
					}
				}
				System.out.println("\n");
				
			}
			
			System.out.print("GAME OVER, the word was: ");
			System.out.println(gamecontroller.getAnswer());
			
			//handle rematch
			System.out.println("Would you like to play again? (yes/no)");
			String yes_no = usr_input.nextLine();
			yes_no = yes_no.toLowerCase();
			if (yes_no.equals("yes"))
			{
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				play_game = true;
			}
			else 
			{
				play_game = false;
			}
		}
		usr_input.close();
	}

}
