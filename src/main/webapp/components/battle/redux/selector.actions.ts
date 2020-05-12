import { IHero } from '../model/hero.interface';
import { SHOW_ERROR, UPDATE_DATA } from '../../shared/action.types';

const getPlayerHeroes = (): Promise<IHero[]> => {
  return Promise.resolve([
    {
      name: 'Commander Shepard',
      profession: 'Spectre'
    },
    {
      name: 'Liara T\'soni',
      profession: 'Shadow Broker'
    },
    {
      name: 'Garrus Vakarian',
      profession: 'Turian Sniper'
    },
    {
      name: 'Wrex Urdnot',
      profession: 'Krogan warlord'
    },
    {
      name: 'Tali Zorah vas normandy',
      profession: 'Quarian Engineer'
    }
  ])
}

const getOpponentHeroes = (): Promise<IHero[]> => {
  return Promise.resolve([
    {
      name: 'Reaper 1',
      profession: 'Reaper 1'
    },
    {
      name: 'Reaper 2',
      profession: 'Reaper 2'
    },
    {
      name: 'Reaper 3',
      profession: 'Reaper 3'
    },
    {
      name: 'Reaper 4',
      profession: 'Reaper 4'
    },
    {
      name: 'Reaper 5',
      profession: 'Reaper 5'
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