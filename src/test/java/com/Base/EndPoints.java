package com.Base;

public class EndPoints {
    public static final String baseURI = "https://restful-booker.herokuapp.com/";
    public static final String AUTH = "/auth";
    public static final String HEALTH_CHECK ="/ping";
    public static final String CREATE_BOOKING = "/booking";
    public static final String GET_ALL_BOOKING_IDS = "/booking";
    public static final String GET_BOOKING = "/booking/{bookingId}";
    public static final String UPDATE_BOOKING = "/booking/{bookingId}";
    public static final String DELETE_BOOKING = "/booking/{bookingId}";
}
