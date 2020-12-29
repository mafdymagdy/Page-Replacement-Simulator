package page.replacement.simulator;

public class LRU 
{
    private int countOfPages, countOfFrames, found1, found2, victimP = 0, pgFault = 0, hit = 0, replace, position, i, j;
    private int[] pages, frames, framesHelper;
    
    public LRU(int countOfPages, int countOfFrames)
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
    
    int findLRU(int framesHelper[], int framesArrLength)
    {
	int i, minimum = framesHelper[0], pos = 0;
	for(i = 1; i < framesHelper.length; ++i){
		if(framesHelper[i] < minimum){
			minimum = framesHelper[i];
			pos = i;
		}
	}
	
	return pos;
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
    
    public void LRUALGORITHM()
    {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Page Content\t     Replace\t\tFrame Content");
        for(i = 0; i < pages.length; i++)
        {
            found1 = 0;
            found2 = 0;
            for(j = 0; j < frames.length; j++)
            {
                if(frames[j] == pages[i])
                {
                    victimP++;
                    framesHelper[j] = victimP;
                    System.out.println("     " + pages[i] + "\t\t\t-------------------------------------------------> HIT");
                    hit++;
                    found1 = 1;
                    found2 = 1;
                    break;
                }
            }
            if(found1 == 0)
            {
                for(j = 0; j < frames.length; j++)
                {
                    if(frames[j] == -1)
                    {
                        victimP++;
                        pgFault++;
                        replace = frames[j];
                        frames[j] = pages[i];
                        framesHelper[j] = victimP;
                        found2 = 1;
                        break;
                    }
                }
            }
            if(found2 == 0)
            {
                position = findLRU(framesHelper, countOfFrames);
                victimP++;
                pgFault++;
                replace = frames[position];
                frames[position] = pages[i];
                framesHelper[position] = victimP;
            }
            if(found1 == 0)
            System.out.println("     " + pages[i] + "\t\t\t" + replace + "\t\t" + listFrames());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Total no. of page faults: " + pgFault);
        System.out.println("Total no. of page hits: " + hit);
    }
}
