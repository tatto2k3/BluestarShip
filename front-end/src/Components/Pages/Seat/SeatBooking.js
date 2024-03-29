﻿import React, { useState, useEffect } from 'react';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import "./SeatBooking.css";
import axios from "axios";
import { useSearch } from '../../CustomHooks/SearchContext';
export default function SeatBooking() {
    const [searchResult, setSearchResult, isLoading, setIsLoading, searchInfo,
        setSearchInfo, tripType, setTripType, airport, setAirport, departFlight, setDepartFlight, ariveFlight, setArriveFlight,
        total1, setTotal1, foodItems1, setFoodItems1, total2, setTotal2,
        foodItems2, setFoodItems2, addFoodItem1, calculateTotal1, addFoodItem2, calculateTotal2, passengerInfo,
        setPassengerInfo, seatId, setSeatId, luggaeId, setLuggageId] = useSearch();
    const [seat, setSeat] = useState([]);
    const [activeSeatId, setActiveSeatId] = useState(null);
    const [activeButton, setActiveButton] = useState("Depart");
    const [currentStatus, setCurrentStatus] = useState("depart");
    console.log('Seat ID', seatId)
    useEffect(() => {
        // Fetch data from the API using Axios
        axios.get('http://localhost:8080/api/seats/all')
            .then(response => {
                // Set the fetched data to the state
                setSeat(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);
    return (
        <Paper className="seat-paper">
            {
                tripType === "roundTrip" && (
                    <div className="button_change">
                        <button
                            className={`custom-button-search depart-button ${activeButton === 'Depart' ? 'active-button' : ''}`}
                            onClick={() => {
                                setCurrentStatus("depart");
                                setActiveButton("Depart");
                            }}
                        >
                            Depart
                        </button>

                        <button
                            className={`custom-button-search arrive-button ${activeButton === 'Arrive' ? 'active-button' : ''}`}
                            onClick={() => {
                                setCurrentStatus("arrive");
                                setActiveButton("Arrive");
                            }}
                        >
                            Arrive
                        </button>
                    </div>
                )
            }
            <div className="plane-wrapper">
                <div className="plane-body">
                    <div className="seat-body">
                    <Grid container spacing={2} className='seat-grid'>
                        {

                            seat.map((seat, index) => (
                                <Grid item md={0.6} key={index}>
                                    <div className={`seat-item ${seat.id === activeSeatId ? 'seat-item active' : 'seat-item'}`} onClick={() => {
                                        setSeatId(seat.id)
                                        setActiveSeatId(seat.id)
                                    }}>
                                        {seat.id}
                                    </div>
                                </Grid>
                            ))
                        }
                    </Grid>
                    </div>
                </div>
                <div className="plane-head">
                    <img src="/Images/planeeeee.png" />
                </div>
            </div>
        </Paper>
    )
}