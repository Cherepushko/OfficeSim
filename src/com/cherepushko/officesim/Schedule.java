package com.cherepushko.officesim;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Panas Cherepushko
 */
public class Schedule {
    
    public final static int DAYS_IN_MONTH = 31;
    
    private static String[] DAY_LABELS = {"Mo", "Tu", "We", "Th", 
                                          "Fr", "Sa", "Su"};
    private ArrayList<Week> weeks = new ArrayList<Week>();
    public int workedHours = 0;
    
    public Schedule(Employee e){
        
        Random r = new Random();
        Week w = new Week();
        weeks.add(w);
        int current_label = 1;
        int hoursInWeek = 1 + r.nextInt(40);
        for(int i = 1; i <= DAYS_IN_MONTH; i++){
            if(hoursInWeek == 0) break;
            if(current_label > 7){
                current_label = 1;
                w = new Week();
                weeks.add(w);
            }
            Day d = new Day();
            d.setName(DAY_LABELS[current_label - 1]);
            d.setHours(hoursInWeek < 8 ? hoursInWeek : 1 + r.nextInt(8));
            hoursInWeek -= d.getHours();
            w.addDay(d);
            current_label++;
        }
        
    };
    
    public Schedule(){
    
        Week w = new Week();
        weeks.add(w);
        int current_label = 1;
        for(int i = 1; i <= DAYS_IN_MONTH; i++){
            if(current_label > 7){
                current_label = 1;
                w = new Week();
                weeks.add(w);
            }
            Day d = new Day();
            d.setName(DAY_LABELS[current_label - 1]);
            d.setHours(8);
            w.addDay(d);
            current_label++;
        }
    };
    
    public ArrayList<Week> getWeeks(){ return this.weeks; };
    
    public class Day{
        private String label;
        private int hours = 0;
        
        public String getName(){ return this.label; };
        public int    getHours(){ return this.hours; };
        
        public void   setName(String s){ this.label = s; };
        public void   setHours(int i){ this.hours = i; };
    }
    
    public class Week{
        private ArrayList<Day> days = new ArrayList<Day>();
        
        public void addDay(Day d){
            days.add(d);        
        };
        
        public ArrayList<Day> getDays(){ return this.days; };
        
        public int getHours(){ 
            int hours = 0;
            for(Day d : days){
                hours += d.getHours();
            }
            return hours; 
        };
    }
    
}
