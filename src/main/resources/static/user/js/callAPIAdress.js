
const host = "https://online-gateway.ghn.vn/shiip/public-api/master-data/province";

const token = 'd9d54289-e5c8-11ee-a2c1-ca2feb4b63fa';

const config = {
    headers: {
        'token': `${token}`
    }
};


var callAPI = (api) => {
    return axios.get(api,  config)
        .then(response => {
            // Xử lý phản hồi từ API
            // console.log(response.data.data);
            renderData(response.data.data, "province");
        })
}


callAPI(host);

// lấy ra district : quận/huyện
var callApiDistrict = (api) => {
    return axios.get(api,  config)
        .then((response) => {
            // console.log(response.data.data);
            renderDataDistrict(response.data.data, "district");
        });
}



// lấy ra ward : xã / phường
var callApiWard = (api) => {
    return axios.get(api,  config)
        .then((response) => {
            // console.log( response.data.data);
            renderDataWard(response.data.data, "ward");
        });
}

// const callAPI_cal_ShipPrice = '';
var callAPI_cal_totalShipPrice = (api) => {
    return axios.get(api,  config)
        .then(response => {
            // Xử lý phản hồi từ API
            // console.log(response.data.data);
            renderDataShipPrice(response.data.data.total, "phiShip");
        })
}


// in ra danh sách các tỉnh
var renderData = (array, select) => {
    if (!Array.isArray(array)) {
        console.log('Data is not an array');
        return;
    }

    let options = '<option disabled value="" selected>Chọn</option>';
    array.forEach(element => {
        options += `<option value="${element.ProvinceID}">${element.ProvinceName}</option>`;
    });
    document.querySelector("#" + select).innerHTML = options;
    renderDataShipPrice(0, "phiShip");

    // document.getElementById("ward").value = "";
}


var renderDataDistrict = (array, select) => {
    if (!Array.isArray(array)) {
        console.log('Data is not an array');
        return;
    }

    let options = '<option disabled value="" selected>Chọn</option>';
    array.forEach(element => {
        options += `<option value="${element.DistrictID}">${element.DistrictName}</option>`;
    });
    document.querySelector("#" + select).innerHTML = options;
    renderDataWard([], "ward")
    renderDataShipPrice(0, "phiShip");

}


var renderDataWard = (array, select) => {
    if (!Array.isArray(array)) {
        console.log('Data is not an array');
        return;
    }

    let options = '<option disabled value="" selected>Chọn</option>';
    array.forEach(element => {
        options += `<option value="${element.WardCode}">${element.WardName}</option>`;
    });
    document.querySelector("#" + select).innerHTML = options;
}

var renderDataShipPrice = (total, input) => {

    let phiShip = total;
    console.log("Phi ship " + phiShip);

    let tongTienElement = document.getElementById('tongTien');
    let tongTien = tongTienElement.value; // Lấy giá trị từ thẻ HTML

    // Chuyển đổi giá trị từ định dạng 'vi-VN' về số
    let tongTienNumber = parseCurrency(tongTien);


    console.log(document.getElementById("tongTien").value)
    console.log("tongTienNumber : " + tongTienNumber);

    let tongTienHang = parseInt(phiShip) + tongTienNumber;
    // console.log(tongTienHang)
    console.log("Tổng tiền đơn hàng: " + tongTienHang);

    // Định dạng số thành dạng "1.000.000"
    let formattedNumber_phiShip = new Intl.NumberFormat('vi-VN').format(phiShip);
    // Gán giá trị đã được định dạng vào thẻ
    document.getElementById('phiShip').value = formattedNumber_phiShip;

    // Định dạng số thành dạng "1.000.000"
    let formattedNumber_tongTienHang = new Intl.NumberFormat('vi-VN').format(tongTienHang);
    // Gán giá trị đã được định dạng vào thẻ
    document.getElementById('tongTienDonHang').value = formattedNumber_tongTienHang;

}



//  https://online-gateway.ghn.vn/shiip/public-api/master-data/district?province_id=201
$("#province").change(() => {
    callApiDistrict("https://online-gateway.ghn.vn/shiip/public-api/master-data/district?province_id="  + $("#province").val() );

});

// https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id=2179
$("#district").change(() => {
    callApiWard("https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id=" + $("#district").val() );
    // console.log("https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id=" + $("#district").val() );

});


$("#ward").change(() => {    // https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee?service_id=53321&from_district_id=1542&to_district_id=1444&to_ward_code=20314&weight=1000
    var weight = document.getElementById("canNangGoiHang").value || 0;


    callAPI_cal_totalShipPrice("https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee?service_type_id=2&from_district_id=1542&to_district_id="+$("#district").val()+"&to_ward_code="+$("#ward").val()+"&weight="+$("#canNangGoiHang").val());
})

function parseCurrency(value) {
    // Loại bỏ dấu phân cách phần nghìn (chấm)
    let cleanedString = value.replace(/\./g, '');
    // Thay thế dấu phân cách thập phân (phẩy) bằng dấu chấm
    cleanedString = cleanedString.replace(',', '.');
    // Chuyển đổi chuỗi thành số thực
    return parseFloat(cleanedString);
}




