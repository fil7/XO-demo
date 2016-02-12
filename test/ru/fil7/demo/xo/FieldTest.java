package ru.fil7.demo.xo;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;


public class FieldTest {

    @Test
    public void testGetFigure() {

    }

    @Test
    public void testGetSize() {
        final Field field = new Field();
        Assert.assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() {
        final Field field = new Field();
        final Point point = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(point, inputFigure);
        final Figure actualFigure = field.getFigure(point);

        Assert.assertEquals(inputFigure, actualFigure);
    }
}