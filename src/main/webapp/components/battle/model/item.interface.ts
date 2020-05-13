import { IEquipment } from './equipment.interface';


export interface IItem {
  id: number;
  name: string;
  category: string;
  attack: number;
  defend: number;
  magic: number;
  addHealth: number;
  addStrength: number;
  addDexterity: number;
  addConstitution: number;
  addIntelligence: number;
  amount: number;
  equipments: IEquipment[];
}