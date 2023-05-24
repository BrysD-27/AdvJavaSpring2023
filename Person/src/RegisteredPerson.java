public class RegisteredPerson extends Person {

        private String govID;

        /*
         * public RegisteredPerson(String firstName, String lastName,OCCCDate dob,
         * String govID) { super(firstName, lastName,dob); this.govID=govID; }
         */

        public RegisteredPerson(String firstName, String lastName, String govID) {
                super(firstName, lastName);
                this.govID = govID;
        }

        public RegisteredPerson(Person p, String govID) {
                super(p);
                this.govID = govID;
        }

        public RegisteredPerson(RegisteredPerson p) {
                // super(p.getFirstName(),p.getLastName(),p.getDob);
                super(p.getFirstName(), p.getLastName());
                this.govID = p.govID;
        }
        
        public String getGovID() {
                return govID;
        }

        boolean equals(RegisteredPerson p){
                if(p.getFirstName().equals(p.getFirstName()) && p.getLastName().equals(p.getLastName()) && p.govID.equals(govID)){
                        return true;
                }
                return false;
        }
        
        public boolean equals(Person p) {
                if(p.getFirstName().equals(p.getFirstName()) && p.getLastName().equals(p.getLastName())){
                        return true;
                }
                return false;
        }

        @Override
        public String toString() {
                return super.toString()+" "+govID;
        }       
}