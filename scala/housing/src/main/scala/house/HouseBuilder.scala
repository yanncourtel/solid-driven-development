package house

abstract class HouseBuilder {

  var accessRoadBuilt = false
  var baseBuilt = false

  def buildAccessRoad(): Unit = {
    accessRoadBuilt = true
    println("Access road built.")
  }
  def buildBase(): Unit = {
    baseBuilt = true
    println("Concrete base built.")
  }

  def assembleHouse(): Unit

  def buildHouse(): Either[String, Boolean] = {
    try {
      buildAccessRoad()
      buildBase()
      assembleHouse()
      Right(true) // Return success only if all steps are completed without an exception
    } catch {
      case e: UnsupportedOperationException => Left(e.getMessage)
      case e: Exception => Left("An error occurred during building: " + e.getMessage)
    }
  }
}










