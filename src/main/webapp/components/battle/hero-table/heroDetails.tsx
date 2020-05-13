import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import { Table, TableBody, TableHead } from '@material-ui/core';
import React from 'react';
import HealthBar from '../../shared/healthBar/healthBar';
import { IHeroDetailsProps } from '../model/stateAndProps.interface';

export default function HeroDetails ({ hero }: IHeroDetailsProps) {
  return (
    <Table size="small" aria-label="purchases">
      <TableHead>
        <TableRow>
          <TableCell>Health</TableCell>
          <TableCell>Profession</TableCell>
          <TableCell>Actions</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        <TableRow key={hero.name}>
          <TableCell component="th" scope="row">
            <HealthBar
              value={hero.currentHP}
              maxValue={hero.baseHP}
            />
          </TableCell>
          <TableCell>{hero.profession.name}</TableCell>
          <TableCell>
            To be Populated with Actions
          </TableCell>
        </TableRow>
      </TableBody>
    </Table>
  )
}