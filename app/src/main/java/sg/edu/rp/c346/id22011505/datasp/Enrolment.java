package sg.edu.rp.c346.id22011505.datasp;

public class Enrolment {
    private int Year;
    private String study;
    private int enrolment;

    public Enrolment(int Year, String study, int enrolment){
        this.Year = Year;
        this.study = study;
        this.enrolment = enrolment;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "Year=" + Year +
                ", study='" + study + '\'' +
                ", enrolment=" + enrolment +
                '}';
    }
}
