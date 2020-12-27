package page.replacement.simulator;

public class OPTIMAL 
{
    private int countOfPages, countOfFrames, found, victimP = 0, pgFault = 0, hit = 0, previousFrame = -1, temp, maximumInterval, position = 0, replace;
    private int[] pages, frames, framesHelper;
    
    OPTIMAL(int countOfPages, int countOfFrames)
    {
        this.countOfPages = countOfPages;
        pages = new int[countOfPages];
        
        this.countOfFrames = countOfFrames;
        frames = new int[countOfFrames];
        framesHelper = new int[countOfFrames];
    }
    
    public void setPages(int[] pages, int pagesArrLength)
    {
        for(int i = 0; i < pagesArrLength; i++)
        {
            this.pages[i] = pages[i];
        }
    }
    
    public void setFrames(int[] frames, int framesArrLength)
    {
        for(int i = 0; i < framesArrLength; i++)
        {
            this.frames[i] = frames[i];
            this.framesHelper[i] = frames[i];
        }
    }
    
    public String listFrames()
    {
        String v = "";
        for(int j = 0; j < frames.length; j++)
        {
            v = v + " " + frames[j];       
        }
            return v;
    }
    
    public void OPTIMALALGORITHM()
    {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Page Content\t     Replace\t\tFrame Content");
        for(int i = 0; i < pages.length; i++)
        {
            found = 0;
            for(int j = 0; j < frames.length; j++)
            {
                if(frames[j] == pages[i])
                {
                    found = 1;
                    System.out.println("     " + pages[i] + "\t\t\t-------------------------------------------------> HIT");
                    hit++;
                    break;
                }
            }
            if(found == 0)
            {
                if(previousFrame == frames.length - 1)
                {
                    for(int j = 0; j < frames.length; j++)
                    {
                        for(temp = i + 1; temp < pages.length; temp++)
                        {
                            framesHelper[j] = 0;
                            if(frames[j] == pages[temp])
                            {
                                framesHelper[j] = temp - i;
                                break;
                            }
                        }
                    }
                    found = 0;
                    for(int j = 0; j < frames.length; j++)
                    {
                        if(framesHelper[j] == 0)
                        {
                            position = j;
                            found = 1;
                            break;
                        }
                    }
                }
                else
                {
                    position = ++previousFrame;
                    found = 1;
                }
                if(found == 0)
                {
                    maximumInterval = framesHelper[0];
                    position = 0;
                    for(int j = 1; j < frames.length; j++)
                    {
                        if(maximumInterval < framesHelper[j])
                        {
                            maximumInterval = framesHelper[j];
                            position = j ;
                        }
                    }
                }
                replace = frames[position];
                frames[position] = pages[i];
                System.out.println("     " + pages[i] + "\t\t\t" + replace + "\t\t" + listFrames());
                pgFault++;
            }  
        }
      System.out.println("---------------------------------------------------------------");
      System.out.println("Total no. of page faults: " + pgFault);
      System.out.println("Total no. of page hits: " + hit);
    }
}

    
