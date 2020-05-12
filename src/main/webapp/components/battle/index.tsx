import React, { useEffect } from 'react'
import { connect, useDispatch } from 'react-redux';
import { endTurn, giveUp } from './redux/battle.actions';
import HeroTable from './hero-table/heroTable';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import styles from './battle.module.scss';
import { getPlayerAndOpponentHeroes } from './redux/selector.actions';
import { IBattleState, IBattleProps } from './model/battleState.interface';

function BattleComponent ({ playerHeroes, opponentHeroes, giveUp, endTurn, getPlayerAndOpponentHeroes }: IBattleProps & IBattleState) {
  const dispatch = useDispatch();
  useEffect(() => {
    getPlayerAndOpponentHeroes()
  }, [])

  return (
    <div>
      <Grid className={styles.gameArea} container>
        <Grid item xs={6}>
          <Paper>
            <HeroTable heroes={playerHeroes} isOpponent="false"/>
          </Paper>
        </Grid>
        <Grid item xs={3}>
          <Paper className={styles.gameArea}>
            <img className={styles.gameArea} src="https://gamespuff.com/wp-content/uploads/slider3/opm_saitama.png" alt="Hero"/>
          </Paper>
        </Grid>
        <Grid item xs={3}>
          <Paper>
            <HeroTable heroes={opponentHeroes} isOpponent="true"/>
          </Paper>
        </Grid>
      </Grid>
      <Grid className={styles.actions} container>
        <Grid item xs={6}>
          <Paper>
            <Button className={styles.fill} onClick={() => dispatch(endTurn('I end my turn'))} variant="outlined" color="primary">End turn</Button>
          </Paper>
        </Grid>
        <Grid item xs={3}>
        </Grid>
        <Grid item xs={3}>
          <Paper>
            <Button className={styles.fill} onClick={() => dispatch(giveUp('I give up'))} variant="outlined" color="secondary">Give up</Button>
          </Paper>
        </Grid>
      </Grid>
    </div>
  )
}

const mapStateToProps = (state: { battle: IBattleState }) => {
  console.log(state, 'State update');
  const { playerHeroes, opponentHeroes } = state.battle;

  return {
    ...state,
    playerHeroes: playerHeroes ?? [],
    opponentHeroes: opponentHeroes ?? []
  }
}

const mapDispatchToProps = (dispatch: any) => ({
  endTurn,
  giveUp,
  getPlayerAndOpponentHeroes: () => dispatch(getPlayerAndOpponentHeroes())
})

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(BattleComponent)