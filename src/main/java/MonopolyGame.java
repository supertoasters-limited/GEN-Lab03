public class MonopolyGame {
    public final static int nbRound = 20;
    private Board gameBoard;
    private Die[] gameDices;
    private int roundCnt;
    private Player[] gamePlayers;


    public void playGame() {
        for (int i = 0; i < nbRound; i++) {
            playRound();
        }
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public MonopolyGame(int nbPlayer) throws Exception {
        if (nbPlayer < 2 || nbPlayer > 8) {
            throw new Exception("Choose between 2-8 players");
        }

        gameBoard = new Board();
        gameDices = new Die[2];
        for(int i = 0; i < 2; i++){
            gameDices[i] = new Die();
        }
        roundCnt = 0;

        gamePlayers = new Player[nbPlayer];
        for(int i = 0; i < gamePlayers.length; i++){
            gamePlayers[i] = new Player(gameBoard.getAllSquares()[0], "Player"+i);
        }
    }

    public void playRound() {
        roundCnt++;
        for (Player p:
             gamePlayers) {
            p.takeTurn(gameDices, gameBoard);
        }
    }
}
