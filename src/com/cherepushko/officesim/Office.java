/**
 *
 * @author Panas Cherepushko
 */
package com.cherepushko.officesim;

import com.cherepushko.officesim.Schedule.Week;
import com.cherepushko.officesim.Schedule.Day;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import javafx.scene.control.Alert;

/**
 *
 * @author panasoft
 */
public class Office {
    
    private ArrayList<Employee> employees = new ArrayList<>();
    private int eCount = 0;
    
    public static String[] POSITIONS = {"Director", "Manager", 
        "Accountant", "Programmer", "Tester", "Designer", "Cleaner"};
    public static String[] COMMANDS = {"писать код", "рисовать макет", 
        "тестировать программу", "продавать услуги", "составить отчетность", 
        "выполнить уборку в офисе"};
    
    public static HashMap<String, String> positionFromCommand = new HashMap<String, String>();
    
    public static HashMap<String, Integer> SALARY = 
                                    new HashMap<String, Integer>();
    
    public Office(){
        this.positionFromCommand.put("писать код", "Programmer");
        this.positionFromCommand.put("рисовать макет", "Designer");
        this.positionFromCommand.put("тестировать программу", "Tester");
        this.positionFromCommand.put("продавать услуги", "Manager");
        this.positionFromCommand.put("составить отчетность", "Accountant");
        this.positionFromCommand.put("выполнить уборку в офисе", "Cleaner");
        
        SALARY.put("Director", 25);
        SALARY.put("Manager", 18);
        SALARY.put("Accountant", 7);
        SALARY.put("Programmer", 15);
        SALARY.put("Tester", 12);
        SALARY.put("Designer", 12);
        SALARY.put("Cleaner", 6);
    };
    
    public void startSimulation(){
        
        Random r = new Random();
        Schedule schedule = new Schedule();
        
        for(Week w : schedule.getWeeks()){
            for(Day d : w.getDays()){
                for(int i = 1; i <= 8; i++){
                    giveOrder(d);
                }
                this.doWork();
            }
        }
    
        
        int rn = r.nextInt(6);
        int rc = 0;
        if(rn == 0)
            rc = 1 + r.nextInt(3);
        for(int i = 0; i < rc; i++){}
        
    };
    
    private void day(){};
    private void week(){};
    
    private boolean giveOrder(Day d){
        Random r = new Random();
        if(d.getHours() == 0) return false;
            //d.getHours() < 2
            Order order = new Order();
            order.setPriority(r.nextInt(6)); // приоритет 0 - 5
            order.setCommand(this.COMMANDS[
                                    r.nextInt(this.COMMANDS.length)]);
            order.setPosition(this.positionFromCommand.get(
                                    order.getCommand()));
            for(Employee e : this.employees)
                e.command(order);
        return true;
    };
    
    public void doWork(){
        for (Employee e: this.employees){
            e.doWork();
        }
    };
    
    public void generateEmployees(){
        Random r = new Random();
        int ecount = 10 + r.nextInt(91); // 10 - 100 работников
        
        Employee e = new Employee();       
        e.addPosition(new Position(
                "Director" , SALARY.get("Director")));
        employees.add(e);
        
        e = null;
        
        e = new Employee();       
        e.addPosition(new Position(
                "Manager" , SALARY.get("Manager")));
        employees.add(e);
        
        e = null;
        
        e = new Employee();       
        e.addPosition(new Position(
                "Accountant" , SALARY.get("Accountant")));
        employees.add(e);
        
        e = null;
        int x = 0;
        try{        
        for(int i = 0; i < ecount; i++){
            e = new Employee();
            x = r.nextInt(POSITIONS.length);
            e.addPosition(new Position(POSITIONS[x], SALARY.get(POSITIONS[x])));
            employees.add(e);
            e = null;
        }
        }catch(Exception ex){System.err.println(x);}
    }

    public void printEmployees(){
        int i = 1;
        for (Employee e: this.employees){
            System.out.println(i + ":: Name: " + e.getName()
                + " Surname: " + e.getSurname()
                + " Workerd Time: " + e.getWorkedTime());
            SortedSet<Position> p = e.getPositions();
            System.out.println("Positions:");
            for(Position pos : p){
                System.out.println(pos.getPosition() + "\n"
                                + "Salary: " + pos.getSalary());
            }
            i++;
        }
    };
    
    public void printSchedules(){
        int i = 1;
        for (Employee e: this.employees){
            System.out.println(i + ":: Name: " + e.getName()
                + " Surname: " + e.getSurname()
                + " Workerd Time: " + e.getWorkedTime());
            i++;
            ArrayList<Schedule.Week> weeks = e.getSchedule().getWeeks();
            for(Schedule.Week w : weeks){
                System.out.println("Hours: " + w.getHours());
                ArrayList<Schedule.Day> days = w.getDays();
                for(Schedule.Day d : days){
                    System.out.println(d.getName() + ": " + d.getHours());
                }
            }
        }
    };
    
    public void printReport(){
        int i = 1;
        for (Employee e: this.employees){
            System.out.println(i + "> Name: " + e.getName()
                + " Surname: " + e.getSurname()
                + " Workerd Time: " + e.getWorkedTime());
            i++;
            ArrayList<Schedule.Week> weeks = e.getSchedule().getWeeks();
            System.out.println("Weeks: " + weeks.size());            
            for(Schedule.Week w : weeks){
                System.out.println("Hours: " + w.getHours());
                ArrayList<Schedule.Day> days = w.getDays();
                for(Schedule.Day d : days){
                    System.out.println(d.getName() + ": " + d.getHours());
                }
            }
        }
    };
    
    public void saveReport(){
        try{
            FileWriter fw = new FileWriter(new File("report.txt"));
            String s = new String();
            int i = 1;
            for (Employee e: this.employees){
                fw.write(i + "> Name: " + e.getName()
                    + " Surname: " + e.getSurname()
                    + " Workerd Time: " + e.getWorkedTime() + "\n");
                i++;
                ArrayList<Schedule.Week> weeks = e.getSchedule().getWeeks();
                fw.write("Weeks: " + weeks.size() + "\n");            
                for(Schedule.Week w : weeks){
                    fw.write("Hours: " + w.getHours());
                    ArrayList<Schedule.Day> days = w.getDays();
                    for(Schedule.Day d : days){
                        fw.write(d.getName() + ": " + d.getHours() + "\n");
                    }
                }
            }
            fw.write("Report saved\n");
            fw.flush();
        }catch(IOException ex){System.err.println("IO Exception" + ex);}
    };
    
}
