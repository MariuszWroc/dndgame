import { IHero } from './hero.interface';

export interface IBattleState {
  playerHeroes: IHero[];
  opponentHeroes: IHero[];
}

export interface IBattleProps {
  giveUp: (content: any) => void;
  endTurn: (content: any) => void;
  getPlayerAndOpponentHeroes: () => void;
}