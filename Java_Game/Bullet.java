import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Bullet extends Actor
{ 
    public void act()
    {
        restriction();// calling the restrictions method
    }
    public void restriction()
    {
        move(6); // moving the bullet a speed of 6
        if(isAtEdge()) // if the bullet is at edge 
        {
            getWorld().removeObject(this); // remove the bullet
        }
    }
    public void removeBullet() // using a method that the zombie code can refer to 
    {
        getWorld().removeObject(this);
    }
}
