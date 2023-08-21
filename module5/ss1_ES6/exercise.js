let courses = [
  {
    id: 1,
    title: "ReactJS Tutorial",
    rating: 4.2,
  },
  {
    id: 2,
    title: "Angular Tutorial",
    rating: 2.5,
  },
  {
    id: 3,
    title: "VueJS Tutorial",
    rating: 3.8,
  },
  {
    id: 4,
    title: "Java Tutorial",
    rating: 4,
  },
  {
    id: 5,
    title: "JavaScript Tutorial",
    rating: 3.5,
  },
];

// Yêu cầu 1: 
let firstRequest = courses.filter((e) => e.rating >= 4);
console.log(firstRequest);

// Yêu cầu 2:
let secondRequest = courses.filter(({ rating }) => rating < 4).map((e) => e.id + "-" + e.title + "-" + e.rating);
console.log(secondRequest);

// Yêu cầu 3:
let addedCourses = [ 
  { 
    id: 6, 
    title: "PHP Tutorial", 
    rating: 3, 
  }, 
  { 
    id: 7, 
    title: "C# Tutorial", 
    rating: 2, 
  }, 
  { 
    id: 8, 
    title: "Docker Tutorial", 
    rating: 3.8, 
  } 
]; 
const thirdRequest = (courses, addedCourses) => [...courses,...addedCourses];
console.log(thirdRequest(courses, addedCourses));