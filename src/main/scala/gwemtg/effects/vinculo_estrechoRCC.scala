package hugodiazroa
package gwemtg.effects

/**
 * vinculo_estrecho
 * this trait extends RangedCombatCards and grants the following effect:
 * all the units in the exact name in the zone duplicate their power
 */

import gwemtg.cards.*
import gwemtg.{Game, Player, cards}

class vinculo_estrechoRCC(name: String, description: String, power: Int, cmc: Int) extends RangedCombatCard(name, description, power, cmc)  {
  override def effect(player: Player, game: Game): Unit = {

    if (player == game.getP1) {
      for (card <- game.board.p1r.data) card.setPower(card.getPower + card.getPower)
    }

    if (player == game.getP2){
      for (card <- game.board.p2r.data) card.setPower(card.getPower + card.getPower)
    }
  }
}

