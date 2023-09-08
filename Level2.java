import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Level2 extends Level1
{
    PowerUp p;
    int countTimeP=0; // declaring new variables that are not in Level1
    public void act()
    {
        spawningZombies(); // overiding the methods in Level1 because changes are made
        addPowerUp();
        KeyShortcut();// overiding the methods in Level1 because changes are made
    }
    public void spawningZombies()
    {
        int y1= Greenfoot.getRandomNumber(1280); //  generating numbers from 0-1279 and storing them in 4 variables
        int y2= Greenfoot.getRandomNumber(1280);
        int y3= Greenfoot.getRandomNumber(1280);
        int y4= Greenfoot.getRandomNumber(1280);
        if(count % 300 ==0)
        {
        addObject(new Zombie2(),0,y1); // spawning the zombie in the left hand side with a random y-value
        addObject(new Zombie2(),0, y2);
        addObject(new Zombie2(), 1280, y3);// spawning the zombie in the right hand side with a random y-value
        addObject(new Zombie2(),1280,y4);
        }
        count++;
    }
    public void addPowerUp()
    {
        p= new PowerUp(); 
        countTimeP++; // incrementing the counter
           if(countTimeP == 600) // if the counter is equal to 600
        {
            addObject(p, 0,400); // add the powerUp object 
            countTimeP=0;//reset the counter so it can start again 
        }
    }
    public void KeyShortcut()
    {
        if( Greenfoot.isKeyDown("enter")) // short cut in order to move to next level
        {
         Greenfoot.setWorld(new UpgradeScreen() ); // if the enter key is pressed move on to UpgradeScreen
        }
    }
    public void addPoints(int points)
    {
        score = score + points; //storing the score in score, while adding the points everytime a condition is met
        showText("Score:"+ score ,40,20); // displaying the text in the top left hand side
        if(score == 20)
        {
            Greenfoot.setWorld(new UpgradeScreen() ); // if the score is equal to 20 the user is then allowed to enter the UpgradeScreen
            score=0;// resets the counter
        }
    }
}
