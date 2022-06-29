package com.borwell.paint.calculator.model;

/**
 * Room dimensions
 */
public class Dimensions
{
    private double length;
    private double width;
    private double height;
    private double coverage;

    public Dimensions()
    {
        this.coverage = 1.0;
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getCoverage()
    {
        return coverage;
    }

    public void setCoverage(double coverage)
    {
        this.coverage = coverage;
    }
}
