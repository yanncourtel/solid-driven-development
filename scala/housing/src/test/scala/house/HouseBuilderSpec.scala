package house

import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HouseBuilderSpec extends AnyFlatSpec with Matchers with BeforeAndAfter {

  "TraditionalHouseBuilder" should "follow the correct building sequence" in {
    val builder = new TraditionalHouseBuilder()
    builder.buildHouse() shouldBe Right(true)
  }

  "WoodChaletBuilder" should "follow the correct building sequence" in {
    val builder = new WoodChaletBuilder()
    builder.buildHouse() shouldBe Right(true)
  }

  "StoneHouseBuilder" should "follow the correct building sequence" in {
    val builder = new StoneHouseBuilder()
    builder.buildHouse() shouldBe Right(true)
  }

  "ModernConcreteHouseBuilder" should "follow the correct building sequence" in {
    val builder = new ModernConcreteHouseBuilder()
    builder.buildHouse() shouldBe Right(true)
  }

  "TinyHouseBuilder" should "follow a modified building sequence without a concrete base" in {
    val builder = new TinyHouseBuilder()
    builder.buildHouse() shouldBe Right(true)
  }
}
