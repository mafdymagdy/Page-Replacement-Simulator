package page.replacement.simulator;
import java.util.Scanner;

public class PageReplacementSimulator 
{   
    public static void main(String[] args) 
    {
     int countOfPages, countOfFrames, i, j, chosen;
     
     Scanner input = new Scanner(System.in);
     
     System.out.print("Input the no. of pages: ");
     countOfPages = input.nextInt();
     
     int[] pages = new int[countOfPages];
     
     System.out.print("Input the pages: ");
     for(i = 0; i < pages.length; i++)
     {
       pages[i] = input.nextInt();
     }
     
     System.out.print("Input the no. of frames: ");
     countOfFrames = input.nextInt();
     
     int[] frames = new int[countOfFrames];
     int[] framesHelper = new int[countOfFrames];
     
     
     for(i = 0; i < frames.length; i++)
     {
       frames[i] = -1;
       framesHelper[i] = -1;
               
     }
     
      System.out.println("==============Menu==============");
      System.out.println("1.FIFO  2.OPTIMAL  3.LRU");
      System.out.println("================================");
      System.out.print("Input the no. of your choice : ");
      chosen = input.nextInt();
      if(chosen == 1){
      
     FIFO fifo = new FIFO(countOfPages, countOfFrames);
     fifo.setPages(pages, countOfPages);
     fifo.setFrames(frames, countOfFrames);
     fifo.FIFOALGORITHM();
      }
      else if (chosen == 2){
     OPTIMAL op = new OPTIMAL(countOfPages, countOfFrames);
     op.setPages(pages, countOfPages);
     op.setFrames(frames, countOfFrames);
     op.OPTIMALALGORITHM();
      }
      else if(chosen == 3){
     LRU lru = new LRU(countOfPages, countOfFrames);
     lru.setPages(pages, countOfPages);
     lru.setFrames(frames, countOfFrames);
     lru.LRUALGORITHM();
      }
      else{
      System.err.println("Error invalid input!!");
      }
    }
}
