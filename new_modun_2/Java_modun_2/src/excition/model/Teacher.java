package excition.model;

public class Teacher extends Person{
    private String qualification;
    private double  experience;

    public Teacher() {
    }

    public Teacher(String qualification, double experience) {
        this.qualification = qualification;
        this.experience = experience;
    }

    public Teacher(double id, String name, String birthday, String grander, String qualification, double experience) {
        super(id, name, birthday, grander);
        this.qualification = qualification;
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getBirthday(),this.getGrander(),getQualification(),getExperience());
    }
}
