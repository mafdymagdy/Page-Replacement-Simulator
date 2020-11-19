package page.replacement.simulator;

public class FIFO 
{
    private int countOfPages, countOfFrames, found, victimP = 0, pgFault = 0, hit = 0;
    private int[] pages, frames, framesHelper;
    
    FIFO(int countOfPages, int countOfFrames)
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
    
    public String listFrames(int[] framesHelper, int length)
    {
     String v = ""; 
     for(int i = 0; i < length; i++)
     {
      v = v + "  " + framesHelper[i];
     }
     return v;
    }
    
    public void FIFOALGORITHM(){
     System.out.println("---------------------------------------------------------------");
     System.out.println("Page Content\t     Replace\t\tFrame Content");
     for(int i = 0; i < pages.length; i++)
     {
      found = 0; // found used to detected if the number is in the frame or not if present no pgf if not pgf present.
       for(int j = 0; j < frames.length; j++)
       {
        if(pages[i] == frames[j])
        {
         found = 1; // no pgf 
         System.out.println("     " + pages[i] + "\t\t\t-------------------------------------------------> HIT");
         hit++;
        }
       }
        if(found == 0)
        {
         framesHelper[victimP] = pages[i];
         System.out.println("     " + pages[i] + "\t\t\t" + frames[victimP] + "\t\t" + listFrames(framesHelper, framesHelper.length)); 
         frames[victimP] = pages[i];
         victimP = (victimP + 1) % frames.length; // pointer to the FIFO
         pgFault++;
        }
      }
      System.out.println("---------------------------------------------------------------");
      System.out.println("Total no. of page faults: " + pgFault);
      System.out.println("Total no. of page hits: " + hit);
    }
}
