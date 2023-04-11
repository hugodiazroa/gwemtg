
import cl.uchile.dcc.gwent.Card.Card
import cl.uchile.dcc.gwent.Player.{ComputerPlayer, Player}
import munit.*

/**
 * AbstractPlayerTest debuggado por
 *
 * Tests para la clase AbstractPlayerTest que representa jugadores tanto humanos como no
 *
 * @author Hugo Diaz *
 * @since 1.1.1
 * @version 1.1.1
 */

abstract class AbstractPlayerTest extends munit.FunSuite {

  var cero: Card = _
  var uno: Card = _
  var dos: Card = _
  var tres: Card = _
  var jugador: Player = _
  var npc: ComputerPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    cero = new Card("Card 0")
    uno = new Card("Card 1")
    dos = new Card("Card 2")
    tres = new Card("Card 3")
    jugador = new Player("Hugo", List(uno,dos))
    npc = new ComputerPlayer("Marvin", List(cero,uno))
  }

  test("crear un jugador humano con un mazo y un nombre deberia tener los mismos atributos que los puestos") {
    var esperado = new Player("Hugo", List(uno, dos))
    assertEquals(jugador.name, esperado.name, "los nombres no coinciden")
    assertEquals(jugador.deck, esperado.deck, "los mazos no coinciden")
  }

  test("crear un jugador automata con un mazo y un nombre deberia tener los mismos atributos que los puestos") {
    var esperado = new ComputerPlayer("Marvin", List(cero, uno))
    assertEquals(npc.name, esperado.name, "los nombres no coinciden")
    assertEquals(npc.deck, esperado.deck, "los mazos no coinciden")
  }

  test("anxadir una carta sobre el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, 0)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.head, tres, "la carta no fue anxadida arriba")
    assertEquals(jugador.deck(0), tres, "la carta no fue anxadida arriba")
    assertEquals(jugador.deck, List(tres, uno, dos), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, -1)
    //assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    //assertEquals(jugador.deck.last, tres, "la carta no fue anxadida abajo")
    //assertEquals(jugador.deck(jugador.deck.length-1), tres, "la carta no fue anxadida abajo")
    //assertEquals(jugador.deck, List(uno, dos, tres), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, 1)
    assertEquals(jugador.deck.size, 3, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck(1), tres, "la carta fue anxadida en el indice 1")
    assertEquals(jugador.deck, List(uno, tres, dos), "los mazos no coinciden")
  }

  test("anxadir una carta bajo el mazo de un jugador deberia aumentar su tamanxo y quedar al principio") {
    println(jugador.deck.size)
    println(jugador.deck.length)
    assertEquals(jugador.deck.length, 2, "mazo de distinto tamanxo al esperado")
    jugador.cardIn(tres, -2)
    println(jugador.deck.size)
    println(jugador.deck.length)
    assertEquals(jugador.deck.length, 4, "mazo de distinto tamanxo al esperado")
    assertEquals(jugador.deck.last, tres, "la carta no fue anxadida en el indice -2")
    assertEquals(jugador.deck(jugador.deck.length - 2), tres, "la carta no fue anxadida en el indice -2")
    assertEquals(jugador.deck, List(uno, tres, dos), "los mazos no coinciden")
    //// ??????????????????????????
    assert(false)
  }


  test("robar una carta al mazo del jugador deberia disminuir su tamanxo y termimnar siendo mas pequenxo") {
    assertEquals(jugador.deck.size, 2, "mazo de distinto tamanxo al esperado")
    val robada: Card = jugador.robar()
    //assertEquals(type(robada), Card, "carta robada es tipo carta")
    assertEquals(robada, uno, "no se robo la carta esperada 'uno'")
    assertEquals(jugador.deck.size, 1, "mazo de distinto tamanxo al esperado")
  }

}