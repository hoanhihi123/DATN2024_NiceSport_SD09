


// Function to fetch data from API and render it in table
// function fetchDataAndRender_danhSachSanPhamCT() {
//     fetch('http://localhost:8080/api/ban-hang/getDanhSachSanPham')
//         .then(response => response.json())
//         .then(data => {
//             console.log(data);
//             const tbody = document.getElementById('table-body-chiTietSP');
//             // Clear existing table data
//             tbody.innerHTML = '';
//             // Render data in table
//             data.forEach((sanPhamCT,index) => {
//                 const row = document.createElement('tr');
//                 row.style.textAlign = 'center';
//                 row.innerHTML = `
//                         <th scope="row">${index + 1}</th>
//                         <td>${sanPhamCT.sanPham.ten}</td>
//                         <td><img width="80px" src="${sanPhamCT.hinhAnh}" alt=""></td>
//                         <td style="text-align: left;" >Size: ${sanPhamCT.kichCo.ten} - màu: ${sanPhamCT.mauSac.ten}</td>
//                         <td>${sanPhamCT.soLuong}</td>
//                         <td>${sanPhamCT.giaTriSanPham}</td>
//                         <td ><input type="number" id="${sanPhamCT.id}" value="1" min="1" class="form-control" style="width: 50%; margin: 0px auto;"></td>
//                         <td > <a href="#" class="btn btn-success" onclick="addToBill('${sanPhamCT.id}');"> Chọn mua</a> </td>
//                     `;
//                 tbody.appendChild(row);
//             });
//
//         })
//         .catch(error => console.error('Error fetching data:', error));
// }
//
// fetchDataAndRender_danhSachSanPhamCT();


// thực hiện call data from Danh sach san pham chi tiet va thuc hien phan trang
// sử dụng ajax
// $(function (){
//     // ajax function make call API
//     $.ajax({
//         url: "http://localhost:8080/api/ban-hang/getDanhSachSanPham",
//         type: "GET",
//         data: {
//             page: 2,
//             pageLimit: 3
//         },
//         success: function (data){
//             console.log(data);
//         },
//         error: function (error){
//             console.log("Error : " + error);
//         }
//
//     });
// })

