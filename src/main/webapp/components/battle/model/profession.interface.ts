import { IHero } from './hero.interface';

export interface IProfession {
  id: number;
  name: string;
  strength: number;
  dexterity: number;
  constitution: number;
  intelligence: number;
  heroes: IHero[];
}