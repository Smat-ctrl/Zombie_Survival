import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class YouWin extends World
{
    public YouWin()
    {    
        super(1366, 768, 1); 
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))// if enter is pressed
        {
            Greenfoot.setWorld(new Menu()); // set the world to Menu
        }
    }
}
