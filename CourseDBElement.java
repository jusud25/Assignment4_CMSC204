/**
 * In this class, five attributes are created with a 
 * constructor that has five parameter variables,a
 * default constructor and other implementation.
 * @author Jusu Dukuly
 */
public class CourseDBElement implements Comparable{
        private String ID;
        private int CRN;
        private int nummberOfCredits;
        private String numberOfRoom;
        private String instructor;
        /**
         *constructor with parameter variables
         * @param i To initialize parameter variable i to ID
         * @param c To initialize parameter variable c
         * @param n To initialize parameter variable n
         * @param roomNum to initialize parameter variable room
         * @param instructor To initialize parameter variable in to instructorName
         */
        public CourseDBElement(String i, int c, int n, String room, String in) {
                ID = i;
                CRN = c;
                nummberOfCredits = n;
                numberOfRoom = room;
                instructor = in;
        }
        /**
         * Create a default constructor
         */
        public CourseDBElement() {
        	 ID = "";
             CRN = 0;
             nummberOfCredits = 0;
             numberOfRoom = "";
             instructor ="";
              
        }
        /**
         * @param a parameter variable CourseDBElement with the variable element
         * @return CRN
         */
        public int compareTo(CourseDBElement element) {
        	
                return CRN - element.CRN;
        }
        /**
         * @return return CRN
         */
        public int getCRN() {
                return CRN;
        }
        /**
         * @param crn sets crn to CRN
         */
        public void setCRN(int crn) {
                CRN = crn;
        }
        /**
         * Gets CRN and converts it into string, which return the hashcode of the string 
         * @return str.hashCode()
         */
        @Override
        public int hashCode() {
                String str = CRN + "";
                return str.hashCode();
        }
       /**
        * @param uses eql to make comparison
        * @return return true if the object is equal to the object argument
        */
        @Override
        public boolean equals(Object eql) {
                if (this ==eql)
                        return true;
                if (eql== null)
                        return false;
                if (getClass() != eql.getClass())
                        return true;
                CourseDBElement keep = (CourseDBElement) eql;
                if (CRN != keep.CRN)
                	return false;
                return true;
        }
        /**
         * @return to return the string of all the object
         */
        @Override
        public String toString() {
               return "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + nummberOfCredits + " Instructor:" + instructor + " Room:" + numberOfRoom;
               
        }
        /**
         * @return to return numberOfRoom
         */
		public Object getRoomNum() {
			// TODO Auto-generated method stub
			return numberOfRoom;
		}
		/**
		 * 
		 * @return return ID
		 */
		public Object getID() {
			// TODO Auto-generated method stub
			return ID;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
}

