package com.cherepushko.officesim;
/**
 *
 * @author Panas Cherepushko
 */
public class OfficeSim {

    public static void main(String[] args) {
        Office office = new Office();
        office.generateEmployees();
        office.startSimulation();
        office.printReport();
        office.saveReport();
    }
    
}
