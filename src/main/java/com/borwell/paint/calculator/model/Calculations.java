package com.borwell.paint.calculator.model;

public class Calculations
{
    private Dimensions mDimensions;
    private double mCoverage;


    /**
     * Class constructor
     *
     * @param dimensions - room dimensions in metres
     * @param coverage   - paint coverage in sq metres per litre
     */
    public Calculations(Dimensions dimensions, double coverage)
    {
        this.mDimensions = dimensions;
        this.mCoverage = coverage;
    }

    /**
     * Volume of the room in cubic metres
     *
     * @return
     */
    public double roomVolume()
    {
        return mDimensions.getHeight() * floorArea();
    }

    /**
     * Floor area in sq metres
     *
     * @return
     */
    public double floorArea()
    {
        return mDimensions.getLength() * mDimensions.getWidth();
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
        return wallArea() / mCoverage;
    }

}
