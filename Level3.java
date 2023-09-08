import greenfoot.World;
import greenfoot.*; 
public class Level3 extends World
{
    int score =0, count=0, countTimeP=0; // declaring variables needed 
    PowerUp p;
    public Level3(String upgrade)
    {
       super(1280, 800, 1); 
       setPaintOrder(Bullet.class, Tank.class, Zombie.class, Slime.class); // setting the paint order
       if(upgrade.equals("Upgrade1")) // if the string that is passed from the upgrade screen is equal to Upgrade1
        {
            addObject(new Tank(), getWidth()/2, getHeight()/2); // add the orginal tank
        }
       if(upgrade.equals("Upgrade2")) // if the string that is passed from the upgrade screen is equal to Upgrade2
        {
            addObject(new TankUpgrade(), getWidth()/2, getHeight()/2); // add the subclass of the orginal tank
        }
    } 
    public void act()
    {
        spawningZombies(); // calling the methods made
        addPowerUp();
        KeyShortcut();
    }
    public void spawningZombies()
    {
        int y1= Greenfoot.getRandomNumber(1280); // generating random number from 0-1279
        int y2= Greenfoot.getRandomNumber(1280);
        int y3= Greenfoot.getRandomNumber(1280);
        int y4= Greenfoot.getRandomNumber(1280);
        if(count % 300 ==0) // if the counter divded by 300 has a remainder of 0 add the object
        {
        addObject(new Zombie3(),0,y1); // add the object at the left hand side with a random y-value, adding Zombie3 so that slime will spawn after its death and will add point in level 3
        addObject(new Zombie3(),0, y2); 
        addObject(new Zombie3(), 1280, y3);// add the object at the right hand side with a random y-value
        addObject(new Zombie3(),1280,y4);
        }
        count++; // counts everytime and check if the number is divisble by 300 and gives a remainder
    }
    public void addPowerUp()
    {
        p= new PowerUp();
        countTimeP++; // count the amount of time before the power can enter the world
        if(countTimeP == 600) // if is is equal to 600
        {
            addObject(p, 0,400); // add the object
            countTimeP=0; // reset counter so it can start again
        }
    }
    public void KeyShortcut()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new UpgradeScreen()); // if enter is pressed set the world to the upgrade screen
        }
    }
    public void addPoints(int points)
    {
        score = score + points; //storing the score in score, while adding the points everytime a condition is met
        showText("Score:"+ score ,40,20);// displaying the text in the top left hand side
        if(score == 20)
        {
            Greenfoot.setWorld(new YouWin() );// if the score is equal to 20 the user is then allowed to enter the win screen
            score=0;// reset counter
        }
    }
}
