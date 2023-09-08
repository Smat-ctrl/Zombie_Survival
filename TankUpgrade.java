import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class TankUpgrade extends Tank
{
    Bullet2 b2;
    public void act()
    {
        ShootBullet(); // overriding the ShootBullet method because there are some changes
        ZombieHits(); //calling the methods from the parent class
        moveKeys();
        inRange();
    }
    public void ShootBullet()
    {
        //Citation start
        MouseInfo pos = Greenfoot.getMouseInfo(); 
        if(pos!=null)
        {
            turnTowards( pos.getX() , pos.getY());
        }
        // Citation end
        String key = Greenfoot.getKey(); // getKey() looks at the most recently pressed key
        if(key!=null)
        { 
            if(key.equals("space"))// if the key equals space add a new bullet on the x value and y value of the tank
            {
              b = new Bullet();
              b2= new Bullet2();
              //Citation Start
              Greenfoot.playSound("LaserSound.wav");
              //Citation End
              getWorld().addObject(b,getX(), getY()+5);
              getWorld().addObject(b2,getX(), getY()+20); // adding another bullet actor in the world, so that this tank shoots 2 instead of 1
              b.setRotation(this.getRotation());// bullet will move in the same direction as the tank
              b2.setRotation(this.getRotation());
            }
        }
    }
}
