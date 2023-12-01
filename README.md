# ThucHanh_WWW_Buoi7
- Sinh viên: **Nguyễn Trường Tuấn Kiệt**
---
# Trang Web Bans Hàng Điện Thoại Di Động
---
## Back end
---
- **Yêu cầu:** Lập trang web Bán Hàng API CRUD
- Ánh xạ `entity`, `repository` extend `JpaRepository`
- Sử dụng 'Spring Boot'
- **Ý tưởng** Áp dụng mô hình `MVC`.
---
## Font end
---
# USER
## Đăng nhập
- Nếu đăng nhập thành công sẽ vào giao diện trang chủ `Trang Web Bán Hàng`.
- Còn thất bại form sẽ thông báo không có tài khoản tồn tại.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/loginkhachhang.png?raw=true)
## Trang chủ bán hàng
- Nếu đăng nhập thành công sẽ vào giao diện trang chủ `Trang Web Bán Hàng`.
- Trang này chứa danh sách các `Sản phẩm`.
- Mỗi sản phẩm sẽ có chứa thông tin của sản phẩm và nút `Add to cart` để thêm sản phẩm đó vào `My cart`.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/muahang.png?raw=true)
- Khi ấn vào `Add to cart` sản phẩm đó sẽ được lưu vào icon `Cart` phía góc trên bên phải và cập nhật số lượng trên icon `Cart`.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/plusCart.png?raw=true)
## Cart
- Và 1 Khi ấn nút `My cart` giao diện `Cart` sẽ được mở ra kèm theo số lượng và sản phẩm trong `My cart`.
- Giao diện sẽ hiện ra từng sản phẩm mình chọn đồng thời kèm theo số lượng mình đã chọn.
- `Total` là tổng tiền của tất cả các sản phẩm theo số lượng mình đã chọn.
- Ở đây mình có thể ấn cộng hay trừ để cập nhật lại số lượng từng sản phẩm trong `Cart` đồng thời nó cũng sẽ cập nhật lại `Total`.
- Và 1 nút `Checkout` để thanh toán.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/viewCart.png?raw=true)
# ADMIN
## Đăng nhập
- Nếu đăng nhập thành công sẽ vào giao diện trang chủ `Quản Lí Trang Web Bán Hàng`.
- Còn thất bại form sẽ thông báo không có tài khoản tồn tại.
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/loginnhanvien.png?raw=true)
## Trang chủ bán hàng
- Khi đăng nhập vô thành công giao diện `Quản Lí Trang Web Bán Hàng`sẽ hiện ra.
- Giao diện gồm tất cả các sản phẩm mà `admin` có.
- Có 1 nút `Thêm sản phẩm` để thêm sản phẩm mới vào danh sách sản phẩm.
- Có 1 nút `Xem Danh Sách Nhân Viên` để xem danh sách các nhân viên có thể login vào `Quản Lí Trang Web Bán Hàng`.
- Có 1 nút `Xem Thống Kê` để xem `Biểu đồ thống kê` số lượng và tông tiền theo tháng của sản phẩm.
- Mỗi sản phẩm có nút `Delete` để update status của sản phẩm.
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/danhsachsanpham_nhanvien.png?raw=true)
## Thêm Sản Phẩm
- Khi ấn vào `Thêm sản phẩm` giao diện thêm sản phẩm sẽ hiện ra.
- Ở đây khi nhập đầy đủ thông tin của 1 sản phẩm thì sản phẩm sẽ được thêm vào danh sách sản phẩm.
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/add_product.png?raw=true)
- Thêm thành công
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/add_succers.png?raw=true)
 ## Xóa Sản Phẩm
 - Khi ấn `Delete` ở sản phẩm nào thì sản phẩm đó sẽ bị xóa khỏi danh sách sản phẩm.
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/danhsachsanpham_nhanvien.png?raw=true)
 ## Xem Danh Sách Nhân Viên
 - Khi ấn vào `Xem Danh Sách Nhân Viên` giao diện hiện danh sách các nhân viên có trong hệ thống.
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/xemdanhsachnhanvien_nhanvien.png?raw=true)
## Thêm Nhân Viên 
- Khi nhập đầy đủ thông tin trên giao diện ấn nút `Thêm nhân viên` nhân viên sẽ được thêm vào danh sách nhân viên.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/add_nhanvien.png?raw=true)
- Thêm thành công.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/add_ok.png?raw=true)
## Xóa Nhân Viên
- Khi ấn nút xóa ở từng nhân viên thì nhân viên đó sẽ được xóa đi khỏi danh sách.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/delete_ok.png?raw=true)
## Xem Thống Kê
- Khi ấn vô nút `Xem thống Kê` giao diện Biểu đồ thống kê sản phẩm sẽ hiện ra.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/viewThongke.png?raw=true)
- Khi ấn select chọn tháng và năm phù hợp và ấn `Xem Thống Kê` giao diện Biểu đồ thống kê sẽ hiện ra.
- Dữ liệu thống kê sẽ hiển thị tương ứng tháng và năm chọn
- Sẽ thống kê số lượng sản phẩm bán được và doanh thư của từng sản phẩm theo tháng đó.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/blob/lab7/MinhChung/locThongKe_ok.png?raw=true).
## Xem code tại đây --> [Link](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi7/tree/lab7)
