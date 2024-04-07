package application;

public class Student {
	private String name;
    private String id;
    private String email;
    private String gender;
    private boolean agreedToTerms;

    public Student(String name, String id, String email, String gender, boolean agreedToTerms) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.agreedToTerms = agreedToTerms;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public boolean isAgreedToTerms() {
        return agreedToTerms;
    }

}
