public class Answer extends Character {


    private String murderWeapon;
    private String murderer;
    private String murderLocation;


    public Answer(String obj, String person, String place) {
        super(obj, person, place);
        murderWeapon = obj;
        murderer = person;
        murderLocation = place;
    }


    public String guess(Character[] arr, int i, String m, String w, String l) {
        String returned = "";
        if (arr[i].getLocation().equals(l)) {
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
        }
        if (i < arr.length - 1) {
            return "player " + (i + 1) + " does not have any of the things you asked for, " + guess(arr, (i + 1), m, w, l);
        } else {
            return "player " + (i + 1) + " does not have any of the things you asked for. This means no one has any of those.";
        }
    }


    public boolean accuse(String m, String w, String l)
    {
        if(l.equals(murderLocation) && w.equals(murderWeapon) && m.equals(murderer))
        {
            return true;
        }
        return false;
    }
}

