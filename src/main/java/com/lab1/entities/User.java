package com.lab1.entities;

import com.lab1.enums.UserType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @NonNull
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String email;
    private int passport;
    private UserType status;

    public User(@NonNull String name, @NonNull String surname, String email, int passport) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.passport = passport;
        this.id = UUID.randomUUID();
        verifyUser();
    }

    public void verifyUser(){
        if (this.passport == 0 || this.email == null){
            this.status = UserType.UNVERIFIED;
            return;
        }
        this.status = UserType.VERIFIED;
    }
}
