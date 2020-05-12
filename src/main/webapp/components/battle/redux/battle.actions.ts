import { GIVE_UP, END_TURN } from './Action.types';

export const endTurn = (payload: { [key: string]: any }) => ({
  type: END_TURN,
  payload,
});

export const giveUp = (payload: { [key: string]: any }) => ({
  type: GIVE_UP,
  payload,
});
