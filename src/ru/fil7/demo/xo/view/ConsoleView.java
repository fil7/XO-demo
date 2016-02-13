package ru.fil7.demo.xo.view;

import ru.fil7.demo.xo.controller.CurrentMoveController;
import ru.fil7.demo.xo.controller.MoveController;
import ru.fil7.demo.xo.controller.WinnerController;
import ru.fil7.demo.xo.model.Field;
import ru.fil7.demo.xo.model.Figure;
import ru.fil7.demo.xo.model.Game;
import ru.fil7.demo.xo.model.exceptions.AlreadyOccupiedException;
import ru.fil7.demo.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if(x != 0) {
                printSeparator();
            }
            printLine(field, x);
        }
        //printSeparator();
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s", winner);
            return false;
        }
        final Figure currenFigure = currentMoveController.currentMove(field);
        if (currenFigure == null) {
                System.out.println("No winner and no moves left!");
                return false;
        }
        System.out.format("Please enter move point for: %s", currenFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currenFigure);
        } catch (AlreadyOccupiedException e) {
            //e.printStackTrace();
        } catch (InvalidPointException e) {
            System.out.println("Point is invalid! ");
        }
        return true;
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("\nPlease input %s ", coordinateName);
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch ( final InputMismatchException e) {
            System.out.println("Not number");
            return askCoordinate(coordinateName);
        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }


    private void printLine(final Field field, final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            final Figure figure;
            if (y != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            try {
                 figure = field.getFigure(new Point(x, y));

            } catch (InvalidPointException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
            //System.out.print("|");
        }
        System.out.println();
    }

    private void printSeparator() {
    System.out.println("~~~~~~~~~~~");
    }

}
