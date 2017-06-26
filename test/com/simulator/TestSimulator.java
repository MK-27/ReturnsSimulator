package com.simulator;

import junit.framework.TestCase;

import org.junit.Test;

public class TestSimulator extends TestCase {

    @Test
    public void testSimulateDistributionForAggressive() throws Exception {
        Simulator simulator = new Simulator();
        simulator.printDistributionSimulationForAggressive();
    }

    @Test
    public void testSimulateDistributionForConservative() throws Exception {
        Simulator simulator = new Simulator();
        simulator.printDistributionSimulationForConservative();
    }
    
    @Test
    public void testGetSortedSimulationValues() throws Exception {
        Simulator simulator = new Simulator();
        double[] simulatedValues = simulator.getSortedSimulationValues(
                Simulator.MEAN_AGGRESSIVE,
                Simulator.SD_AGGRESSIVE, Simulator.INVESTMENT,
                Simulator.NUM_OF_YEAR, Simulator.ANNUAL_INFLATION);
        assertNotNull(simulatedValues);
        assertEquals(simulatedValues.length, Simulator.NUM_SIMULATIONS);
    }

}
