import { IBattleState } from '../model/stateAndProps.interface';
import { END_TURN, GIVE_UP, IBattleActions, UPDATE_DATA } from './Action.types';
import { IHero } from '../model/hero.interface';

const initialState: IBattleState = {
  playerHeroes: [],
  opponentHeroes: []
}

export default function (state = initialState, action: IBattleActions) {
  switch(action.type) {
    case UPDATE_DATA:
      let [playerHeroes, opponentHeroes] : [IHero[], IHero[]] = action.payload as [IHero[], IHero[]];

      playerHeroes = playerHeroes.sort(
        (a, b) => b.speed - a.speed);

      opponentHeroes = opponentHeroes.sort(
        (a, b) => b.speed - a.speed);

      return {
        ...state,
        playerHeroes,
        opponentHeroes,
      }
    case END_TURN:
      alert(action.payload)

      return { ...state, status: 'Turn Complete'};
    case GIVE_UP:
      alert(action.payload);

      return { ...state, status: 'gaveUp'};
    default:

      return state;
  }
}