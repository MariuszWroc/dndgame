import { IProfession } from './profession.interface';
import { IItem } from './item.interface';


export interface IHero {
  name: string;
  speed: number;
  gender: number;
  race: number;
  profession: IProfession;
  baseHP: number;
  currentHP: number;
  baseAC: number;
  backpack: IItem[];
  armor: IItem;
  weapon: IItem;
  charms: IItem[];
}