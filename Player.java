public class Player {

    private String playerName;
    private char gameCharacter; // 'e' for evens, 'o' for odds

    public Player(String playerName, char gameCharacter) {
        this.playerName = playerName;
        this.gameCharacter = gameCharacter;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getGameCharacter() {
        return gameCharacter;
    }
}