import { Box, Button, Container, Stack, TextField, Typography, ListItem, ListItemText, ListItemAvatar, TablePagination } from '@mui/material';
import { Helmet } from 'react-helmet-async';
import React, { useState, useEffect } from 'react';
import Stomp, { client } from 'stompjs';
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
import SpatialTrackingIcon from '@mui/icons-material/SpatialTracking';
import VoiceOverOffIcon from '@mui/icons-material/VoiceOverOff';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';
import * as postService from "../service/PostService";
import * as userService from "../service/UserService";



export default function Home() {
	const navigate = useNavigate();
	const [rowsPerPage, setRowsPerPage] = useState(5);
	const [page, setPage] = useState(0);
	const [totalElements, setTotalElements] = useState(0);
	const [comments, setComments] = useState([]);
	const [imgPath, setImgPath] = useState("");
	const [statusBtn, setStatusBtn] = useState(false);
	const [connectedPostId, setConnectedPostId] = useState([]);
	const [comment, setComment] = useState({
		// id: null,
		username: "",
		avatarImg: "",
		commentContent: "",
		postId: null
	})

	const [stompClient, setStompClient] = useState(null);

	const [posts, setPosts] = useState([]);
	const [post, setPost] = useState({
		username: "",
		title: "",
		content: "",
		visibilityId: 1
	})


	// Call posts list
	const getAllPosts = async (page, rowsPerPage) => {
		try {
			const response = await postService.getAllPosts(page, rowsPerPage);
			setPosts(response?.data.content);
			setTotalElements(response.data.totalElements);
			console.log(posts)
		} catch (err) {
			console.log(err);
		}
	};
	// Create a post
	const userName = localStorage.getItem("username");
	const avatar = localStorage.getItem("avatar");

	const handleTitleChange = (e) => {
		const { value } = e.target;
		setPost((prevPost) => ({ ...prevPost, title: value }));
	}

	const handleContentChange = (e) => {
		const { value } = e.target;
		setPost((prevPost) => ({ ...prevPost, content: value }))
	}

	const handleSendPost = async () => {
		setPost({ ...post, username: userName })
		console.log(userName)
		const result = await postService.addNewPost(localStorage.getItem("JWT"), post);
		setPost({
			username: "",
			title: "",
			content: "",
			visibilityId: 1
		})

		if (result.status === 200) {
			Swal.fire({
				title: "Add New Post Successful",
				icon: "success",
				timer: 2000,
			}).then(() => {
				getAllPosts(page, rowsPerPage)
			});
		} else {
			Swal.fire({
				title: "Add New Post Failed!",
				icon: "warning",
				timer: 2000,
			}).then(() => {
				getAllPosts(page, rowsPerPage)
			});
		}
	}
	const handleChangePage = (event, newPage) => {
		setPage(newPage);
	};

	const handleChangeRowsPerPage = (event) => {
		setPage(0);
		setRowsPerPage(parseInt(event.target.value, 10));
	};

	// Websocket to discuss about per topic



	const handleConnect = (id) => {
		const socket = new SockJs('http:/localhost:8080/ws');
		const client = Stomp.over(socket);
		client.connect([], () => {
			console.log(id)
			setComment({ ...comment, postId: id })
			client.subscribe(`/forum/posts/${id}`, (payload) => {
				const newComment = JSON.parse(payload.body);
				setComments((prev) => [...prev, newComment]);
			});
		},
			(err) => { console.log(err) });
		setStompClient(client);
		setStatusBtn(true)
		setConnectedPostId([...connectedPostId, id]);
		return () => {
			client.connect();
		};
	}

	const handleDisconnect = () => {
		setStatusBtn(false)
		stompClient.disconnect();
	}


	const sendComment = (id) => {
		const newComment = {
			...comment,
			username: localStorage.getItem("username"),
			postId: id
		}
		stompClient.send(`/bugbugbuzz/post/${id}`, {}, JSON.stringify(newComment));
		setComment({
			...comment,
			commentContent: ""
		});
	}

	// const getAvatar = async (username) => {
	// 	const avatar = await userService.getAvatar(username);
	// 	setImgPath(avatar);
	// }	

	const handleCommentChange = (e) => {
		const { value } = e.target;
		setComment({ ...comment, commentContent: value });
	}
	const handleOnMouseOver = (pId) => {
		setComment({ ...comment, postId: pId })
	}
	useEffect(() => {
		getAllPosts(page, rowsPerPage);
	}, [page, rowsPerPage])

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
					<Avatar style={{ marginRight: 10 }} src={localStorage.getItem("avatar")} alt='photoURL' />
					<TextField
						label="Title"
						value={post.title}
						onChange={handleTitleChange}
						fullWidth
					/>
				</Stack>
				<TextField
					label="What is your answer?"
					fullWidth
					multiline
					value={post.content}
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
					<Button variant="contained" color="primary" onClick={handleSendPost}>
						Post
					</Button>
				</Box>
			</Container>
			<Container>
				{posts?.map((post, index) => (
					<Card key={index} sx={{ maxWidth: 10000 }} style={{ marginTop: '20px' }}>
						<CardHeader
							avatar={
								<Avatar src={post?.appUser?.avatar} alt='photoURL' />
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
							<IconButton aria-label="share" onClick={() => handleConnect(post.id)}>
								<SpatialTrackingIcon />
							</IconButton>
							<IconButton aria-label="share" onClick={handleDisconnect}>
								<VoiceOverOffIcon />
							</IconButton>
						</CardActions>
						{comments?.map((comment, index) => (
							(comment.postId === post.id) &&
							<Stack direction="row" margin={3} key={index}>
								<ListItem  >
									<ListItemAvatar>
										<Avatar src={comment.avatarImg} alt="photoURL" style={{ margin: 5 }} />
									</ListItemAvatar>
									<ListItemText primary={comment.username} secondary={comment.commentContent} />
								</ListItem>
							</Stack>
						))}

						{/* <Stack direction="row" margin={3}>
							<ListItem key={index} >
								<ListItemAvatar>
									<Avatar src={localStorage.getItem("avatar")} alt="photoURL" style={{ margin: 5 }} />
								</ListItemAvatar>
								<ListItemText primary="folower2" secondary="You should ....." />
							</ListItem>
						</Stack> */}
						{statusBtn && (connectedPostId.includes(post?.id)) && <Stack direction='row' margin={3}>
							<Avatar src={localStorage.getItem("avatar")} alt="photoURL" style={{ margin: 20 }} />
							<TextField label="Share your opinion?"
								fullWidth
								multiline
								value={(comment?.postId === post?.id) ? comment?.commentContent : ""}
								onChange={handleCommentChange}
								onMouseOver={() => handleOnMouseOver(post?.id)}
								rows={1}
								margin="dense" />
							<IconButton aria-label="share" onClick={() => { sendComment(post?.id) }}>
								<SendIcon />
							</IconButton>
						</Stack>}
					</Card>
				))}
				<TablePagination
					rowsPerPageOptions={[5, 10, 25]}
					component="div"
					count={totalElements}
					rowsPerPage={rowsPerPage}
					page={page}
					onPageChange={handleChangePage}
					onRowsPerPageChange={handleChangeRowsPerPage}
				/>
			</Container>
		</>
	)
}