package timesheet

class FreelancerBuilder {
  private var lastName: String = "Doe"
  private var email: String = "john.doe@foobar.com"

  def withEmail(email: String): FreelancerBuilder = {
    this.email = email
    this
  }

  def withLastName(lastName: String): FreelancerBuilder = {
    this.lastName = lastName
    this
  }

  def build(): Worker = {
    new Freelancer(lastName, email)
  }
}

object FreelancerBuilder {
  def aFreelancer(): FreelancerBuilder = new FreelancerBuilder()
}
