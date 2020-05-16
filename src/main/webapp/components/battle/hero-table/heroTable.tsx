import React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { makeStyles } from '@material-ui/core/styles';
import HeroRow from './heroRow';
import { IHero } from '../model/hero.interface';

const styling = makeStyles({
  fullTable: {
    height: '80vh'
  }
});

export default function HeroTable({heroes, activeIndex, isOpponent}: { heroes: IHero[], activeIndex: number, isOpponent: boolean }) {
  const tableStyle = styling();

  return <TableContainer component={Paper}>
    <Table aria-label="simple table" className={tableStyle.fullTable}>
      <TableHead>
        <TableRow>
          <TableCell>Hero name</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {heroes.map((hero, index) => (
          <HeroRow hero={hero} isActive={activeIndex === index} isOpponent={isOpponent}/>
        ))}
      </TableBody>
    </Table>
  </TableContainer>
}