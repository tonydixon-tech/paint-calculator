package com.borwell.paint.calculator.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculationsTest
{
    private static final double HEIGHT = 2.0;
    private static final double WIDTH = 4.0;
    private static final double LENGTH = 6.0;
    private static final double COVERAGE = 5.0;
    private static final double DELTA = 0.0001;
    private Dimensions mDimensions;
    private Calculations mCalculations;

    @org.junit.Before
    public void setUp() throws Exception
    {
        mDimensions = mock(Dimensions.class);
        when(mDimensions.getHeight()).thenReturn(HEIGHT);
        when(mDimensions.getWidth()).thenReturn(WIDTH);
        when(mDimensions.getLength()).thenReturn(LENGTH);
        when(mDimensions.getCoverage()).thenReturn(COVERAGE);

        mCalculations = new Calculations(mDimensions);
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
        mCalculations = null;
    }

    @org.junit.Test
    public void roomVolume()
    {
        double expect = LENGTH * WIDTH * HEIGHT;
        double actual = mCalculations.roomVolume();
        assertEquals(expect, actual, DELTA);
    }

    @org.junit.Test
    public void floorArea()
    {
        double expect = LENGTH * WIDTH;
        double actual = mCalculations.floorArea();
        assertEquals(expect, actual, DELTA);
    }

    @org.junit.Test
    public void paintRequired()
    {
        double expect = (LENGTH + WIDTH) * 2.0 * HEIGHT / COVERAGE;
        double actual = mCalculations.paintRequired();
        assertEquals(expect, actual, DELTA);
    }
}