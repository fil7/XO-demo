package ru.fil7.demo.xo.controller;

import ru.fil7.demo.xo.model.Field;
import ru.fil7.demo.xo.model.Figure;
import ru.fil7.demo.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            // check for rows
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))){
                    return field.getFigure(new Point(i, 0));
                }
            }
            // check for columns
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))){
                    return field.getFigure(new Point(0, i));
                }
            }
            // check for diagonals
            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))){
                return field.getFigure(new Point(0, 0));
            }
            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))){
                return field.getFigure(new Point(2, 0));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }
        if (currentFigure == null || currentFigure != nextFigure)
            return false;

        return check(field, nextPoint, pointGenerator);

    }

    private interface IPointGenerator {

        Point next(final Point point);
    }

}
