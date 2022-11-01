package com.ibm.service.login.model;

import com.ibm.service.login.constraint.ValidPassword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ToString @Getter @Setter @ConstructorBinding
public class RegisterPayload implements Serializable {

    private static final long serialVersionUID= 1123391075778321362L;

    @NotBlank(message = "username must not be blank")
    private String username;

    @NotBlank(message = "password must not be blank")
    @Size(min = 8,message="password need to be longer than 8 characters")
    @ValidPassword(message = "password must contain atleast 1 Uppercase,1 Number,1 Special Character")
    private String password;


    @NotBlank(message = "IP address must not be blank")
    private String ipAddress;

//    public RegisterPayload(String username, String password, String ipAddress) {
//        super();
//        this.username = username;
//        this.password = password;
//        this.ipAddress = ipAddress;
//    }

}
