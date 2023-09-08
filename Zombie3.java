import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Zombie3 extends Zombie2
{
Slime s;
   public void act()
{
    moveActor();// gaining access to the parent class method and using it 
    IsIntersecting(); // calling the intersecting method but overriding it because changes are made
}
   public void IsIntersecting()
{
    Bullet b = (Bullet)getOneIntersectingObject(Bullet.class);
    if( b!=null)
        {
            hitpoints++; 
            b.removeBullet();
        }
    if (hitpoints == 4)
        {
        s= new Slime();
        removeMe=true;
        Greenfoot.playSound("ZombieShort.wav");
        getWorld().addObject(s , getX(), getY());// adding the slime after the zombie dies
        Level3 l= (Level3)getWorld();// overriding the method so that the points will be added to level3
        l.addPoints(1);
        }
    if(removeMe)
        {
            getWorld().removeObject(this);
        }
 }
}
