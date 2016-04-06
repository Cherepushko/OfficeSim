package com.cherepushko.officesim;

/**
 *
 * @author Panas Cherepushko
 */
public class Order {
    private int priority = 0;
    private String command;
    private String position;
    
    public int getPriority(){ return this.priority; };
    public String getCommand(){ return this.command; };
    public String getPosition(){ return this.position; };
    
    public void setPriority(int p){ this.priority = p; };
    public void setCommand(String c){ this.command = c; };
    public void setPosition(String p){ this.position = p; };
}
