import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class YouDied extends World
{
    public YouDied()
    {    
        super(1421, 800, 1);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))// if enter is pressed
        {
            Greenfoot.setWorld(new Menu());// moves on to menu
        }
    }
}

