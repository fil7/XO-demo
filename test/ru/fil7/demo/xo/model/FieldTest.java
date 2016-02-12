package ru.fil7.demo.xo.model;

import org.junit.Assert;
import org.junit.Test;
import ru.fil7.demo.xo.model.exceptions.AlreadyOccupiedException;
import ru.fil7.demo.xo.model.exceptions.InvalidPointException;

import java.awt.*;


public class FieldTest {

    @Test
    public void testGetFigure() {

    }

    @Test
    public void testGetSize() throws Exception{
        final Field field = new Field();
        Assert.assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception{
        final Field field = new Field();
        final Point point = new Point(0, 0);
        final Figure inputFigure = Figure.O;

            field.setFigure(point, inputFigure);
            final Figure actualFigure = field.getFigure(point);
            Assert.assertEquals(inputFigure, actualFigure);


    }
    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        Assert.assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            Assert.fail();
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            Assert.fail();
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            Assert.fail();
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            Assert.fail();
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSetFigureWhenAlfreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint, inputFigure);
        try {

            field.setFigure(inputPoint, inputFigure);
            Assert.fail();
        } catch (final AlreadyOccupiedException e) {
            e.printStackTrace();
        }

    }
}