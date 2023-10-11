import { Grid, Box, Button, Container, Stack, TextField, Typography, ListItem, ListItemText } from '@mui/material';
import { Helmet } from 'react-helmet-async';
import React, { useState, useEffect } from 'react';
import Stomp from 'sockjs';
import SockJs from 'sockjs-client';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton, { IconButtonProps } from '@mui/material/IconButton';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import ImageIcon from '@mui/icons-material/Image';
import AttachFileIcon from '@mui/icons-material/AttachFile';
import AddReactionOutlinedIcon from '@mui/icons-material/AddReactionOutlined';
import Footer from '../layouts/home/footer/Footer';



const ExpandMore = styled((props) => {
	const { expand, ...other } = props;
	return <IconButton {...other} />;
})(({ theme, expand }) => ({
	transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
	marginLeft: 'auto',
	transition: theme.transitions.create('transform', {
		duration: theme.transitions.duration.shortest,
	}),
}))


export default function Home() {
	const [posts, setPosts] = useState([]);
	const [post, setPost] = useState();
	const [comments, setComments] = useState([]);
	const [comment, setComment] = useState('');
	const [userData, setUserData] = useState({
		userName: '',
		post: '',
		comment: ''
	});
	const [stompClient, setStompClient] = useState(null);

	useEffect(() => {
		const socket = new SockJs('http:/localhost:8080/ws');
		const client = Stomp.over(socket);

		client.connect([], () => {
			client.subscribe('/forum/posts', (post) => {
				const postUp = JSON.parse(post.body);
				setPosts((prevPosts) => [...prevPosts, postUp])
			});
		});
		setStompClient(client);
		return () => {
			client.disconnect();
		};
	}, []);

	const handleNickNameChange = (e) => {
		setNickName(e.target.value);
	}
	const handlePostChange = (e) => {
		setPosts(e.target.value);
	}

	const doPost = () => {
		if (posts) {
			const newPost = {

			}
		}
	}

	const [expanded, setExpanded] = React.useState(false);

	const handleExpandClick = () => {
		setExpanded(!expanded);
	};
	return (
		<>
			<Helmet>
				<title> Home | BugBugBuzz </title>
			</Helmet>
			<List>
				{posts.map((post, index) => (
					<ListItem key={index}>
						<Avatar></Avatar>
						<ListItemText
							primary={
								<Typography variant="subtitle1" gutterBottom> {post.title} </Typography>}
							secondary={post.content}
						/>
					</ListItem>
				))}
			</List>
			
			<Container>
				<Stack direction="row" alignItems="center" justifyContent="space-between" mb={5}>
					<Typography variant='h4'>BugBugBuzz Home</Typography>
				</Stack>
				<Stack direction="row" alignItems="center" justifyItems="center" mb={4}>
					<Typography variant='h3'>Here's what your bug resolved!</Typography>
				</Stack>
				<form>
					<Stack direction="row" alignItems="center" justifyContent="space-between" mb={1}>
						<Avatar style={{ marginRight: 10 }} src='/assets/images/avatars/avatar_default.jpg' alt='photoURL' />
						<TextField
							label="Title"
							fullWidth
						/>
					</Stack>
					<TextField
						label="What is your answer?"
						fullWidth
						multiline
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
						<Button type="submit" variant="contained" color="primary">
							Post
						</Button>
					</Box>
				</form>
			</Container>

			<Container>
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
						<ExpandMore
							expand={expanded}
							onClick={handleExpandClick}
							aria-expanded={expanded}
							aria-label="show more"
						>
							<ExpandMoreIcon />
						</ExpandMore>
					</CardActions>
					<Collapse in={expanded} timeout="auto" unmountOnExit>
						<CardContent>
							<Typography paragraph>Method:</Typography>
							<Typography paragraph>
								Heat 1/2 cup of the broth in a pot until simmering, add saffron and set
								aside for 10 minutes.
							</Typography>
							<Typography paragraph>
								Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet over
								medium-high heat. Add chicken, shrimp and chorizo, and cook, stirring
								occasionally until lightly browned, 6 to 8 minutes. Transfer shrimp to a
								large plate and set aside, leaving chicken and chorizo in the pan. Add
								pimentón, bay leaves, garlic, tomatoes, onion, salt and pepper, and cook,
								stirring often until thickened and fragrant, about 10 minutes. Add
								saffron broth and remaining 4 1/2 cups chicken broth; bring to a boil.
							</Typography>
							<Typography paragraph>
								Add rice and stir very gently to distribute. Top with artichokes and
								peppers, and cook without stirring, until most of the liquid is absorbed,
								15 to 18 minutes. Reduce heat to medium-low, add reserved shrimp and
								mussels, tucking them down into the rice, and cook again without
								stirring, until mussels have opened and rice is just tender, 5 to 7
								minutes more. (Discard any mussels that don&apos;t open.)
							</Typography>
							<Typography>
								Set aside off of the heat to let rest for 10 minutes, and then serve.
							</Typography>
						</CardContent>
					</Collapse>
				</Card>
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
						<ExpandMore
							expand={expanded}
							onClick={handleExpandClick}
							aria-expanded={expanded}
							aria-label="show more"
						>
							<ExpandMoreIcon />
						</ExpandMore>
					</CardActions>
					<Collapse in={expanded} timeout="auto" unmountOnExit>
						<CardContent>
							<Typography paragraph>Method:</Typography>
							<Typography paragraph>
								Heat 1/2 cup of the broth in a pot until simmering, add saffron and set
								aside for 10 minutes.
							</Typography>
							<Typography paragraph>
								Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet over
								medium-high heat. Add chicken, shrimp and chorizo, and cook, stirring
								occasionally until lightly browned, 6 to 8 minutes. Transfer shrimp to a
								large plate and set aside, leaving chicken and chorizo in the pan. Add
								pimentón, bay leaves, garlic, tomatoes, onion, salt and pepper, and cook,
								stirring often until thickened and fragrant, about 10 minutes. Add
								saffron broth and remaining 4 1/2 cups chicken broth; bring to a boil.
							</Typography>
							<Typography paragraph>
								Add rice and stir very gently to distribute. Top with artichokes and
								peppers, and cook without stirring, until most of the liquid is absorbed,
								15 to 18 minutes. Reduce heat to medium-low, add reserved shrimp and
								mussels, tucking them down into the rice, and cook again without
								stirring, until mussels have opened and rice is just tender, 5 to 7
								minutes more. (Discard any mussels that don&apos;t open.)
							</Typography>
							<Typography>
								Set aside off of the heat to let rest for 10 minutes, and then serve.
							</Typography>
						</CardContent>
					</Collapse>
				</Card>
			</Container>
			<Footer />
		</>
	)
}