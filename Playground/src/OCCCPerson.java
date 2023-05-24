public class OCCCPerson extends RegisteredPerson {

        private String studentID;

        public OCCCPerson(RegisteredPerson p, String studentID) {
                super(p);
                this.studentID = studentID;
        }
        
        public OCCCPerson(OCCCPerson p) {
                super(p.getFirstName(), p.getLastName(), p.getGovID());
                this.studentID = p.studentID;
        }
        
        public OCCCPerson(String firstName, String lastName, String govID, String studentID) {
        	super(firstName, lastName, govID);
        	this.studentID = studentID;
        }

        public String getStudentID() {
                return studentID;
        }

        boolean equals(RegisteredPerson p) {
                if (p.getFirstName().equals(p.getFirstName()) && p.getLastName().equals(p.getLastName())
                                && p.getGovID().equals(getGovID())) {
                        return true;
                }
                return false;
        }

        public boolean equals(Person p) {
                if (p.getFirstName().equals(p.getFirstName()) && p.getLastName().equals(p.getLastName())) {
                        return true;
                }
                return false;
        }

        public boolean equals(OCCCPerson p) {
                if (p.getFirstName().equals(p.getFirstName()) && p.getLastName().equals(p.getLastName())
                                && p.getGovID().equals(getGovID()) && p.studentID.equals(studentID)) {
                        return true;
                }
                return false;
        }

        @Override
        public String toString() {
                return super.toString()+ " " + studentID;
        }

}