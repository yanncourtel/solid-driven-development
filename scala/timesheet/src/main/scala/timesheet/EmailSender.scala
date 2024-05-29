package timesheet

class EmailSender {
  def send(email: Email): Unit = {
    println(s"To: ${email.to}, Subject: ${email.subject}, Message: ${email.message}")
  }
}
