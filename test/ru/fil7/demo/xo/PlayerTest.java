package ru.fil7.demo.xo;

import org.junit.Test;
import org.junit.Assert;

public class PlayerTest {

    @Test
    public void testGetName() {

        final String testValue = "Max";
        final String expectedValue = testValue;

        final Player player = new Player(testValue, null);

        final String actualValue = player.getName();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigure() {

        final Figure testValue = Figure.X;
        final Figure expectedValue = testValue;

        final Player player = new Player(null, testValue);

        final Figure actualValue = player.getFigure();

        Assert.assertEquals(expectedValue, actualValue);
    }
}