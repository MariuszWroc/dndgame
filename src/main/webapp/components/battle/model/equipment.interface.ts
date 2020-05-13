import { IHero } from './hero.interface';
import { IItem } from './item.interface';

export interface IEquipment {
  id: number;
  hero: IHero;
  items: IItem[];
}