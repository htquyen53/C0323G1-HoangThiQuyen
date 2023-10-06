import {Typography, Box, Stack} from "@mui/material";


export default function Footer() {
    return (
        <Stack direction="row" sx={{background: 'red' }}>
            <Box sx={{display: 'flex', }}>
                <Typography variant='h5'>
                    Hello, guy!
                </Typography>
            </Box>
        </Stack>
    )
}