import React, { useState } from 'react';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import "./TicketPage.css";
import { useSearch } from '../../CustomHooks/SearchContext';
export default function TicketPage() {
    const [searchResult, setSearchResult, isLoading, setIsLoading, searchInfo,
        setSearchInfo, tripType, setTripType, airport, setAirport, departFlight, setDepartFlight, ariveFlight, setArriveFlight,
        total1, setTotal1, foodItems1, setFoodItems1, total2, setTotal2,
        foodItems2, setFoodItems2, addFoodItem1, calculateTotal1, addFoodItem2, calculateTotal2, passengerInfo,
        setPassengerInfo, seatId, setSeatId, luggaeId, setLuggageId] = useSearch();
    const handleInputChange = (fieldName, value) => {

        const updatedPassengerInfo = { ...passengerInfo, [fieldName]: value };
        setPassengerInfo(updatedPassengerInfo);
    };

    const provinces = [
        'Hà Nội',
        'Hồ Chí Minh',
        'Đà Nẵng',
        'Hải Phòng',
        'An Giang',
        'Bà Rịa-Vũng Tàu',
        'Bạc Liêu',
        'Bắc Giang',
        'Bắc Kạn',
        'Bắc Ninh',
        'Bến Tre',
        'Bình Định',
        'Bình Dương',
        'Bình Phước',
        'Bình Thuận',
        'Cà Mau',
        'Cao Bằng',
        'Đắk Lắk',
        'Đắk Nông',
        'Điện Biên',
        'Đồng Nai',
        'Đồng Tháp',
        'Gia Lai',
        'Hà Giang',
        'Hà Nam',
        'Hà Tĩnh',
        'Hải Dương',
        'Hậu Giang',
        'Hòa Bình',
        'Hưng Yên',
        'Khánh Hòa',
        'Kiên Giang',
        'Kon Tum',
        'Lai Châu',
        'Lâm Đồng',
        'Lạng Sơn',
        'Lào Cai',
        'Long An',
        'Nam Định',
        'Nghệ An',
        'Ninh Bình',
        'Ninh Thuận',
        'Phú Thọ',
        'Quảng Bình',
        'Quảng Nam',
        'Quảng Ngãi',
        'Quảng Ninh',
        'Quảng Trị',
        'Sóc Trăng',
        'Sơn La',
        'Tây Ninh',
        'Thái Bình',
        'Thái Nguyên',
        'Thanh Hóa',
        'Thừa Thiên-Huế',
        'Tiền Giang',
        'Trà Vinh',
        'Tuyên Quang',
        'Vĩnh Long',
        'Vĩnh Phúc',
        'Yên Bái'
    ];
    

    console.log(passengerInfo);
    return (
        <Paper className="ticket-wrapper">
            
            <div className="ticket-body">
                <Grid container spacing={2}>

                    <Grid item md={6}>
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">Tên họ</label>
                            <input className="ticket-input" placeholder="Tên họ" value={passengerInfo.FirstName}
                                onChange={(e) => handleInputChange('FirstName', e.target.value)}></input>
                        </div>
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">Ngày sinh</label>
                            <input type='date' className="ticket-input" placeholder="Ngày sinh" value={passengerInfo.DateOfBirth}
                                onChange={(e) => handleInputChange('DateOfBirth', e.target.value)}></input>
                        </div>
                      
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">Điện thoại</label>
                            <input className="ticket-input" placeholder="Điện thoại" value={passengerInfo.Contact}
                                onChange={(e) => handleInputChange('Contact', e.target.value)}></input>
                        </div>
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">Tỉnh / Thành phố</label>
                            <select className="ticket-input" value={passengerInfo.City}
                                onChange={(e) => handleInputChange('City', e.target.value)}
                            >
                            <option value="" disabled>Select a city</option>
                            {provinces.map((province, index) => (
                                <option key={index} value={province}>
                                    {province}
                                </option>
                            ))}
                            </select>
                        </div>
                    </Grid>

                    <Grid item md={6}>
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">Tên đệm và tên</label>
                            <input className="ticket-input" placeholder="Tên đệm và tên" value={passengerInfo.LastName}
                                onChange={(e) => handleInputChange('LastName', e.target.value)}></input>
                        </div>
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">CCCD</label>
                            <input className="ticket-input" placeholder="CCCD" value={passengerInfo.PassportNumber}
                                onChange={(e) => handleInputChange('PassportNumber', e.target.value)}></input>
                        </div>
                        
                        <div className="ticket-input-wrapper">
                            <label className="ticket-label">Email</label>
                            <input className="ticket-input" placeholder="Email" value={passengerInfo.Email}
                                onChange={(e) => handleInputChange('Email', e.target.value)}></input>
                        </div>

                    </Grid>
                </Grid>

            </div>

        </Paper>
    )
}