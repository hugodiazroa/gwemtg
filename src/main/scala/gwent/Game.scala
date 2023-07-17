package cl.uchile.dcc
package gwent

import gwent.*
import gwent.board.*
import gwent.cards.*



/**
 * A class representing a game of Gwent.
 * @param board The board of the game.
 * @param player1 The first player of the game.
 * @param player2 The second player of the game.
 *
 * here the game is played, the players play their cards and the board is updated
 * here the design pattern observer is used, the board is the observable and the players are the observers
 * aswell as the design pattern factory is implemented here to create the decks of the players and the cards
 *
 */

class Game(val board: Board, private val _player1: Player, private val _player2: Player) {

  private def Player1 = _player1
  private def Player2 = _player2

  /** addCCC
   * adds a close combat card to the board
   */
  def addCCC(card: CloseCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
        board.p1m.data = card :: p1m.data
    } else if (player == this.Player2) {
        board.p2m.data = card :: p2m.data
    } else {
      throw new Exception("Player not found")
    }
  }


  /** addRCC
   * adds a ranged combat card to the board
   */
  def addRCC(card: RangedCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
      board.p1r.data = card :: p1r.data
    } else if (player == this.Player2) {
      board.p2r.data = card :: p2r.data
    } else {
      throw new Exception("Player not found")
    }
  }
  /** addSCC
   * adds a siege combat card to the board
   */
  def addSCC(card: SiegeCombatCard, player: Player): Unit = {
    if (player == this.Player1) {
      board.p1s.data = card :: p1s.data
    } else if (player == this.Player2) {
      board.p2s.data = card :: p2s.data
    } else {
      throw new Exception("Player not found")
    }
  }
  /** addWC
   * swaps the weather card of the board
   */
  def addWC(card: WeatherCard): Unit = {
    board.clima.data = List(card)
  }
}