package hugodiazroa
package gwemtg.board

import gwemtg.cards.*

import scala.collection.immutable

/** Zone is an abstract class that represents a zone of the board.
  * A zone is a set of cards that share a common property.
  * Zones constitute the board of the game.
  * The board is composed of 7 zones:
  * - player 1's marginal: zone where siege combat cards are played.
  * - player 1's ranged: zone where ranged combat cards are played.
  * - player 1's melee: zone where close combat cards are played.
  * - climate: zone where climate cards are played.
  * - player 2's melee: zone where close combat cards are played.
  * - player 2's ranged: zone where ranged combat cards are played.
  * - player 2's marginal: zone where siege combat cards are played.
  *
  * @see [[cl.uchile.dcc.gwemtg.board.Board]]
  *
  * created in @version 11072023
  */

trait Zone {

}
