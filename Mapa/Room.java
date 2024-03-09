package Mapa;
public class Room {
    private final String id, n, s, e, w;
    private final String name;
    private int event;
    private boolean eventOccured;
    private boolean isWinCondition;

    public void setEvent(int event) {
        this.event = event;
    }

    public Room(String id, String n, String s, String e, String w, String name, int event, boolean eventOccured, boolean isWinCondition) {
        this.id = id;
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
        this.name = name;
        this.event = event;
        this.eventOccured = eventOccured;
        this.isWinCondition = isWinCondition;
    }

    public void setWinCondition(boolean winCondition) {
        isWinCondition = winCondition;
    }

    public int getEvent() {
        return event;
    }

    public String getN() {
        return n;
    }

    public String getS() {
        return s;
    }

    public String getE() {
        return e;
    }

    public String getW() {
        return w;
    }

    public String getName() {
        return name;
    }


    public boolean hasOccuredEvent() {
        return eventOccured;
    }

    public void setEventOccured(boolean eventOccured) {
        this.eventOccured = eventOccured;
    }

    @Override
    public String toString() {
        if (name.equals("?")){
            return "you hit a wall";
        }
        return "welcome to " + name;
    }
}
