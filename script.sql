
CREATE DATABASE WebBanHang
 
CREATE TABLE Loai(
	id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	tenLoai nvarchar(255) NOT NULL,
	congDung nvarchar(255),
	)

	CREATE TABLE SanPham(
	maSP int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	tenSP nvarchar(255) not NULL,
	loai nvarchar(255),
	soLuong int not NULL,
	moTa text ,
	gia float NOT NULL,
	spHot nvarchar(255) not null,
	spNew nvarchar(255) not null,
	photo nvarchar(255),
	)

	CREATE TABLE TKUser(
	id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	email nvarchar(255) NOT NULL,
	passWord nvarchar(255) NOT NULL,
	hoTen nvarchar(255) NOT NULL,
	diaChi nvarchar(255) NOT NULL,
	)

	CREATE TABLE DonDatHang(
	id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	userEmail nvarchar(255) NOT NULL,
	sdt nvarchar(255) NOT NULL,
	hoTen nvarchar(255) NOT NULL,
	diaChi nvarchar(255) NOT NULL,
	tongTien float NOT NULL,
	soLuong int not NULL,
	ghiChu nvarchar(255),
	)

	CREATE TABLE ChiTietDonDatHang(
	id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	idDonDH int not NULL,
	idSanPham int not NULL,
	soLuong int not NULL,
	tongTien float NOT NULL,
	)

	INSERT [dbo].[Loai] ([tenLoai], [congDung]) VALUES (N'Ghe', N'Ngoi')
	INSERT [dbo].[Loai] ([tenLoai], [congDung]) VALUES (N'But', N'Viet')
	INSERT [dbo].[Loai] ([tenLoai], [congDung]) VALUES (N'Giay', N'In')
	INSERT [dbo].[Loai] ([tenLoai], [congDung]) VALUES (N'Mut in', N'In tai lieu')

	INSERT [dbo].[SanPham] ([tenSP],[loai],[soLuong],[moTa],[gia],[spHot],[spNew],[photo]) VALUES (N'Giay A3', N'Giay',1000,N'Giay in loai a3', 1000, N'True', N'True', N'/resources/img/giay-a3.jpg')
	INSERT [dbo].[SanPham] ([tenSP],[loai],[soLuong],[moTa],[gia],[spHot],[spNew],[photo]) VALUES (N'Giay A4', N'Giay',1000,N'Giay in loai A4', 1500, N'True', N'True', N'/resources/img/giay-a4.jpg')
	INSERT [dbo].[SanPham] ([tenSP],[loai],[soLuong],[moTa],[gia],[spHot],[spNew],[photo]) VALUES (N'But bi Thien Long TL025', N'But',100,N'Dau bi: 0.8mm, san suat tai Thuy Si. But bi dang bam khe, co grip.Do dai viet duoc: 1.300-1700m', 5000, N'False', N'False', N'/resources/img/but-bi-tl-025-mau-do-500x500.jpg')
	INSERT [dbo].[SanPham] ([tenSP],[loai],[soLuong],[moTa],[gia],[spHot],[spNew],[photo]) VALUES (N'But bi Thien Long TL027', N'But',100,N'Dau bi: 0.5mm, san suat tai Thuy Si. But bi dang bam co. Noi ti ngon tay cam tiet dien hinh tam giac vua van  voi tay cam giup giam tron tuot khi viet thuong xuyen.', 3000, N'True', N'True', N'/resources/img/847_but-bi-tl-027-mau-xanh-500x500.jpg')