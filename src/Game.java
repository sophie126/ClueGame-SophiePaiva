import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        boolean solved = false;
        int story = (int) (Math.random() * 2); // storyline is randomly chosen
        Character player1 = new Character("rope", "Miss Scarlet", "library");
        Character player2 = new Character("dagger", "Professor Plum", "lounge");
        Character player3 = new Character("wrench", "Mrs. Peacock", "billiard Room"); // the wrong suspect, weapon, and location are assigned to these characters
        Answer ans = new Answer("revolver", "Dr Orchid", "conservatory"); // the correct suspect, weapon, and location are assigned to this answer object
        Character[] arr = {player1, player2, player3}; // adds characters to list


        Scanner player = new Scanner(System.in);
        System.out.println("What's your name detective?");
        String playerName = player.nextLine();
        System.out.println("Hello detective " + playerName + ", we've got a serious case here. We need your help.");
        if(story == 0) // storyline is printed
        {
            System.out.println("Some sicko murdered Mrs. White. She was just about to release her new book \"Surviving Clue: My side of the story\". I was so excited.");
        }
        if(story == 1)
        {
            System.out.println("Somebody murdered this random rich guy. I mean, s'not really surprising, everyone hated that guy...");
        }

        System.out.println(); // options given
        System.out.println("Here are the suspects:\n\"Miss Scarlet\", \"Dr.Orchid\", \"Mrs. Peacock\", and \"Professor Plum\"\n");
        System.out.println("The potentials murder weapons are:\nA \"dagger\", \"revolver\", \"rope\", or \"wrench\"\n");
        System.out.println("The murder could've taken place in:\nThe \"conservatory\", \"billiard room\", \"library\", or \"lounge\"\n");


        while(!(solved))
        {
            System.out.println("Sooo, what're we thinking? Do you wanna make a guess or accuse someone");
            String answer = player.nextLine(); //player chooses to guess or accuse
            if(answer.equals("accuse"))
            {
                System.out.println("Who're you thinking is the murderer? **type what's inside the quotes exactly**"); // asks for the guesses
                String guessM = player.nextLine();
                System.out.println("With what weapon?");
                String guessW = player.nextLine();
                System.out.println("Where?");
                String guessL = player.nextLine();
                System.out.println(guessM + " with the " + guessW + " in the " + guessL + "? Are you sure about that? true/false"); // user will go back to the beginning of the loop if they choose false
                boolean readyOrNot = player.nextBoolean();
                if(readyOrNot)
                {
                    if(ans.accuse(guessM, guessW, guessL)) // if correct
                    {
                        System.out.println("Nice work detective. You cracked the case once again.");
                        solved = true;
                    }
                    else // if wrong
                    {
                        System.out.println("That's too bad, it seems you weren't correct. It's ok, we can't always be right.");
                        solved = true;
                    }
                }
            } else if(answer.equals("guess")) // users guess is used fpr guess method
            {
                System.out.println("Who're you thinking is the murderer? **type what's inside the quotes exactly**");
                String guessM = player.nextLine();
                System.out.println("With what weapon?");
                String guessW = player.nextLine();
                System.out.println("Where?");
                String guessL = player.nextLine();
                System.out.println(ans.guess(arr, 0, guessM, guessW, guessL));
            } else
            {
                System.out.println("**guess or accuse**");
                System.out.println();
            }
        }
    }
}
