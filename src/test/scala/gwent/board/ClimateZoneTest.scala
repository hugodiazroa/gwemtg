package cl.uchile.dcc
package gwent.board

import gwent.cards.*
import gwent.Player
import munit.*
class ClimateZoneTest extends munit.FunSuite{
  /** tablero vacio */
  var tablero1: Board = new Board()
  var tablero2: Board = _
  var tablero3: Board = _

  var zona1siege: MarginalZone = _
  var zona1range: RangeZone = _
  var zona1melee: MeleeZone = _
  var zonaclimate: ClimateZone = _
  var zona2melee: MeleeZone = _
  var zona2range: RangeZone = _
  var zona2siege: MarginalZone = _

  var troop1: CloseCombatCard = new CloseCombatCard("troop1", "pedro", 1)
  var troop2: CloseCombatCard = new CloseCombatCard("troop2", "pablo", 2)
  var troop3: CloseCombatCard = new CloseCombatCard("troop3", "jose", 3)

  var ranged1: RangedCombatCard = new RangedCombatCard("ranged1", "eliana", 1)
  var ranged2: RangedCombatCard = new RangedCombatCard("ranged2", "maria", 2)
  var ranged3: RangedCombatCard = new RangedCombatCard("ranged3", "alia", 3)

  var catapult1: SiegeCombatCard = new SiegeCombatCard("catapult1", "isis", 1)
  var catapult2: SiegeCombatCard = new SiegeCombatCard("catapult2", "dracula", 2)
  var catapult3: SiegeCombatCard = new SiegeCombatCard("catapult3", "atenea", 3)


  var jugador: Player = _

  var climate1: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    climate1 = new WeatherCard("climate1", "lluvia")

    tablero1 = new Board()
    tablero2 = new Board(new MarginalZone(List(catapult1, catapult2, catapult3)), new RangeZone(List(ranged1, ranged2, ranged3)), new MeleeZone(List(troop1, troop2, troop3)), new ClimateZone(List(climate1)), new MeleeZone(List(troop1, troop2, troop3)), new RangeZone(List(ranged1, ranged2, ranged3)), new MarginalZone(List(catapult1, catapult2, catapult3)))
    zona1siege = new MarginalZone(List(catapult1, catapult2, catapult3))
    zona1range = new RangeZone(List(ranged1, ranged2, ranged3))
    zona1melee = new MeleeZone(List(troop1, troop2, troop3))
    zonaclimate = new ClimateZone(List(climate1))
    zona2melee = new MeleeZone(List(troop1, troop2, troop3))
    zona2range = new RangeZone(List(ranged1, ranged2, ranged3))
    zona2siege = new MarginalZone(List(catapult1, catapult2, catapult3))
    tablero3 = new Board(zona1siege, zona1range, zona1melee, zonaclimate, zona2melee, zona2range, zona2siege)

    troop1 = new CloseCombatCard("troop1", "pedro", 1)
    troop2 = new CloseCombatCard("troop2", "pablo", 2)
    troop3 = new CloseCombatCard("troop3", "jose", 3)

    ranged1 = new RangedCombatCard("ranged1", "eliana", 1)
    ranged2 = new RangedCombatCard("ranged2", "maria", 2)
    ranged3 = new RangedCombatCard("ranged3", "alia", 3)

    catapult1 = new SiegeCombatCard("catapult1", "isis", 1)
    catapult2 = new SiegeCombatCard("catapult2", "dracula", 2)
    catapult3 = new SiegeCombatCard("catapult3", "atenea", 3)

    jugador = new Player("Hugo", 2, List(troop1, troop3, ranged1, ranged3, catapult1, catapult3), List(troop2, ranged2, catapult2))
  }

  test("constructor"){
    assertEquals(tablero1, new Board())
    assertEquals(tablero2, new Board(zona1siege, zona1range, zona1melee, zonaclimate, zona2melee, zona2range, zona2siege))
  }

  test("test for equals") {
    assertEquals(zonaclimate, new ClimateZone(List(climate1)))
    assertNotEquals(zonaclimate, new ClimateZone(List(new WeatherCard("climate2", "nieve"))))
    assertEquals(zonaclimate, zonaclimate, "zonaclimate should be equal to itself")
  }

  test("test for hashCode") {
    assertEquals(zonaclimate.hashCode(), new ClimateZone(List(climate1)).hashCode())
    assertNotEquals(zonaclimate.hashCode(), new ClimateZone(List(new WeatherCard("climate2", "nieve"))).hashCode())
  }
}
