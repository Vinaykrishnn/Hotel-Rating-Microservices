package com.user.UserService.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String message;

    private boolean status;

    private String httpStatus;

}
