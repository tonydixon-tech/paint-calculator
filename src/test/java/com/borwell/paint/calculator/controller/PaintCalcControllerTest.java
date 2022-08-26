package com.borwell.paint.calculator.controller;

import com.borwell.paint.calculator.model.Calculations;
import com.borwell.paint.calculator.model.Dimensions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaintCalcControllerTest
{
    @InjectMocks
    PaintCalcController controller;

    @Mock
    Calculations calculations;

    private Dimensions mDimensions;

    private static final double HEIGHT = 2.0;
    private static final double WIDTH = 4.0;
    private static final double LENGTH = 6.0;
    private static final double COVERAGE = 5.0;

    @Before
    public void setUp() throws Exception
    {
        mDimensions = mock(Dimensions.class);
        when(mDimensions.getHeight()).thenReturn(HEIGHT);
        when(mDimensions.getWidth()).thenReturn(WIDTH);
        when(mDimensions.getLength()).thenReturn(LENGTH);
        when(mDimensions.getCoverage()).thenReturn(COVERAGE);
    }

    @Test
    public void paintFormTest()
    {
        String expects = "dimensions";
        String actual = controller.paintForm(mock(Model.class));
        assertTrue(actual instanceof String);
        assertEquals(expects, actual);
    }

    @Test
    public void paintSubmitTest()
    {
        String expects = "results";
        String actual = controller.paintSubmit(mDimensions, mock(Model.class));
        assertTrue(actual instanceof String);
        assertEquals(expects, actual);
    }
}