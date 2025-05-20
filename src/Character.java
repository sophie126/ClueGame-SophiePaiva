public class Character {
    private final String weapon;
    private final String suspect;
    private final String location;

    public Character(String obj, String person, String place) {
        weapon = obj;
        suspect = person;
        location = place;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getSuspect() {
        return suspect;
    }

    public String getLocation() {
        return location;
    }
}

