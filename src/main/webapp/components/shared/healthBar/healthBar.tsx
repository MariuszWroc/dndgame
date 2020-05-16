import React from 'react';
import { lighten, LinearProgress, withStyles } from '@material-ui/core';

export default function HealthBar({value, maxValue}: { value: number, maxValue: number }) {
  const CustomBar = withStyles({
    root: {
      height: 10,
      backgroundColor: lighten('#00ff40', 0.5),
    },
    bar: {
      borderRadius: 20,
      backgroundColor: '#d2f00e',
    }
  })(LinearProgress);

  return (
    <>
      <CustomBar
        variant="determinate"
        value={value/maxValue*100}
        color="secondary"/>{value}/{maxValue}
    </>
  )
}