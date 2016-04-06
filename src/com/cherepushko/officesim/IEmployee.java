package com.cherepushko.officesim;

/**
 *
 * @author Panas Cherepushko
 */
public interface IEmployee {
        
    public int doWork();
    
    public void selectCommand();
    
    public void command(Order s);
    
    public boolean addPosition(Position position);
    
}
