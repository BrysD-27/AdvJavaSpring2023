import java.io.Serializable;

public class Person implements Serializable {

        private String firstName;
        private String lastName;
        // private OCCCDate dob;

        public Person(String firstName, String lastName) {
                super();
                this.firstName = firstName;
                this.lastName = lastName;
        }

        /*
         * public Person(String firstName, String lastName,OCCCDate dob) { super();
         * this.firstName = firstName; this.lastName = lastName; this.dob=dob; }
         */

        public Person(Person p) {
                this.firstName = p.firstName;
                this.lastName = p.lastName;
                // this.dob = p.dob;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        /*
         * public OCCCDate getDob() { return dob; }
         */

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        @Override
        public String toString() {
                // return firstName + " " + lastName + " " + dob;
                return firstName + " " + lastName;
        }

        /*
         * int getAge(){
         * 
         * }
         */

        public boolean equals(Person p) {
                if (firstName.equalsIgnoreCase(p.firstName) && lastName.equalsIgnoreCase(p.lastName)) {
                        return true;
                }
                return false;
        }
        
        void eat(){
                System.out.println(firstName + " " + lastName +" is Eating");
        }
        
        void sleep(){
                System.out.println(firstName + " " + lastName + " is Sleeping");
        }
        
        void play(){
                System.out.println(firstName + " " + lastName + " is Playing");
        }
        
        void run(){
                System.out.println(firstName + " " + lastName + " is Running");
        }

}