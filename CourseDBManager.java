
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author Jusu Dukuly
 */
public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure CDS = new CourseDBStructure(15);
	/**
	 *uses the add method from the CourseDBStructure class.
	 */
	@Override
	public void add(String i, int c, int credits, String room, String instr) {
		CourseDBElement elements = new CourseDBElement(i, c, credits, room, instr);
		CDS.add(elements);
	}
	/**
	 * uses the get method from CourseDBStructure class.
	 * @return will return CourseDBElement
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return CDS.get(crn);
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}
	/**
	 * this method will take the given File object and will 
	 * create CourseDBElement objects from the values on each line.
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner scanner = new Scanner(input);
			while(scanner.hasNext()) {
				String id = scanner.next();
				int crn = scanner.nextInt();
				int numCredits = scanner.nextInt();
				String roomNum =scanner.next();
				String instructor =scanner.nextLine();
				add(id, crn, numCredits, roomNum, instructor);
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.print("The file is not found");
			e.getMessage();
		}
	}
	/**
	 * a method that loops through the hashtable and its buckets
	 * and this method also turns CourseDBElement object into a string that 
	 * that is stored into the ArrayList.
	 * @return stoll
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> stoll = new ArrayList<String>();
		//Loop through hash table
		for (int i = 0; i<CDS.hashTable.length; i++) { 
			LinkedList<CourseDBElement> list = CDS.hashTable[i];
			if(list != null) {
				//loop through bucket
				for(int p = 0; p < list.size(); p++) { 
					CourseDBElement element = list.get(p);
					stoll.add(element.toString());

				}
			}
		}

		return stoll;
	}

}
