import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';

interface IProps {
  handleChange: (event: React.ChangeEvent<{ name?: string; value: unknown }>) => void;
}

export default function TextFieldComp(props: IProps) {

  return (
    <Box
      component="form"
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <div>

        <TextField
          id="outlined-multiline-static"
          label="Text"
          multiline
          name="text"
          rows={20}
          onChange={props.handleChange}
          defaultValue="."
        />
      </div>

    </Box>
  );
}
