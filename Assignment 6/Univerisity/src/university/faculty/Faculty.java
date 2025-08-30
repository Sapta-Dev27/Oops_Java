package university.faculty;

public class Faculty {

    /*creating the dataMembers*/
    int facultyId;
    String facultyName;
    String facultyDept;
    String[] subjects = new String[5];

    /*faculty parameterized constructor*/
    public Faculty(int facultyId , String facultyName , String facultyDept , String [] subjects){
        this.facultyId=facultyId;
        this.facultyName=facultyName;
        this.facultyDept=facultyDept;
        this.subjects=subjects;
    }

    /*faculty default constructor*/
    public Faculty() {
        this.facultyId=0;
        this.facultyDept="";
        this.facultyName="";
        for(int i = 0 ; i < 5 ; i++){
            subjects[i]="";
        }
    }

    /*member methods : assignSubjects */
    public String[] assignedSubjects(){
        String[] assignedSubjects = new String[5];
        assignedSubjects= subjects;
        return assignedSubjects;
    }

    /*member methods : displayFacultyDetails*/
    public void displayFacultyDetails(){
        System.out.println("Faculty Id is" +facultyId);
        System.out.println("Faculty name is" + facultyName);
        System.out.println("Faculty dept is" + facultyDept);
        System.out.println("Assigned subjects of faculty are :");
        String[] getSubjets = assignedSubjects();
        for(int i = 0 ; i <5 ; i++){
            System.out.println( "Subject" + (i+1) + getSubjets[i] );
        }
    }
}
