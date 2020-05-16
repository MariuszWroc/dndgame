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

export interface IHeroRowProps {
  hero: IHero;
  isActive: boolean;
  isOpponent: boolean;
}

export interface IHeroDetailsProps {
  hero: IHero;
}