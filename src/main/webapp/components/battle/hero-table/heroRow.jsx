import TableCell from '@material-ui/core/TableCell';
import TableRow from '@material-ui/core/TableRow';
import React from 'react';

export default function HeroRow({id, name, proffesion}) {
  return (
    <TableRow key={id}>
      <TableCell component="th" scope="row">
        {name}
      </TableCell>
      <TableCell align="right">{proffesion}</TableCell>
    </TableRow>
  )
}