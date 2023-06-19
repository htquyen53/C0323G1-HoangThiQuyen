USE quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

SELECT *
FROM subject s
WHERE s.Credit = (SELECT max(s.Credit) FROM subject s)
GROUP BY SubID;
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT s.*, Mark
FROM subject s
join mark m ON s.SubID = m.SubID
where m.Mark = (select max(m.Mark) from mark m)
group by SubID;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT s.*, avg(m.Mark) as "Điểm trung bình"
FROM student s
JOIN mark m ON m.StudentID = s.StudentID
GROUP BY s.StudentID
ORDER BY avg(m.Mark);