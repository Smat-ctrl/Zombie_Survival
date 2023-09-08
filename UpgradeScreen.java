import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class UpgradeScreen extends World
{
    public UpgradeScreen()
    {    
        super(1280, 800, 1); 
    }
    public void act()
    {
        String upgrade = ""; // intializing a string named upgrade
        if( Greenfoot.isKeyDown("2")) // if the user presses down on 2
        {
            upgrade="Upgrade1"; // make the upgrade equal "Ugrade1"
            Greenfoot.setWorld(new Level3(upgrade)); // sets the world to level 3 while passing the upgrade to level 3
        }
        if( Greenfoot.isKeyDown("1")) //if the user presses down on 1
        {
            upgrade="Upgrade2"; // upgrade will be equal to Upgrade2
            Greenfoot.setWorld(new Level3(upgrade));
        }
    }
}
