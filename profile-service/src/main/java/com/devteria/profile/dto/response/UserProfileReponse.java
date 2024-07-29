package com.devteria.profile.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileReponse {
    String id;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
}
