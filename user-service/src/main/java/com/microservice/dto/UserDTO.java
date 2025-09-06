package com.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO
{
    private String id;
    private String name;
    private String email;
    private String dob;
    private String about;
    private List<RatingDTO> rating = new ArrayList<>();
}
