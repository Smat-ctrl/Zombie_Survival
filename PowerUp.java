import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class PowerUp extends Actor
{
    public PowerUp()
    {
     GreenfootImage PowerUp=getImage(); // get the image of the powerup
     int height = PowerUp.getHeight()/60; // turn the height and width into integers
     int width = PowerUp.getWidth()/60;
     PowerUp.scale(width, height);
    }
    public void act()
    {
    move(6);// moves object 
    turn(2);// turns it two
    if(isAtEdge()) //if it is at the edge
     {
         int turnRandom = Greenfoot.getRandomNumber(100);
         turn(turnRandom); //turn a random number from 0-99
     }
    }
}

