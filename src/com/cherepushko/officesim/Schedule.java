/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cherepushko.officesim;

/**
 *
 * @author panasoft
 */
public class Schedule {
    
    private Day[] month[];
    
    public Schedule(){
    
        
        
    };
    
    private class Day{
        private String name;
        private int hours;
        
        public String getName(){ return this.name; };
        public int    getHours(){ return this.hours; };
        
        public void setName(String s){ this.name = s; };
        public void setHours(int i){ this.hours = i; };
    }
    
}
