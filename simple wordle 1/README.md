# Wordle

Wordle is a word guessing game that recently became popular. You can play
it online to get a good idea of how the real version is meant to be played:
<https://www.powerlanguage.co.uk/wordle/>

You have 6 guesses to reveal a hidden 5-letter word. After each guess, letters
that are in the hidden word are revealed. However, these letters are revealed
differently depending on if they are in the same index in both the guess and
the hidden word or if the letter is in both the guess and the hidden word but
in a different index in each.

For example, if the hidden word was:

```
MAYBE
```
And the guess was

```
MEATS
```
Then it will be shown as

```
Mea__
```
Since the 'M' is capitalized, we know that the 'M' is the correct letter in
the correct index. Since the 'e' and 'a' are lowercase, we know that these letters
are in the hidden word but in a different place than in our guess.

## Example Run

```
Enter a guess: eager
e _ _ e _ 
_ _ _ _ _ 
_ _ _ _ _ 
_ _ _ _ _ 
_ _ _ _ _ 
_ _ _ _ _ 

_ B C D _ F _ H I J K L M N O P Q _ S T U V W X Y Z 

Enter a guess: maybe
e _ _ e _ 
_ _ _ _ e 
_ _ _ _ _ 
_ _ _ _ _ 
_ _ _ _ _ 
_ _ _ _ _ 

_ _ C D _ F _ H I J K L _ N O P Q _ S T U V W X _ Z 

Enter a guess: steep
e _ _ e _ 
_ _ _ _ e 
S _ E e _ 
_ _ _ _ _ 
_ _ _ _ _ 
_ _ _ _ _ 

_ _ C D _ F _ H I J K L _ N O _ Q _ _ _ U V W X _ Z 

Enter a guess: sHeLF
e _ _ e _ 
_ _ _ _ e 
S _ E e _ 
S H E L F 
_ _ _ _ _ 
_ _ _ _ _ 

_ _ C D _ _ _ _ I J K _ _ N O _ Q _ _ _ U V W X _ Z 

Good game! The word was SHELF.
Would you like to play again? yes/no
```

## Writing the Wordle Program
We have provided a file dictionary.txt that contains five letter words, each on their own line.
Choose a random word as the answer. Then allow the user to play the game! There should be 6 turns.
It is important to note that the user should be allowed to play over and over again if they wish.
You can see the user is prompted at the very end of the example run above.
It can be difficult to think of words to guess without knowing which letters you have already guessed.
So we will also show the user which letters they have **not** guessed. You can also see this above.
It is okay to use the same print statement for the end of the game whether the user won or lost. For
example, I always print, "Good game! The word was XXXXX." whether the user won or lost for ease of 
coding.
Please ensure that your program works for both uppercase and lowercase letters in the guesses. It also
should not matter whether or not the letters for the words in the dictionary are uppercase or lowercase.

### Model/View/Controller
A common architecture for writing programs is known as MVC (Model/View/Controller). This architecture applies whenever we have some problem we can model (like a game) and a user interface that displays and interacts with that model (the view). The controller is the code that manipulates the model in response to actions from the view.
The idea of MVC is that each part of the program is sufficiently abstracted from each other that they can change without needing to modify the other parts. For instance, our view is currently a textual interface, but later in the course, we could alter this to be a graphical user interface. If we did that, ideally, we would not need to change the model or the controller, only the view code.
For us, the implementation of the model is fairly simple since it only needs to keep the answer, the guessed characters and respond to guesses about that answer.
The view is a simple text-based program as we have written many times before. It will prompt the user for their guesses and display the result of those guesses.
The controller links these two things together, expressing how to manipulate the model in terms of the “verbs” of the game. 
We will then make three classes:
1.	A main class (named Wordle) that serves as our view, creates the Model and Controller, and deals with user input and output.
2.	A model class (named WordleModel) that stores the representation of the hidden word, which letters have been guessed and responds to guesses about that word.
3.	A controller class (named WordleController) to query the model based on the input from the user that comes through the view.

You are to provide the implementation of all three classes, but you must define your controller and model using at least the methods given in the starter code. Any additional methods or fields you want to add must be **private** to your classes. Only public constants may be added, if necessary.

## Requirements

- You need a working implementation of the Wordle game 
- A Wordle, WordleModel, and WordleController class with only the public methods given in the starter code
- Program does not crash for any input, but more complex error handling is something we will discuss later
- Use a good commenting style based upon what you have learned already. We will have more to discuss about this soon

 
## Submission
 
 As always, the last pushed commit prior to the due date will be graded.
**Due Friday 2/4 at 5PM**

