DROP DATABASE IF EXISTS customer_management_db_cgm4james;

CREATE DATABASE customer_management_db_cgm4james CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE customer_management_db_cgm4james;

CREATE TABLE customer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO customer (name, email) VALUES
                                       ('Nguyễn Văn An', 'an.nguyen@gmail.com'),
                                       ('Trần Thị Bình', 'binh.tran@yahoo.com'),
                                       ('Lê Minh Cường', 'cuong.le@hotmail.com'),
                                       ('Phạm Thị Dung', 'dung.pham@fpt.com.vn'),
                                       ('Hoàng Văn Em', 'em.hoang@viettel.vn'),
                                       ('Vũ Thị Hà', 'ha.vu@vng.com'),
                                       ('Đặng Minh Hải', 'hai.dang@gmail.com'),
                                       ('Bùi Thị Hương', 'huong.bui@outlook.com'),
                                       ('Đỗ Văn Ích', 'ich.do@icloud.com'),
                                       ('Hồ Thị Kiều', 'kieu.ho@gmail.com'),
                                       ('Lý Minh Long', 'long.ly@fpt.edu.vn'),
                                       ('Mai Thị Mơ', 'mo.mai@yahoo.com'),
                                       ('Nông Văn Nam', 'nam.nong@gmail.com'),
                                       ('Trương Thị Oanh', 'oanh.truong@viettel.vn'),
                                       ('Phan Văn Phúc', 'phuc.phan@hotmail.com'),
                                       ('Quách Thị Quyên', 'quyen.quach@gmail.com'),
                                       ('Sái Văn Sơn', 'son.sai@fpt.com.vn'),
                                       ('Tô Thị Thảo', 'thao.to@yahoo.com'),
                                       ('Ưng Hoàng Uyên', 'uyen.ung@gmail.com'),
                                       ('Vương Văn Vỹ', 'vy.vuong@vng.com'),
                                       ('Nguyễn Hữu Ánh', 'anh.nguyen.huu@gmail.com'),
                                       ('Trần Đức Bách', 'bach.tran.duc@outlook.com'),
                                       ('Lê Quang Cảnh', 'canh.le.quang@fpt.com.vn'),
                                       ('Phạm Ngọc Diệp', 'diep.pham.ngoc@viettel.vn'),
                                       ('Hoàng Xuân Giang', 'giang.hoang.xuan@gmail.com'),
                                       ('Vũ Quốc Hùng', 'hung.vu.quoc@yahoo.com'),
                                       ('Đặng Thị Khanh', 'khanh.dang.thi@hotmail.com'),
                                       ('Bùi Phương Linh', 'linh.bui.phuong@gmail.com'),
                                       ('Đỗ Thành Nhân', 'nhan.do.thanh@vng.com'),
                                       ('Hồ Ngọc Ngà', 'nga.ho.ngoc@fpt.com.vn'),
                                       ('Lý Thảo Nguyên', 'nguyen.ly.thao@gmail.com'),
                                       ('Mai Anh Quân', 'quan.mai.anh@viettel.vn'),
                                       ('Nông Thị Tâm', 'tam.nong.thi@yahoo.com'),
                                       ('Trương Minh Tuấn', 'tuan.truong.minh@gmail.com'),
                                       ('Phan Thanh Tùng', 'tung.phan.thanh@outlook.com'),
                                       ('Quách Bảo Vy', 'vy.quach.bao@gmail.com'),
                                       ('Sái Thị Xuân', 'xuan.sai.thi@hotmail.com'),
                                       ('Tô Minh Yến', 'yen.to.minh@fpt.com.vn'),
                                       ('Nguyễn Bá Đạt', 'dat.nguyen.ba@gmail.com'),
                                       ('Trần Thị Giang', 'giang.tran.thi@vng.com'),
                                       ('Lê Văn Hiếu', 'hieu.le.van@viettel.vn'),
                                       ('Phạm Quỳnh Lam', 'lam.pham.quynh@yahoo.com'),
                                       ('Hoàng Thùy My', 'my.hoang.thuy@gmail.com'),
                                       ('Vũ Đức Nghĩa', 'nghia.vu.duc@fpt.com.vn'),
                                       ('Đặng Thị Phương', 'phuong.dang.thi@outlook.com'),
                                       ('Bùi Minh Quang', 'quang.bui.minh@gmail.com'),
                                       ('Đỗ Thùy Trang', 'trang.do.thuy@hotmail.com'),
                                       ('Hồ Anh Việt', 'viet.ho.anh@gmail.com'),
                                       ('Lý Ngọc Diễm', 'diem.ly.ngoc@vng.com'),
                                       ('Mai Văn Đông', 'dong.mai.van@fpt.com.vn');
