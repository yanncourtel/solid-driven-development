package house

case class CannotAssembleTinyHouseOnConcreteException()
  extends UnsupportedOperationException("Cannot build concrete base for tiny houses.") {
}
