import TableCell from '@material-ui/core/TableCell';
import TableRow from '@material-ui/core/TableRow';
import React from 'react';
import { Box, Collapse, Paper } from '@material-ui/core';
import HeroDetails from './heroDetails';
import { IHeroRowProps } from '../model/stateAndProps.interface';

export default function HeroRow({ hero, isActive, isOpponent }: IHeroRowProps) {
  return (
    <>
      <TableRow key={hero.name}>
        <TableCell component="th" scope="row">
          {hero.name}
        </TableCell>
      </TableRow>
      <TableRow>
        <Collapse in={isActive && !isOpponent} timeout="auto" unmountOnExit>
          <Box margin={2}>
            <Paper>
              <HeroDetails hero={hero}/>
            </Paper>
          </Box>
        </Collapse>
      </TableRow>
    </>
  )
}