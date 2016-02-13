package ru.fil7.demo.xo;

import ru.fil7.demo.xo.model.*;
import ru.fil7.demo.xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Max";
        final String name2 = "Alex";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while(consoleView.move(game)) {
            consoleView.show(game);
        }
    }
}
