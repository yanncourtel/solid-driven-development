package timesheet;

import java.time.LocalDate;

public class FreelancerBuilder {
    private String lastName = "Doe";
    private String email = "john.doe@foobar.com";

    public static FreelancerBuilder aFreelancer(){
        return new FreelancerBuilder();
    }

    public FreelancerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }


    public FreelancerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Freelancer build(){
        return new Freelancer(lastName, email);
    }
}
