package org.example.authentiation.entities.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.authentiation.entities.TypeUser;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("token")

    private String token;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("role")
    private String role;

    @JsonProperty("nom")
    private String nom ;
}