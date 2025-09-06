package com.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO
{
    private String ratingId;
    private String hotelId;
    private String userId;
    private String userName;
    private String rating;
    private String comment;
}
