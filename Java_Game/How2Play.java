import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class How2Play extends World
{
    public How2Play()
    {    
        super(1280, 800, 1); 
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("shift")) // if enter is pressed
        {
            Greenfoot.setWorld(new Level1()); // moves on to level1
        }
    }
}
