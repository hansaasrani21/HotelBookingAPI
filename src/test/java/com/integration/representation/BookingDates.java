package com.integration.representation;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class BookingDates
{
    @Getter
    @Setter
    private Date checkin;
    @Getter
    @Setter
    private Date checkout;
   }
