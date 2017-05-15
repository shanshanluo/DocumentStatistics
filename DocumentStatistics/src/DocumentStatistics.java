import java.io.File;

/**
 * Created by x0241589 on 4/29/2017.
 */
//import Document;

public class DocumentStatistics {
    private Document doc;
    private int[] letterOccurrenceRate;

    public DocumentStatistics(){
        doc = new Document();
        letterOccurrenceRate = new int[26];
    }

    public Boolean openDocument(File file){
        if(doc == null)
            return Boolean.FALSE;
        if(doc.openFile4Read(file) != null){
            return Boolean.TRUE;
        } else {
            System.out.println("Open document error : File doesn't exist! \n");
            return Boolean.FALSE;
        }
    }

    public Boolean scanLettersInDocument(){
        if(doc == null)
            return Boolean.FALSE;
        return (doc.scanDocument4Letters());
    }

    public int[] getLettersOccurringPercentage(){
        int totalLetters = doc.getTotalLetters();

        int i = 0;
        for(int rate : letterOccurrenceRate){
            letterOccurrenceRate[i] = (int)(doc.getLetterCount((char)(i+'a'))*100/doc.getTotalLetters());
            i++;
        }
        return letterOccurrenceRate;
    }

}
