import { Box, Button, Container, Stack, TextField, Typography, List, ListItem, ListItemText } from '@mui/material';
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


export default function Home() {
	const [posts, setPosts] = useState([]);
	// const [post, setPost] = useState();
	const [title, setTitle] = useState("");
	const [content, setContent] = useState("");
	const [comments, setComments] = useState([]);
	// const [comment, setComment] = useState('');
	const [stompClient, setStompClient] = useState(null);

	useEffect(() => {
		const socket = new SockJs('http:/localhost:8080/ws');
		const client = Stomp.over(socket);

		client.connect([], () => {
			client.subscribe('/forum/posts', (post) => {
				const postUp = JSON.parse(post.body);
				console.log(post.body)
				setPosts((prevPosts) => [...prevPosts, postUp]);
			});
		}, (err) => { console.log(err) });

		setStompClient(client);
		return () => {
			client.connect();
		};
	}, []);

	const handleTitleChange = (e) => {
		setTitle(e.target.value);
	}
	const handleContentChange = (e) => {
		setContent(e.target.value);
	}

	const doPost = () => {
		if (title.trim()) {
			const newPost = {
				title,
				content
			};
			stompClient.send('/bugbugbuzz/post', {}, JSON.stringify(newPost));
			setTitle("");
			setContent("");

		}
	};

	return (
		<>
			<Helmet>
				<title> Home | BugBugBuzz </title>
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
				{/* <List>
					{posts.map((post, index) => (
						<ListItem key={index}>
							<Avatar><ImageIcon /></Avatar>
							<ListItemText
								primary={
									<Typography variant="subtitle1" gutterBottom> {post.title} </Typography>}
								secondary={post.content}
							/>
						</ListItem>
					))}
				</List> */}
				{posts.map((post, index) => (
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
							subheader="September 14, 2016"
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
						<CardActions disableSpacing>
							<IconButton aria-label="add to favorites">
								<FavoriteIcon />
							</IconButton>
							<IconButton aria-label="share">
								<ShareIcon />
							</IconButton>
						</CardActions>
					</Card>
				))}
				<Card sx={{ maxWidth: 10000 }} style={{ marginTop: '20px' }}>
					<CardHeader
						avatar={
							<Avatar src='/assets/images/avatars/avatar_default.jpg' alt='photoURL' />
						}
						action={
							<IconButton aria-label="settings">
								<MoreVertIcon />
							</IconButton>
						}
						title="Shrimp and Chorizo Paella"
						subheader="September 14, 2016"
					/>
					{/* <CardMedia
						component="img"
						height="194"
						image="#"
						alt="Paella dish"
					/> */}
					<CardContent>
						<Typography variant="body2" color="text.secondary">
							This impressive paella is a perfect party dish and a fun meal to cook
							together with your guests. Add 1 cup of frozen peas along with the mussels,
							if you like.
						</Typography>
					</CardContent>
					<CardActions disableSpacing>
						<IconButton aria-label="add to favorites">
							<FavoriteIcon />
						</IconButton>
						<IconButton aria-label="share">
							<ShareIcon />
						</IconButton>
					</CardActions>
				</Card>
			</Container>
		</>
	)
}