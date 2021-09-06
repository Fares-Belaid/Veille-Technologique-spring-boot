package com.stage.veilleTech.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthentificationResponse {

    private String accessToken;
}
