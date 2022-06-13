package controller;

import model.WordleModel;

public class WordleController {
	
	private WordleModel model;
	
	/*
	 * 2d character array to track guesses that have already been made, and the blank spaces for future guesses.
	 * We chose to store it in the controller though that was a somewhat arbitrary choice. It could (and maybe even should)
	 * be placed in the model as well.
	 */
	private Character[][] progress;
	public int guess_num;
	public int max_guess;
	
	public WordleController (WordleModel model) {
		this.model = model;
		guess_num = 0;
		max_guess = 6;
		progress = new Character[max_guess][model.word_length];
	} 
	
	public boolean isGameOver(String guess) {
		/* Returns true if the game is over, false if not. */		
		boolean gameover = false;
		if (guess_num == max_guess)
		{
			gameover = true;
			return gameover;
		}
		return gameover;
	}

	
	private Character[] combineLists(Character[] list1, Character[] list2)
	{
		Character[] return_merge = new Character[model.word_length];
		for (int i = 0; i < model.word_length; i++)
		{
			if (list1[i] != null)
			{
				return_merge[i] = list1[i];
			}
			else
				{
					if (list2[i] != null)
					{
						return_merge[i] = list2[i];
					}
				}
		}
		return return_merge;
	}
	
	public void makeGuess(String guess) {
		/* Performs any work necessary when a guess occurs. Will need to call methods on the model. */
	
		if (model.getAnswer().equals(guess))
		{
			guess_num = max_guess-1;
		}
		
		//increment guess counter
		guess_num++;
		
		//update guessed characters
		model.updateGuessedCharacters(guess);
				
		//take guess, loop through each character to check if it matches answer
		Character[] return1 = model.correctLettersCorrectPlaces(guess);
		Character[] return2 = model.correctLettersWrongPlaces(guess);
		
		//combine lists
		Character[] merge = combineLists(return1, return2);
		
		//update progress
		//[[A, B, C, D, E], [R, E, S, U, L, T]]
		progress[guess_num - 1] = merge;
		
		
	}
	
	public String getAnswer() {
		/* Returns the answer or 'hidden word'. */
		return model.getAnswer();
	}
	
	public Character[][] getProgress() {
		/* Return the progress the user has made thus far. This also includes blank spaces (underscores) for guesses to come. See the example run in the readme for an example. */
		return progress;
	}
	
	/*
	 * Note that this method returns an array of characters that have been guessed thus far. This is NOT what
	 * the view will eventually display. The view is interested in displaying the characters that have NOT been
	 * guessed yet in order to help the user form new guesses. But that is not OUR problem in the controller (and 
	 * in the model for that matter). If the view wants to display the characters that way, then it is up to the view
	 * to transform this data to its own needs.
	 * 
	 * It is just as likely that another view will want to display the guessed characters instead of those that haven't been guessed.
	 * Which is why it is simply the controller's job to present a clean interface, not perfectly format all of the data the way a 
	 * particular view wants it.
	 * 
	 * If curious, some might argue that it is the controller's job to 'interpret' the data from the model and put it in
	 * such a form/way so that the view can easily display it. This is reasonable but I would argue it fits more in the
	 * MVVM - Model, View, ViewModel architecture.
	 */
	public Character[] getGuessedCharacters() {
		/* Return the guessed characters from the model. */
		return model.getGuessedCharacters();
	}

}
