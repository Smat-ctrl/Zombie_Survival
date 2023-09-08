import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Zombie extends Actor
{ 
    int hitpoints=0;// a variable to count how many times a bullet hits a zombie
    boolean removeMe= false;
    public Zombie()
    {
        GreenfootImage Zombie= getImage(); // creating new dimensions for the zombie 
        int height =(int) Zombie.getHeight()/8;
        int width= (int) Zombie.getWidth()/3;
        Zombie.scale( height, width ); // scaling it to height that is divided by 3 and width divided by 8
    }
    public void act()
    {
      moveActor(); // calling a move actor method 
      IsIntersecting();
    }
    public void moveActor() // creating moveActor method
    {
     int y = Greenfoot.getRandomNumber(8); // generating a random number 0-7
     move(y); // moving a random number
     //code citation start
     Tank location = (Tank)getWorld().getObjects(Tank.class).get(0); //in order to receive the x and y location we have to get the object, tank location
     //code citation end
     turnTowards(location.getX(),location.getY()); // allows the zombie to turn towards the location of the tank
    }
    public void IsIntersecting()
    {
     Bullet b = (Bullet)getOneIntersectingObject(Bullet.class); // returns bullet actor
     if( b!=null) // if the bullet does not equal 0
        {
            hitpoints++; // increment hitpoints counter
            b.removeBullet(); // get access to the removeBullet in the bullet class
        }
     if( hitpoints == 4) // if the bullet touches the zombie 4 times
        {
        removeMe=true; // boolean variable is set to true
        //code citation start
        Greenfoot.playSound("ZombieShort.wav"); // play the zombie death sound
        //code citation end
        Level1 l= (Level1)getWorld(); // cast getworld and add 1 point to the addpoints method
        l.addPoints(1);
        }
     if(removeMe) // if the boolean variable equals true 
        {
            getWorld().removeObject(this); // remove the object
        }
    }
}


