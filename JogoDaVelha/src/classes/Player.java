package classes;

public class Player {
    private String name;
    private char symbol;
    private int score;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", score=" + score + "]";
    }

    


}
