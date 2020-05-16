import { IHero } from '../model/hero.interface';
import { SHOW_ERROR, UPDATE_DATA } from '../../shared/action.types';
import { IProfession } from '../model/profession.interface';
import { IItem } from '../model/item.interface';

const professions: IProfession[] = [{
    id: 0,
    name: 'Spectre',
    strength: 18,
    dexterity: 16,
    constitution: 15,
    intelligence: 14,
    heroes: []
  }, {
    id: 1,
    name: 'Shadow Broker',
    strength: 12,
    dexterity: 14,
    constitution: 12,
    intelligence: 20,
    heroes: []
  }, {
    id: 2,
    name: 'Turian Sniper',
    strength: 15,
    dexterity: 20,
    constitution: 14,
    intelligence: 15,
    heroes: []
  }, {
    id: 3,
    name: 'Krogan warlord',
    strength: 20,
    dexterity: 10,
    constitution: 18,
    intelligence: 14,
    heroes: []
  }, {
    id: 4,
    name: 'Quarian Engineer',
    strength: 10,
    dexterity: 18,
    constitution: 10,
    intelligence: 20,
    heroes: []
  }, {
    id: 5,
    name: 'Reaper',
    strength: 10,
    dexterity: 18,
    constitution: 10,
    intelligence: 20,
    heroes: []
  }
]

const getPlayerHeroes = (): Promise<IHero[]> => {
  return Promise.resolve([{
      name: 'Commander Shepard',
      speed: 9,
      gender: 1,
      race: 2,
      profession: professions[0],
      baseHP: professions[0].constitution * 10,
      currentHP: professions[0].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    }, {
      name: 'Liara T\'soni',
      speed: 6,
      gender: 0,
      race: 3,
      profession: professions[1],
      baseHP: professions[1].constitution * 10,
      currentHP: professions[1].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    }, {
      name: 'Garrus Vakarian',
      speed: 8,
      gender: 1,
      race: 4,
      profession: professions[2],
      baseHP: professions[2].constitution * 10,
      currentHP: professions[2].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    }, {
      name: 'Wrex Urdnot',
      speed: 4,
      gender: 1,
      race: 5,
      profession: professions[3],
      baseHP: professions[3].constitution * 10,
      currentHP: professions[3].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    }, {
      name: 'Tali Zorah vas normandy',
      speed: 7,
      gender: 0,
      race: 6,
      profession: professions[4],
      baseHP: professions[4].constitution * 10,
      currentHP: professions[4].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    }
  ])
}

const getOpponentHeroes = (): Promise<IHero[]> => {
  return Promise.resolve([
    {
      name: 'Reaper 1',
      speed: 6,
      gender: 0,
      race: 6,
      profession: professions[5],
      baseHP: professions[5].constitution * 10,
      currentHP: professions[5].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    },
    {
      name: 'Reaper 2',
      speed: 6,
      gender: 0,
      race: 6,
      profession: professions[5],
      baseHP: professions[5].constitution * 10,
      currentHP: professions[5].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    },
    {
      name: 'Reaper 3',
      speed: 6,
      gender: 0,
      race: 6,
      profession: professions[5],
      baseHP: professions[5].constitution * 10,
      currentHP: professions[5].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    },
    {
      name: 'Reaper 4',
      speed: 6,
      gender: 0,
      race: 6,
      profession: professions[5],
      baseHP: professions[5].constitution * 10,
      currentHP: professions[5].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    },
    {
      name: 'Reaper 5',
      speed: 6,
      gender: 0,
      race: 6,
      profession: professions[5],
      baseHP: professions[5].constitution * 10,
      currentHP: professions[5].constitution * 10,
      baseAC: 30,
      backpack: [],
      armor: {} as IItem,
      weapon: {} as IItem,
      charms: [],
    }
  ])
}

export const getPlayerAndOpponentHeroes = () =>
  (dispatch: any) => {
    Promise.all([getPlayerHeroes(), getOpponentHeroes()])
      .then((payload) => {

        dispatch({
          type: UPDATE_DATA,
          payload
        });
      })
      .catch(err => {

        dispatch({
          type: SHOW_ERROR,
          payload: err
        });
      });
  };