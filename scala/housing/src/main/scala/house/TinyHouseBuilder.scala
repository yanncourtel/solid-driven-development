package house

class TinyHouseBuilder extends HouseBuilder {
  override def assembleHouse(): Unit = {
    if (baseBuilt) {
      throw CannotAssembleTinyHouseOnConcreteException()
    } else {
      println("Assembling tiny house with screw system.")
    }
  }
}
