/**
 * AbstractPlayer
 * esta clase es una abstracion de los actores que toman las decisiones en el TCG Gwent
 * a partir de ella se implementan los jugadores humanos Player y npcs ComputerPlayer
 *
 * @author Hugo Diaz
 * @since 1.0.0
 * @version 2.1.0
 */


package cl.uchile.dcc
package gwent.Player


import cl.uchile.dcc.gwent.Carta.Carta
import java.util.Objects
import scala.collection.mutable
import scala.util.Random


abstract class AbstractPlayer(val name: String, var deck: List[Carta]) {
  /**
   * side representa el lado del tablero poseido por un jugador
   * su tipo es Tuple(List[Carta],List[Carta],List[Carta])
   * */
  private var side: (List[Carta], List[Carta], List[Carta]) = (List(),List(),List())
  /**
   * hand representa la mano de cartas de un jugador
   * comienza vacia
   */
  private var hand : List[Carta] = List()
  /**
   * gems representa las vidas del jugador, llamadas gemas
   * comienza en 2 y al ser 0 o menor el jugador muere y su oponente gana
   */
  private var gems : Int = 2
  /** initialDeckSize es una constante, 25, que es el unico valor valido para el largo de una mazo */
  val initialDeckSize: Int = 25

  /** funcion para obtener el lado */
  def getSide : Tuple = side
  /** funcion para obtener la mano */
  def getHand : List[Carta] = hand
  /** funcion para obtener las vidas */
  def getGems : Int = gems
  /**
   * compromiso
   * hashCode
   * hashCode: -> Int
   * crea una llave a partir de algo
   * este algo deberia ser los componentes de player
   */
  override def hashCode: Int

  /** verificamos que initialDeckSize sea 25 */
  require(initialDeckSize == 25)

  /**
   * compromiso
   * canEqual
   * canEqual: any -> Boolean
   * verifica si se puede comparar dos objetos al poder ser instanciado como la clase AbstractPlayer
   */
  def canEqual(that: Any): Boolean

  /**
   * equals
   * equals: any -> Boolean
   * verifica si todos los campos
   */
  override def equals(ap: Any): Boolean = ap match {
    case ap: AbstractPlayer => ap.canEqual(this) &&  this.getSide == ap.getSide && this.getHand == ap.getHand && this.getGems == ap.getGems && this.initialDeckSize == ap.initialDeckSize && this.## == ap.##
    case _ => false
  }
  /** compromiso para sobreescribir toString */
  override def toString: String

  /**
   * funcion que pone una carta en el indice i del mazo
   * comienza desde el indice cero en la carta superior del mazo
   * tambien acepta numeros negativos, siendo -1 el fondo del mazo
   */
  def CartaIn(carta: Carta, i: Double): Unit = {
    var indice = i.asInstanceOf[Int]

    /** caso i = 0 */
    if (i == 0) {
      deck = List(carta) ::: deck.drop(0)
    } else {
      /** poner la carta en una posicion indice */
      if (i > 0) {
        deck = deck.take(indice) ::: List(carta) ::: deck.drop(indice)
      } else {
        /** caso borde i == -1 */
        if (i == (-1).asInstanceOf[Double]) {
          deck = deck.take(deck.length) ::: List(carta)
        }

        /** pora poner la carta se recorre el mazo desde el final para los Double < 0 */
        else {
          /** indice dentro del rango */
          assert {
            deck.length >= indice
          }

          /** indice = i+1 */
          indice = (deck.length.asInstanceOf[Double] + i).asInstanceOf[Int] + 1

          /** caso inverso a i>0 */
          deck = deck.take(indice) ::: List(carta) ::: deck.drop(indice)
        }
      }
    }
  }

  /** funcion que pone una carta en el indice i del mazo */
  def CartaInDeck(carta: Carta): Unit = {
    /** pone una carta en el mazo (arriba) */
    CartaIn(carta, 0)

    /** baraja */
    deck = Random.shuffle(deck)
  }
  /** funcion draw es analoga a pop y devuelve la carta robada */
  def draw(): Carta = {
    /** carta robada */
    val h = deck.head
    /** el mazo pierde la carta superior */
    deck = deck.drop(1)
    return h
  }

  /**
   * metodo que representa jugar una carta
   *
   * la indexacion es la siguiente
   * 1 propio asedio
   * 2 pripio rango
   * 3 propio mele
   * 4 contrario mele
   * 5 contrario rango
   * 6 contrario asedio
   */
/*
  def play(Carta: Carta, index: Int): Unit ={
    /** el indice index debe estar entre 1 y 6 */
    assert{0 < index}
    assert{index < 7}
    /** el tipo de Carta debe poder lanzarse a la zona en la zona que representa index */
    //do stuff
  }
*/
}

