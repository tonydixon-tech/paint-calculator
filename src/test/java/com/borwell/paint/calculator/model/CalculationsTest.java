package com.borwell.paint.calculator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculationsTest {
  @Configuration
  public static class TestConfig {
    @Bean
    public Dimensions getDimensions() {
      return mock(Dimensions.class);
    }
  }

  private static final double HEIGHT = 2.0;
  private static final double WIDTH = 4.0;
  private static final double LENGTH = 6.0;
  private static final double COVERAGE = 5.0;
  private static final double DELTA = 0.0001;

  @Autowired
  private Dimensions mockDimensions;

  @Autowired
  private Calculations mCalculations;

  @org.junit.Before
  public void setUp() throws Exception {
    mCalculations = new Calculations(mockDimensions);
  }

  @org.junit.After
  public void tearDown() throws Exception {
    mCalculations = null;
    Mockito.reset(mockDimensions);
  }

  @org.junit.Test
  public void testRoomVolume() {
    System.out.println("Calculations.roomVolume");
    double expect = LENGTH * WIDTH * HEIGHT;

    when(mockDimensions.getHeight()).thenReturn(HEIGHT);
    double actual = mCalculations.roomVolume();

    Mockito.verify(mockDimensions.getHeight(), Mockito.times(1));

    assertEquals(expect, actual, DELTA);
    Mockito.verifyNoMoreInteractions(mockDimensions);
  }

  @org.junit.Test
  public void testFloorArea() {
    System.out.println("Calculations.floorArea");
    double expect = LENGTH * WIDTH;

    when(mockDimensions.getWidth()).thenReturn(WIDTH);
    when(mockDimensions.getLength()).thenReturn(LENGTH);

    double actual = mCalculations.floorArea();

    Mockito.verify(mockDimensions.getLength(), Mockito.times(1));
    Mockito.verify(mockDimensions.getWidth(), Mockito.times(1));

    assertEquals(expect, actual, DELTA);
    Mockito.verifyNoMoreInteractions(mockDimensions);
  }

  @org.junit.Test
  public void testPaintRequired() {
    System.out.println("Calculations.paintRequired");
    double expect = (LENGTH + WIDTH) * 2.0 * HEIGHT / COVERAGE;

    when(mockDimensions.getCoverage()).thenReturn(COVERAGE);
    double actual = mCalculations.paintRequired();
    Mockito.verify(mockDimensions.getCoverage(), Mockito.times(1));

    assertEquals(expect, actual, DELTA);
    Mockito.verifyNoMoreInteractions(mockDimensions);
  }
}