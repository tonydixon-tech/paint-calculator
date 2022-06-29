package com.borwell.paint.calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations
{
    private Dimensions mDimensions;


    /**
     * Class constructor
     *
     * @param dimensions - room dimensions in metres
     */
    public Calculations(Dimensions dimensions)
    {
        this.mDimensions = dimensions;
    }

    public void setmDimensions(Dimensions dimensions)
    {
        this.mDimensions = dimensions;
    }

    /**
     * Volume of the room in cubic metres
     *
     * @return
     */
    public double roomVolume()
    {
        return round(mDimensions.getHeight() * floorArea());
    }

    /**
     * Floor area in sq metres
     *
     * @return
     */
    public double floorArea()
    {
        return round(mDimensions.getLength() * mDimensions.getWidth());
    }

    private double wallArea()
    {
        return 2.0 * ((mDimensions.getWidth() + mDimensions.getLength()) * mDimensions.getHeight());
    }

    /**
     * Paint required (litres)
     * @return
     */
    public double paintRequired()
    {
        return round(wallArea() / mDimensions.getCoverage());
    }

    private double round(double value){
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}
