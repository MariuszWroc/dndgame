import React from 'react';
import Battle from '../battle'
import { AppBar } from '@material-ui/core';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import MenuIcon from '@material-ui/icons/Menu';

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
      root: {
          flexGrow: 1,
      },
      menuButton: {
          marginRight: theme.spacing(2),
      },
      title: {
          flexGrow: 1,
      },
  }),
);

export default function App() {
  const classes = useStyles();

  return <>
    <AppBar position="static">
      <Toolbar>
        <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
          <MenuIcon/>
        </IconButton>
        <Typography variant="h6" className={classes.title}>
          Battle
        </Typography>
        <Button color="inherit">Login</Button>
      </Toolbar>
    </AppBar>
    <Battle/>
  </>
}
