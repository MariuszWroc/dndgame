import { IBattleState } from '../model/battleState.interface';
import { END_TURN, GIVE_UP, UPDATE_DATA } from './Action.types';

const initialState: IBattleState = {
  playerHeroes: [],
  opponentHeroes: []
}

export default function (state = initialState, action: any) {
  switch(action.type) {
    case UPDATE_DATA:
      console.log(action, state);
      const [plHeroes, opHeroes] = action.payload;

      return {
        ...state,
        playerHeroes: [...state.playerHeroes, ...plHeroes],
        opponentHeroes: [...state.opponentHeroes, ...opHeroes],
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