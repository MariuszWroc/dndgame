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

const styling = makeStyles({
  fullTable: {
    height: '80vh'
  }
});

export default function HeroTable({heroes, isOpponent}: { heroes: {[key: string]: any}, isOpponent: string }) {
  const tableStyle = styling();

  return <TableContainer component={Paper}>
    <Table aria-label="simple table" className={tableStyle.fullTable}>
      <TableHead>
        <TableRow>
          <TableCell>Hero name</TableCell>
          <TableCell align="right">profession</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {heroes.map((hero: {[key: string]: any}) => (
          <HeroRow id={hero.id} name={hero.name} proffesion={hero.proffesion}/>
        ))}
      </TableBody>
    </Table>
  </TableContainer>
}