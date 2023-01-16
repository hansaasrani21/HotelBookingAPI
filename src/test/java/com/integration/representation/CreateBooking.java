package com.integration.representation;

import lombok.Getter;
import lombok.Setter;

public class CreateBooking {
   @Getter
   @Setter
   private String firstname;
   @Getter
   @Setter
   private String lastname;
   @Getter
   @Setter
   private Integer totalprice;
   @Getter
   @Setter
   private String additionalneeds;
   @Getter
   @Setter
   private Boolean depositpaid;
   @Getter
   @Setter
   private Object bookingdates;
}
