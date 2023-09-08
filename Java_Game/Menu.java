import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Menu extends World
{
    //code citation start
    GreenfootSound sound = new GreenfootSound("Menu2.wav"); // uses the greenfootsound class that allows greenfoot to load audio from a file 
    //code citation end
    public Menu()
    {    
        super(1280, 700, 1); 
        //code citation start
        sound.play(); // using the play method to start playing the sound
        sound.setVolume(30); // setting the volume to 0(off) - 100 ( loud)
        //code citation end
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter")) //if enter is pressed
        {
            Greenfoot.setWorld(new How2Play()); // set the world to how2play
            sound.stop();// stop menu sound
        }
    }
}
