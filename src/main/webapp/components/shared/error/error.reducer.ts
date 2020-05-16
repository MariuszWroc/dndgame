import { SHOW_ERROR } from '../action.types';

export default function (state: any, action: any) {
  switch (action.type) {
    case SHOW_ERROR:
    default:
      return state;
  }
}