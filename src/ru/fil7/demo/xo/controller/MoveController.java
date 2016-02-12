package ru.fil7.demo.xo.controller;

import ru.fil7.demo.xo.model.*;
import ru.fil7.demo.xo.model.exceptions.AlreadyOccupiedException;
import ru.fil7.demo.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupiedException,
                                                        InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
