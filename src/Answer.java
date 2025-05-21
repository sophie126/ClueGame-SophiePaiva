public class Answer extends Character {


    private final String murderWeapon;
    private final String murderer;
    private final String murderLocation;


    public Answer(String obj, String person, String place) {
        super(obj, person, place);
        murderWeapon = obj;
        murderer = person;
        murderLocation = place;
    }


    public String guess(Character[] arr, int i, String m, String w, String l) {
        String returned = "";
        if (arr[i].getLocation().equals(l)) { // checks if the current player (character) has any of the guesses, if they have one it is returned
            if(i == 0) {
                returned = "player " + (i + 1) + " showed you " + l;
                return returned;
            }
            else
            {
                returned = "so player " + (i + 1) + " showed you " + l;
                return returned;
            }
        }
        if (arr[i].getWeapon().equals(w)) {
            if(i == 0)
            {
                returned = "player " + (i + 1) + " showed you " + w;
                return returned;
            }
            else
            {
                returned = "so player " + (i + 1) + " showed you " + w;
                return returned;
            }
        }
        if (arr[i].getSuspect().equals(m)) {
            if(i == 0)
            {
                returned = "player " + (i + 1) + " showed you " + m;
                return returned;
            }
            else
            {
                returned = "so player " + (i + 1) + " showed you " + m;
                return returned;
            }
        } // if the player (character) has none of the guesses
        if (i < arr.length - 1) {
            return "player " + (i + 1) + " does not have any of the things you asked for, " + guess(arr, (i + 1), m, w, l); // will print that this player doesn't have ay of the guesses. recursion is used to check the next element.
        } else {
            return "player " + (i + 1) + " does not have any of the things you asked for. This means no one has any of those."; // if every player is checked and none of them have any of the guesses
        }
    }


    public boolean accuse(String m, String w, String l) // checks guesses against correct answer
    {
        if(l.equals(murderLocation) && w.equals(murderWeapon) && m.equals(murderer))
        {
            return true;
        }
        return false;
    }
}

