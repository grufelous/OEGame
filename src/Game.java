public class Game {
    Player human, bot;
    public Game(Player player1, Player player2) {
        if(player1.isBot) {
            bot = player1;
            human = player2;
        } else {
            bot = player2;
            human = player1;
        }
    }

}
