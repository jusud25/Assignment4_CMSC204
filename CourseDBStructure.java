import java.io.IOException;
import java.util.*;
/** 
 * @author Jusu Dukuly
 */
public class CourseDBStructure implements CourseDBStructureInterface {
       
		protected int size;
        protected LinkedList<CourseDBElement> hashTable[];
      
       
        
        /**
         * @param test initializes the size
         */
        @SuppressWarnings("unchecked")
        public CourseDBStructure(int test) {
                this.size = test;
                hashTable = new LinkedList[size];
        }
        /**
         * @param size sets size to the attribute size
         */
        @SuppressWarnings("unchecked")
        public CourseDBStructure(String str, int size) {
                this.size =size;
                hashTable = new LinkedList[size];
        }
        /**
         * @param CourseDBElement object and adds it to the hashtable.
         * If the index of the CRN is null, it creates new linked list.
         * Otherwise use bucket method.
         * @return will return the element of the object
         */
        @Override
        public void add(CourseDBElement element) {
                int index = element.hashCode() % size;
                if(hashTable[index] == null) {
                        hashTable[index] = new LinkedList<CourseDBElement>();
                }
                hashTable[index].add(element);
        }
        /**
         * @param method that gets CourseDBElement object in CRN.
         * If the index of crn does not exist in hashtable, throw IOException.
         * If it does exist, loops through the hashtable and its bucket
         */
        @Override
        public CourseDBElement get(int crn) throws IOException {
        	
        	 toString();
                String str = crn + "";
                int index = str.hashCode() % size;
                if(hashTable[index] == null) {
                        throw new IOException();
                }
                else {
                for(int i = 0; i < size; i++) {
                CourseDBElement temp = hashTable[index].get(i);
                 if(temp.getCRN() == crn) {
                   return temp;
                                }
                        }
               return null;
                }
        }
        /**
         * Method that gets the size of hashtable.
         * @return size
         */
        @Override
        public int getTableSize() {
                return size;
        }
	    @Override
		public ArrayList<String> showAll() {
	    
	    ArrayList<String>courseList=new ArrayList<>();
	  	for(int t=0; t<hashTable.length; t++) {
	  		LinkedList<CourseDBElement>list=hashTable[t];
	  		if(list!=null) {
	  			for(int i=0; i<list.size(); i++) {
	  				CourseDBElement element=list.get(i);
	  				courseList.add(element.toString());
	  			}
	  		}
	  	}
		return courseList;
	    }}
