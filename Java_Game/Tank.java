import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo;
import java.util.List;

public class Tank extends Actor
{
Bullet b;
int c=0,heart=3;
boolean inRange = false;
public Tank()
    {
     GreenfootImage tank = getImage(); // get the image of the tank
     int height = tank.getHeight()/10; // turn the height and width into integers
     int width = tank.getWidth()/10;
     tank.scale(width, height); //re-scale the photo in order to have a smaller size
    }
public void act()
    {
    ShootBullet();//calling methods
    ZombieHits();
    moveKeys();
    inRange();
   }
public void moveKeys()
    {
        if( Greenfoot.isKeyDown("A")) //going left
        {
            setLocation(getX()-6, getY());
        }
        if( Greenfoot.isKeyDown("D")) //going right
        {
            setLocation(getX()+6, getY());
        }
        if( Greenfoot.isKeyDown("W")) //going up
        {
            setLocation(getX(), getY()-6);
        }
        if( Greenfoot.isKeyDown("S")) //going down
        {
            setLocation(getX(), getY()+6);
        }
    }
public void ZombieHits()
    {
        boolean lives = false;// boolean variable to represent when lives are lost
        if( isTouching(Zombie.class)|| isTouching(Zombie2.class)|| isTouching(Slime.class))
        {
            lives = true; // if it is touching the zombie or slime classes, make it equal to true
        }
        if( lives ) // if lives is true
        {
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); // set the location of the tank in the middle
            heart--; // decrement 1 to the total of 3, everytime lives is equal to true
        }
        getWorld().showText("Lives Remaining:" + heart + "/3", 95,60);
        if( heart == 0) // if the counter equals 0
        {
            Greenfoot.setWorld(new YouDied()); // set world to you died screen
        }
    }
    public void inRange()
    {
        if(isTouching(PowerUp.class)) // if the tank is touching the powerup
        {
        removeTouching(PowerUp.class); // remove the powerup
        List<Zombie2>objects= getObjectsInRange(300, Zombie2.class); // Find any zombie in range of the tank
        for( Zombie2 z : objects) // for each zombie in range of the tank
        {
            if( z!=null) // if there isnt zero zombies
              {
                 getWorld().removeObject(z); // remove the zombie
              }
        }
    }
}
public void ShootBullet()
{
    //Citation start
    MouseInfo pos = Greenfoot.getMouseInfo(); // use the mousInfo so that greenfoot an get gain access to the mouse info and store it in pos
    if(pos!=null) // if pos does not equal 0
        {
        turnTowards( pos.getX() , pos.getY());  // make the tank turn towards the cursor
        }
    //Citation end
    String key = Greenfoot.getKey(); // getKey() looks at the most recently pressed key
    if(key!=null)
        { 
        if(key.equals("space"))// if the key equals space add a new bullet on the x value and y value of the Tank
            {
              b = new Bullet(); 
              //Citation Start
              Greenfoot.playSound("LaserSound.wav");// add a sound 
              //Citation End
              getWorld().addObject(b,getX(), getY()); // add bullet
              b.setRotation(this.getRotation());// bullet will move in the same direction as the tank by setting the rotation of the bullet to the rotation of the tank
            }
        }
}
}
