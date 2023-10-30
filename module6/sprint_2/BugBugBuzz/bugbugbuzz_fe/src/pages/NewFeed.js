import { Box, Button, Container, Stack, TextField, Typography, List, ListItem, ListItemText, ListItemAvatar } from '@mui/material';
import { Helmet } from 'react-helmet-async';
import React, { useState, useEffect } from 'react';
import Stomp from 'stompjs';
import SockJs from 'sockjs-client';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
// import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import ImageIcon from '@mui/icons-material/Image';
import AttachFileIcon from '@mui/icons-material/AttachFile';
import AddReactionOutlinedIcon from '@mui/icons-material/AddReactionOutlined';
import SendIcon from '@mui/icons-material/Send';
import ForumRoundedIcon from '@mui/icons-material/ForumRounded';
import TurnedInOutlinedIcon from '@mui/icons-material/TurnedInOutlined';
// mock
import account from '../_mock/account';
import * as appUserService from "../service/AppUserService";

export default function NewFeed() {

	return (
		<>
			<Helmet>
				<title> NewFeed | BugBugBuzz </title>
			</Helmet>
			<Container>
				<Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
					<Typography variant='h4'>BugBugBuzz | Home</Typography>
				</Stack>
				<Stack direction="row" alignItems="center" justifyItems="center" mb={4}>
					<Typography variant='h3'>Here's what your bug resolved!</Typography>
				</Stack>
				<Stack direction="row" alignItems="center" justifyContent="space-between" mb={1}>
					<Avatar style={{ marginRight: 10 }} src='/assets/images/avatars/avatar_default.jpg' alt='photoURL' />
					<TextField
						label="Title"
						value={title}
						onChange={handleTitleChange}
						fullWidth
					/>
				</Stack>
				<TextField
					label="What is your answer?"
					fullWidth
					multiline
					value={content}
					onChange={handleContentChange}
					rows={4}
					margin="normal"
				/>
				<Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
					<Box sx={{ display: 'flex', justifyContent: 'center' }}>
						<IconButton aria-label="add to favorites">
							<ImageIcon color="disabled" />
						</IconButton>
						<IconButton aria-label="attach file">
							<AttachFileIcon />
						</IconButton>
						<IconButton aria-label="add reaction">
							<AddReactionOutlinedIcon />
						</IconButton>
					</Box>
					<Button variant="contained" color="primary" onClick={doPost} disabled={!title.trim()}>
						Post
					</Button>
				</Box>
			</Container>
			<Container>
				{posts?.map((post, index) => (
					<Card key={index} sx={{ maxWidth: 10000 }} style={{ marginTop: '20px' }}>
						<CardHeader
							avatar={
								<Avatar src='/assets/images/avatars/avatar_default.jpg' alt='photoURL' />
							}
							action={
								<IconButton aria-label="settings">
									<MoreVertIcon />
								</IconButton>
							}
							title={post.title}
							subheader={post.timePost}
						/>
						{/* <CardMedia
						component="img"
						height="194"
						image="#"
						alt="Paella dish"
					/> */}
						<CardContent>
							<Typography variant="body2" color="text.secondary">
								{post.content}
							</Typography>
						</CardContent>
						<CardActions disableSpacing style={{ margin: 5 }}>
							<IconButton aria-label="favorites">
								<FavoriteIcon />
							</IconButton>
							<IconButton aria-label="share">
								<ShareIcon />
							</IconButton>
							<IconButton aria-label="save to favorites zone">
								<TurnedInOutlinedIcon />
							</IconButton>
							<IconButton aria-label="share">
								<ForumRoundedIcon />
							</IconButton>
						</CardActions>
						<Stack direction="row" margin={3}>
							{comments?.map((comment, index) => (
								<ListItem key={index} >
									<ListItemAvatar>
										<Avatar src={account.photoURL} alt="photoURL" style={{ margin: 5 }} />
									</ListItemAvatar>
									<ListItemText primary="folower1" secondary="Wow!" />
								</ListItem>

							))}
						</Stack>
						<Stack direction="row" margin={3}>
							<ListItem key={index} >
								<ListItemAvatar>
									<Avatar src={account.photoURL} alt="photoURL" style={{ margin: 5 }} />
								</ListItemAvatar>
								<ListItemText primary="folower2" secondary={comment.content} />
							</ListItem>
						</Stack>
						<Stack direction='row' margin={3}>
							<Avatar src={account.photoURL} alt="photoURL" style={{ margin: 20 }} />
							<TextField label="Enter your comment"
								fullWidth
								multiline
								value={comment}
								onChange={handleCommentChange}
								rows={1}
								margin="dense" />
							<IconButton aria-label="share" onClick={() => doComment(post?.id)} disabled={!comment.trim()}>
								<SendIcon />
							</IconButton>
						</Stack>
					</Card>
				))}
			</Container>
		</>
	)
}