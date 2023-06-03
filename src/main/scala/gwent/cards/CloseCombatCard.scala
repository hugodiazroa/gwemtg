
package cl.uchile.dcc
package gwent.cards

import java.util.Objects

/** Class representing a close combat unit card in the Gwen't game.
 *
 * A `CloseCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `CloseCombatCard` with a specified name, description, and
 *              power.
 * @param name the name of the card.
 * @param cost how much mana is required to cast a card
 * @param power the initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 *         (comenta en ingles)
 * @author hugodiazroa
 *         (comenta en espanxol)
 * @version 1.1
 * @since 1.0
 */
class CloseCombatCard(name: String, cost: Int, power: Int) extends AbstractUnitCard(name, cost, power){
  /** sobreescribimos hashCode para hacer classOf[UnitCard] */
  override def hashCode: Int = Objects.hash(classOf[CloseCombatCard], name, power, cost)

  /** sobreescribimos canEqual para hacer .isInstanceOf[UnitCard] */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CloseCombatCard]
  /* todavia redunda
  /** sobreescibimos equals para que compare los parametros nuevos de UnitCard */
  override def equals(uc: Any): Boolean = uc match {
    case uc: CloseCombatCard => uc.canEqual(this) && this.name == uc.name && this.power == uc.power && this.cost == uc.cost
    case _ => false
  }
  */
}


