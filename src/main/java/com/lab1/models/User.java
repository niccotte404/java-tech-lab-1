package com.lab1.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String email;
    private int passport;
}
