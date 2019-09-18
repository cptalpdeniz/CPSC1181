
/**
 * transtaltes a given line based on the difinition of each word in file core-wordnet.txt
 *
 * @author jmadar 
 * @author hdarbandi
*/
 

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class WordsDefinition {
    
    private ArrayList<EachWord> dictionary;
    
    public WordsDefinition() {        
        try {
            getWords("core-wordnet.txt");
        } catch (IOException ex) {
            System.out.println("Error: Cannot read file. " + ex);
        }       
    }
    
    /**
    * Returns the definition of each word be calling searchDefinition(aWord)
    * @return 
    */
    public String getDefinition(String line) {
        //*** your code goes here       
        String[] word = line.split(" ");
        String[] definitions = new String[word.length];
        String returnStr = "";
        for (int i = 0; i < word.length; i++)
        {
            definitions[i] = searchDefinition(word[i]);
        }
        for (int i = 0; i < word.length; i++)
        {
            if (definitions[i] == null)
            {
                definitions[i] = "not found";
            }
            returnStr += word[i] + ": " + definitions[i] + "\n";
        }
        return returnStr;
    } 
    
    public String getDefinitionCommandLine(String line) {
        //*** your code goes here       
        String[] word = line.split(" ");
        String[] definitions = new String[word.length];
        String returnStr = "";
        for (int i = 0; i < word.length; i++)
        {
            definitions[i] = searchDefinition(word[i]);
            if (definitions[i] != null)
            {
                definitions[i] = definitions[i].trim();
            }
        }
        for (int i = 0; i < word.length; i++)
        {
            if (definitions[i] != null)
            {
                returnStr += "[" + definitions[i] + "] ";
            }
            else
            {
                returnStr += word[i] + " ";
            }
        }
        return returnStr;
    } 

    /**
    * Search ArrayList for meaning of a word and returns it.
    * @return meaning in case of success 
    *           otherwise returns null
    */
    private String searchDefinition(String theWord) {
      
        //*** your code goes here
        theWord = theWord.toLowerCase();
        String def = null;
        for (EachWord wordObj : dictionary)
        {
            if (wordObj.getWord().equals(theWord))
            {
                if (wordObj.getMeaning() == null)
                {
                    def = null;
                }
                else
                {
                    def = wordObj.getMeaning();
                }
                break;
            }
        }
        if (def != null)
        {
            return def;
        }
        return null;
    }   
    
    
            
    /**
     * Given a file, return all the lines in an array for easy processing
     */
    private void getWords(String dictionaryFile) throws IOException {
        dictionary = new ArrayList<EachWord>();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(dictionaryFile)));
        while (true) {
            String line = in.readLine();
            if (line == null) 
                break;
            line = line.trim();
            if(line.length()==0)
                continue;
            dictionary.add(new EachWord(line));        
        }
     
    
    }
   
}

