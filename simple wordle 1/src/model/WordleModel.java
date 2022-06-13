package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import controller.WordleController;

public class WordleModel {
	
	private String answer;
	private Character[] guessedCharacters;
	public int word_length;
	
	public WordleModel() throws FileNotFoundException { 
		/* Initialize any instance variables. */
		//create answer
		createAnswer();
		
		//manage allowed attempts 
		
		//manage word length
		word_length = 5;
		guessedCharacters = new Character[26];
	}
	
	private void createAnswer() throws FileNotFoundException
	{
		//setup
		File quotefile = new File("dictionary.txt");
		Scanner scanner = new Scanner(quotefile);
		
		//add each word to a list, then shuffle such that a random word is chosen
		ArrayList<String> quotelist = new ArrayList<String>();
		while (scanner.hasNext())
		{
			quotelist.add(scanner.nextLine());
		}
		scanner.close();
		
		//find a random word, set answer equal to it
		Collections.shuffle(quotelist, new Random());
		answer = quotelist.get(0).toLowerCase(); 
		
	}
	
	public Character[] correctLettersWrongPlaces(String guess) {
		/* 
		 * Return an array of characters. Each index in the result array that corresponds to an index in the guess that
		 * held an incorrect letter (a letter not in the answer) should be set to null. Each index that is in the guess
		 * AND in the answer in that same index should also be null. Only a character which is in the guess and the answer,
		 * but in different indices should be set at the index in the result array. Ex:
		 * answer: MAYBE
		 * guess: MEATS
		 * would return an array:
		 * [null, 'e', 'a', null, null]
		 */
		
		//take guess, loop through each character to check if it matches answer
		//array of characters returned after comparing strings
		Character[] result = new Character[word_length];
		Character to_result = null;
		for (int i = 0; i < answer.length(); i++)
		{
			for (int j = 0; j < answer.length(); j++)
			{
				
				if (answer.charAt(i) == guess.charAt(j) && i != j)
				{
					//if the letters are the same, and NOT at the same index
					to_result = Character.toLowerCase(guess.charAt(j));
					result[j] = to_result;
				}	
				
			}
		}
		return result;
	}
	
	public Character[] correctLettersCorrectPlaces(String guess) {
		/*
		 * Similar to above except now all indices in the result array are null except those in the correct indices. Ex:
		 * answer: MAYBE
		 * guess: MEATS
		 * would return an array:
		 * ['M', null, null, null, null]
		 */
		
		//take guess, loop through each character to check if it matches answer
		//array of characters returned after comparing strings
		Character[] result = new Character[word_length];
		Character to_result = null;
		for (int i = 0; i < answer.length(); i++)
		{
			for (int j = 0; j < answer.length(); j++)
			{
				
				if (answer.charAt(i) == guess.charAt(j) && i == j)
				{
					//if the letters are the same, and at the same index
					to_result = Character.toUpperCase(guess.charAt(j));
					result[j] = to_result;
				}	
				
			}
		}
		return result;
		
	}
	
	public String getAnswer() {
		/* Return the answer. Used to show the answer at the end of the game. */
		return answer;
	}
	
	public void updateGuessedCharacters(String guess) {
		/*
		 * Update the guessed characters. For instance, if the user's first guess is SHELF, your guessed characters array previous had every index
		 * set to null. After the guess, then the array would have certain indices set like below:
		 * ['S' - 'A'] = 'S'
		 * ['H' - 'A'] = 'H'
		 * ['E' - 'A'] = 'E'
		 * ['L' - 'A'] = 'L'
		 * ['F' - 'A'] = 'F'
		 */
		for (int i = 0; i < guess.length(); i++)
		{
			guessedCharacters[Character.toUpperCase(guess.charAt(i)) - 'A'] = Character.toUpperCase(guess.charAt(i));
		}
	}
	
	public Character[] getGuessedCharacters() {
		/* Return the guessed characters. */
		return guessedCharacters;
	}

}
