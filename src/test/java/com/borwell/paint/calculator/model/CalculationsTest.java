package com.borwell.paint.calculator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class CalculationsTest
{
    private static final double HEIGHT = 2.0;
    private static final double WIDTH = 4.0;
    private static final double LENGTH = 6.0;
    private static final double COVERAGE = 5.0;
    private static final double DELTA = 0.0001;
    private Dimensions mDimensions;
    @Autowired
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