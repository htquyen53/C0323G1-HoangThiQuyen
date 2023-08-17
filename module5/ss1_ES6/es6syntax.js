// For of
// *Duyệt qua mảng
let scores = [80,40,50];
for (let score of scores) {
    score = score + 5;
    console.log(score);
} 
// => Kết quả 85 45 55

// Lấy vị trí của các phần tử trong mảng

let colors = ['Red', 'Green', 'Blue'];
for (const [index, color] of colors.entries()) {
    console.log(`${color} is at index ${index}`);
}

// 