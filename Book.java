import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;



/**
 * @author anke
 *A class to represent and work with the input file of our book 
 */
public class Book {

	/**
	 * Instance variables (self explaining)
	 */
	String book;
	ArrayList<Chapter> chapters = new ArrayList<>();
	String author;
	String title;
	CheckChars characters;
	
	
	/**
	 * Class representing a book we want to process. Maybe from this class could all the other functionality spread
	 * out. 
	 */
	public Book() {
		
	}
	/**
	 * Constructor taking an input text file: in the file, we just need to have the plain chapters : take out beginning
	 * stuff and contents, plus end things!! 
	 * @param fileName
	 */
	public Book(String fileName) {
		try {
		book = readFile(fileName);
		Filter filter = new Filter("TI_Annotated.tsv");
		characters = new CheckChars(filter, "CharacterList_TI.txt");
		
		String[] ch = book.split("(?=CHAPTER [a-zA-Z]+)"); //problem: other books: other separators, could appear in text etc

		for (int i = 1; i < ch.length; i++) {
				String[] lines = ch[i].split(System.getProperty("line.separator"));//split chapter in lines
				Chapter chapter = new Chapter(ch[i]);//create a chapter
				if(lines[1] == null) {
				chapter.setTitle(lines[2]);//title is two lines under the chapter heading
				} else {
					chapter.setTitle(lines[1]);//in LOTF it is directly under
				}
				//System.out.println(chapter.getTitle());
				chapter.setNumber(lines[0].substring(7).trim());//chapter number is in chapter heading line at the end
				//System.out.println(chapter.getNumber());
				chapters.add(chapter);//add the chapter to the book's chapter list 
		}
		for (Chapter e : chapters) {
			System.out.println(e.getNumber());
			System.out.println(e.getTitle());
		}
		
		} catch (IOException e) {
			System.out.println("File not given or not specified.");
		}
		
	}

	private String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	public ArrayList<Chapter> getChapters() {
		return chapters;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public static void main(String[] args)
	{
		Book test1 = new Book("LordFlies.txt");
		
	}


}
