

/**
 * Created by x0241589 on 4/28/2017.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Document {

    public Document()
    {
        this.bReader = null;
        this.documentSize = 0;
        this.totalLetters = 0;
        this.characters = new Character[ALL_CHARACTER];
        for(int i=0; i<ALL_CHARACTER; i++){
            characters[i] = new Character();
        }
    }

    public BufferedReader openFile4Read(File file) {
        try {
            bReader = new BufferedReader(new FileReader(file));
            return bReader;
        } catch(Exception e){
            System.out.println("Error : File is not existed!" + file.getName());
            return null;
        }
    }

    public int getDocumentSize()
    {
        return totalLetters;
    }

    public int getTotalLetters()
    {
        return totalLetters;
    }

    /* only increment alphabet numbers, for all other characters, return 0 */
    public int incrementLetterCount(char l)
    {
        Character c;
        if((l < 'a')||(l > 'z') ||(l < 'A') && (l > 'Z')) {
            documentSize++;
            return 0;
        }
        if((l >= 'a')&&(l <= 'z'))
            c = characters[l-'a'];
        else
            c = characters[l-'A'];

        if(c.id == ' ')
            c.setId(l);
        int number = c.incrementOccurrence();

        documentSize++;
        totalLetters++;

        return number;
    }

    public int getLetterCount(char l)
    {
        Character c;

        if(((l < 'a')&&(l > 'z')) ||((l < 'A') && (l > 'Z')))
            return 0;

        if((l >= 'a')&&(l <= 'z'))
            c = characters[l-'a'];
        else
            c = characters[l-'A'];

        return c.getOccurrence();
    }

    public Boolean scanDocument4Letters(){
        String s;
        try {
            while ((s = bReader.readLine()) != null)
            {
                char[] chars = s.toCharArray();
                for(char c: chars) incrementLetterCount(c);
            }
            return Boolean.TRUE;
        } catch(Exception e){
            System.out.println("Read line error in scanDocument4Letters() for class Document  !");
            System.exit(-2);
        }
        return Boolean.FALSE;
    }

    static final int ALL_CHARACTER = 26;
    private BufferedReader bReader;
    private int documentSize;
    private int totalLetters;
    private Character[] characters;

public class Character{
    private char id;
    private int occurrence;

    public Character()
    {
        id = ' ';
        occurrence = 0;
    }

    public void setId(char l)
    {
        id = l;
    }

    public int getOccurrence()
    {
        return occurrence;
    }

    public int incrementOccurrence()
    {
        occurrence++;
        return occurrence;
    }
}

}
