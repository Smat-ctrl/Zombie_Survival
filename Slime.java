import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Slime extends Actor
{
    int count =0;
    public Slime()
    {
        GreenfootImage slime = getImage(); // get the image of the slime
        int height = slime.getHeight()/4; // turn the height and width into integers
        int width = slime.getWidth()/4;
        slime.scale(width, height); //re-scale the image in order to have a smaller size
    }
    public void act()
    {
        count++;// increment the counter
        if( count == 200) //if the counter reaches a value of 200
        {
            getWorld().removeObject(this); // remove the object
            count=0; //reset counter
        }
    }
    }
    

