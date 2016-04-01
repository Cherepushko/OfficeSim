/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

import java.util.ArrayList;

/**
 *
 * @author panasoft
 */
public class Employee implements IEmployee{

    public Employee() {
        
    }
    
    enum Position{DIRECTOR, PROGRAMMER, DESIGNER, TESTER, 
                    MANAGER, ACCOUNTANT, CLEANER};
    
    private ArrayList<Position> position = new ArrayList<Position>();
    private int hours = 0;
    private boolean busy = false;
    
    public boolean isBusy(){ return busy; };
    
    @Override
    public int doWork(){
        return 0;
    };
    
    
}
