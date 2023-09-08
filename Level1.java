import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Level1 extends World
{
    Tank tank2; 
    int count =0, score=0; // declaring variables
    public Level1()
    {    
        super(1280, 800, 1);
        tank2= new Tank();
        setPaintOrder(Bullet.class, Tank.class, Zombie.class, Slime.class); // set the paint order of the objects so that one appears before another
        addObject( tank2, getWidth()/2, getHeight()/2); // adding the tank in the middle of the world
    }
    public void act()
    {
        spawningZombies(); // call methods
        KeyShortcut();
    }
    public void addPoints(int points)
    {
        score = score + points; //storing the score in score, while adding the points everytime a condition is met
        showText("Score:"+ score ,40,20); // displaying the text in the top left hand side
        if(score == 10)
        {
            Greenfoot.setWorld(new Level2() ); // if the score is equal to 10 the user is then allowed to enter the second level
            score=0;// resets the counter
        }
    }
    public void spawningZombies()
    {
        int yy= Greenfoot.getRandomNumber(800);// generating two random numbers for the zombies
        int y2= Greenfoot.getRandomNumber(800);
        if( count % 400 ==0) // if a number stored in the variable count is divided by 400 and gives a remainder of 0, then spawn zombies
        {
            addObject( new Zombie(), 0,yy); // adding zombie on the right side with a random y value
            addObject( new Zombie(), getWidth() ,y2);// adding zombie on the left side with a random y value
        }
        count++;
    }
    public void KeyShortcut()
    {
        if( Greenfoot.isKeyDown("enter")) // short cut in order to move to next level
        {
         Greenfoot.setWorld(new Level2() ); // if the enter key is pressed move on to level 2
        }
    }
}

