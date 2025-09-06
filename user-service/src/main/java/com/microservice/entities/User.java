package com.microservice.entities;

import com.microservice.dto.RatingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user-details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
    @Id
    @Column(name = "user_id")
    private String id;
    private String name;
    private String email;
    private String dob;
    private String about;
    @Transient
    private List<RatingDTO> ratingDTO = new ArrayList<>(); //todo: confirm do i need to write this here also as i have done in dto package
}
