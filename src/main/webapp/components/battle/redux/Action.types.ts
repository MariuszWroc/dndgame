import { IHero } from '../model/hero.interface';

export const GIVE_UP = 'GIVE_UP';
export const END_TURN = 'END_TURN';
export const UPDATE_DATA = 'UPDATE_DATA';
export interface IBattleActions {
  type: string;
  payload: string | [IHero[], IHero[]];
}