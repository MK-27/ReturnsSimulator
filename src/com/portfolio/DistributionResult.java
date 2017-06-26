package com.portfolio;

public class DistributionResult {

    private double median;
    private double percentile10;
    private double percentile90;

    /**
     * @return the median
     */
    public double getMedian() {
        return median;
    }

    /**
     * @param median
     *            the median to set
     */
    public void setMedian(double median) {
        this.median = median;
    }

    /**
     * @return the percentile10
     */
    public double getPercentile10() {
        return percentile10;
    }

    /**
     * @param percentile10
     *            the percentile10 to set
     */
    public void setPercentile10(double percentile10) {
        this.percentile10 = percentile10;
    }

    /**
     * @return the percentile90
     */
    public double getPercentile90() {
        return percentile90;
    }

    /**
     * @param percentile90
     *            the percentile90 to set
     */
    public void setPercentile90(double percentile90) {
        this.percentile90 = percentile90;
    }

    public String getString() {
        StringBuilder thisString = new StringBuilder();
        thisString.append("Median = ").append(this.median).append(",");
        thisString.append("10th Percentile = ").append(this.percentile10)
                .append(",");
        thisString.append("90th Percentile = ").append(this.percentile90);
        return thisString.toString();
    }
}
