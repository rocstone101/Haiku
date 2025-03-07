import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Random;

/**
 * (a.) Creates a Haiku, which is a Japanese poem that has three lines about 
 * animals and nature.
 *
 * @author Ryan Clarke
 * 
 * @version 14.01.2025
 */
public class Main {
    public static void main(String[] args) {
        public class Haiku
        {
            private TreeMap <Integer, ArrayList<String>> words;
            private Random ran;
        
            /**
             * (b.)Constructor for objects of class Haiku.  
             */
            public Haiku()
            {
                words = new TreeMap<>();
                ran = new Random();
            }
        
            /**
             * (c.)Populates the words map with a list of words with corresponding
             * syllables.
             */
            private void populate()
            {
                words.put(1, new ArrayList<>());
                words.get(1).add("tree");
                words.get(1).add("bush");
                words.get(1).add("lush");
                words.get(1).add("rat");
                words.get(1).add("spring");
                words.get(1).add("wood");
                words.get(1).add("grass");
                words.get(1).add("rain");
                words.get(1).add("bug");
                words.get(1).add("grove");
        
                words.put(2, new ArrayList<>());
                words.get(2).add("jungle");
                words.get(2).add("forest");
                words.get(2).add("tiger");
                words.get(2).add("monkey");
                words.get(2).add("treetop");
                words.get(2).add("wetland");
                words.get(2).add("humid");
                words.get(2).add("panda");
                words.get(2).add("biome");
                words.get(2).add("flower");
                words.get(2).add("macaw");
                words.get(2).add("weather");
        
                words.put(3, new ArrayList<>());
                words.get(3).add("gorilla");
                words.get(3).add("oasis");
                words.get(3).add("inhabit");
                words.get(3).add("iguana");
                words.get(3).add("savanna");
                words.get(3).add("rainforest");
                words.get(3).add("tropical");
                words.get(3).add("canopy");
        
                words.put(4, new ArrayList<>());
                words.get(4).add("vegetation");
                words.get(4).add("indigenous");
                words.get(4).add("ecosystem");
                words.get(4).add("tarantula");
                words.get(4).add("aquaculture");
                words.get(4).add("ambiguous");
                words.get(4).add("evolution");
        
                words.put(5, new ArrayList<>());
                words.get(5).add("representation");
                words.get(5).add("photosynthesis");
                words.get(5).add("astonishingly");
                words.get(5).add("beautification");
                words.get(5).add("quantifiable");
                words.get(5).add("transformational");
        
                words.put(6, new ArrayList<>());
                words.get(6).add("biodiversity");
                words.get(6).add("abstractification");
                words.get(6).add("misclassification");
        
                words.put(7, new ArrayList<>());
                words.get(7).add("hypersensitivity");
                words.get(7).add("polyunsaturated");
        
            }
        
            /**
             * (d.)Prints the content of words map.
             */
            private void printWords()
            {
                for (Integer key : words.keySet()) {
                    System.out.print(key + " -> ");
                    for (String word : words.get(key)){
                        System.out.print(word + " ");
                    }            
                    System.out.println();                
                } 
            }
        
            /**
             * (e.) Adds a word to the words map.
             * 
             * @param syllables Indicates the number of syllables associated  with the
             * new word.
             * whilst assuming that the value of the first parameter agrees with the
             * actual number of syllables.
             * 
             * @param newWord The new word intended to be added to the list.
             */
            private void addWord(int syllables, String newWord)
            {        
                if (syllables < 1 || syllables > 7) {
                    return; 
                }
        
                String finalWord = newWord.toLowerCase().trim();
                ArrayList<String> wordList = words.get(syllables);
                
                if (!wordList.contains(finalWord)){
                    words.get(syllables).add(finalWord);
                } 
                else {
                    return; 
                }
            }
        
            /**
             * (f.)Creates a single line of the poem.
             * 
             * @param totalNumOfSyllables Indicates how many syllables the line should
             * have in total.
             * 
             * @return A single line of poem.
             */
            private String makeLine(int totalNumOfSyllables)
            {
                populate();               
                ArrayList<String> usedWords = new ArrayList<>();
                int remainingSyllables = totalNumOfSyllables;
                String newLine = "";
        
                while (remainingSyllables > 0){
        
                    int maxSyllables = remainingSyllables;
                    if (maxSyllables > words.lastKey()) {
                        maxSyllables = words.lastKey();
                    }
        
                    int nextWordSyllables = 1 + ran.nextInt(maxSyllables);
        
                    ArrayList<String> wordList = words.get(nextWordSyllables);
                    String word = wordList.get(ran.nextInt(wordList.size()));
        
                    if (usedWords.contains(word)){                        
                        break;
                    } 
                    newLine += word + " "; 
                    remainingSyllables -= nextWordSyllables;
                    usedWords.add(word);
                } 
        
                return newLine;
            } 
            
            /**
             * (g.)Generates and prints the three lines of a haiku, each on a separate 
             * line with set syllable counts.
             */
            
            public void printHaiku()
            {        
                System.out.println(makeLine(5));
                System.out.println(makeLine(7));
                System.out.println(makeLine(5));                
            }
        }
    }

