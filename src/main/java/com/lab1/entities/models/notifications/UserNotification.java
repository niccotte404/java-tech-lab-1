package com.lab1.entities.models.notifications;

import com.lab1.enums.AccountType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNotification {
    private AccountType type;
    private String title;
    private String event;
}
