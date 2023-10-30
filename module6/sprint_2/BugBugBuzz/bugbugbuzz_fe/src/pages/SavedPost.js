import { Helmet } from 'react-helmet-async';
import { useState } from 'react';
import { Link as RouterLink } from 'react-router-dom';

// @mui
import { Container, Stack, Typography } from '@mui/material';

export default function SavedPost() {
    return (
        <>
            <Helmet>
                <title> Dashboard: Saved Post | Bugbugbuzz </title>
            </Helmet>

            <Container>
                <Typography variant="h4" sx={{ mb: 5 }}>
                    Saved Post
                </Typography>
                <Stack>
                    <Stack margin={3} textAlign="center">
                        <Typography>You have not save any post!</Typography>
                    </Stack>
                </Stack>
            </Container>
        </>
    );
}
