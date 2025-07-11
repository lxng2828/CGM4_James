SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE TABLE customer;
TRUNCATE TABLE province;
SET FOREIGN_KEY_CHECKS = 1; 

INSERT INTO province (name) VALUES
('Hà Nội'),
('TP. Hồ Chí Minh'),
('Đà Nẵng'),
('Hải Phòng'),
('Cần Thơ'),
('Quảng Ninh'),
('Khánh Hòa'),
('Lâm Đồng'),
('Thừa Thiên Huế'),
('Kiên Giang');

INSERT INTO customer (first_name, last_name, province_id) VALUES
('Văn An', 'Nguyễn', 1),
('Thị Lan', 'Trần', 2),
('Minh Tuấn', 'Lê', 3),
('Ngọc Anh', 'Phạm', 4),
('Hữu Dũng', 'Hoàng', 5),
('Mỹ Linh', 'Huỳnh', 6),
('Quốc Bảo', 'Phan', 7),
('Thị Hà', 'Vũ', 8),
('Đức Thắng', 'Võ', 9),
('Phương Thảo', 'Đặng', 10),
('Văn Bình', 'Nguyễn', 1),
('Thị Mai', 'Trần', 2),
('Minh Khang', 'Lê', 3),
('Ngọc Diệp', 'Phạm', 4),
('Hữu Toàn', 'Hoàng', 5),
('Mỹ Tâm', 'Huỳnh', 6),
('Quốc Trung', 'Phan', 7),
('Thị Nhung', 'Vũ', 8),
('Đức Hải', 'Võ', 9),
('Phương Vy', 'Đặng', 10),
('Văn Cường', 'Nguyễn', 1),
('Thị Hoa', 'Trần', 2),
('Minh Quân', 'Lê', 3),
('Ngọc Trâm', 'Phạm', 4),
('Hữu Nghĩa', 'Hoàng', 5),
('Mỹ Hạnh', 'Huỳnh', 6),
('Quốc Huy', 'Phan', 7),
('Thị Thủy', 'Vũ', 8),
('Đức Minh', 'Võ', 9),
('Phương Anh', 'Đặng', 10),
('Văn Nam', 'Nguyễn', 1),
('Thị Nga', 'Trần', 2),
('Minh Hoàng', 'Lê', 3),
('Ngọc Bích', 'Phạm', 4),
('Hữu Long', 'Hoàng', 5),
('Mỹ Duyên', 'Huỳnh', 6),
('Quốc Tuấn', 'Phan', 7),
('Thị Trang', 'Vũ', 8),
('Đức Huy', 'Võ', 9),
('Phương Chi', 'Đặng', 10),
('Văn Phong', 'Nguyễn', 1),
('Thị Oanh', 'Trần', 2),
('Minh Nhật', 'Lê', 3),
('Ngọc Châu', 'Phạm', 4),
('Hữu Phước', 'Hoàng', 5),
('Mỹ Lệ', 'Huỳnh', 6),
('Quốc Hùng', 'Phan', 7),
('Thị Hằng', 'Vũ', 8),
('Đức Anh', 'Võ', 9),
('Phương Dung', 'Đặng', 10),
('Văn Sang', 'Nguyễn', 1),
('Thị Yến', 'Trần', 2),
('Minh Đức', 'Lê', 3),
('Ngọc Quyên', 'Phạm', 4),
('Hữu Tài', 'Hoàng', 5),
('Mỹ Ngọc', 'Huỳnh', 6),
('Quốc Việt', 'Phan', 7),
('Thị Loan', 'Vũ', 8),
('Đức Toàn', 'Võ', 9),
('Phương Trinh', 'Đặng', 10),
('Văn Tùng', 'Nguyễn', 1),
('Thị Huệ', 'Trần', 2),
('Minh Hiếu', 'Lê', 3),
('Ngọc Lan', 'Phạm', 4),
('Hữu Thịnh', 'Hoàng', 5),
('Mỹ Trang', 'Huỳnh', 6),
('Quốc Thái', 'Phan', 7),
('Thị Hiền', 'Vũ', 8),
('Đức Thịnh', 'Võ', 9),
('Phương Quyên', 'Đặng', 10),
('Văn Khiêm', 'Nguyễn', 1),
('Thị Hạnh', 'Trần', 2),
('Minh Triết', 'Lê', 3),
('Ngọc Hà', 'Phạm', 4),
('Hữu Nguyên', 'Hoàng', 5),
('Mỹ Tiên', 'Huỳnh', 6),
('Quốc Đạt', 'Phan', 7),
('Thị Nga', 'Vũ', 8),
('Đức Trọng', 'Võ', 9),
('Phương Thúy', 'Đặng', 10),
('Văn Kiên', 'Nguyễn', 1),
('Thị Diễm', 'Trần', 2),
('Minh Quang', 'Lê', 3),
('Ngọc Hương', 'Phạm', 4),
('Hữu Khoa', 'Hoàng', 5),
('Mỹ Huyền', 'Huỳnh', 6),
('Quốc Khánh', 'Phan', 7),
('Thị Lan Anh', 'Vũ', 8),
('Đức Duy', 'Võ', 9),
('Phương Loan', 'Đặng', 10),
('Văn Hùng', 'Nguyễn', 1),
('Thị Kim', 'Trần', 2),
('Minh Long', 'Lê', 3),
('Ngọc Thảo', 'Phạm', 4),
('Hữu Kiệt', 'Hoàng', 5),
('Mỹ Kim', 'Huỳnh', 6),
('Quốc Vương', 'Phan', 7),
('Thị Minh', 'Vũ', 8),
('Đức Trí', 'Võ', 9),
('Phương Hoa', 'Đặng', 10);