import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Zombie2 extends Zombie
{
    public void act()
    {
        moveActor();// gaining access to the parent class method and using it 
        IsIntersecting(); // calling the intersecting method but overriding it 
    }
    public void IsIntersecting()
    {
        Bullet b = (Bullet)getOneIntersectingObject(Bullet.class);
        if( b!=null)
        {
        hitpoints++; // increments
        b.removeBullet(); // removes bullet
        }
        if (hitpoints == 4)
        {
        removeMe=true;
        Greenfoot.playSound("ZombieShort.wav");
        Level2 l= (Level2)getWorld(); // overriding the method so that the points will be added to level2
        l.addPoints(1);
        }
        if(removeMe)
        {
            getWorld().removeObject(this);
        }
    }
}
