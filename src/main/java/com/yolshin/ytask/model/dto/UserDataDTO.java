package com.yolshin.ytask.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDataDTO {
  
  //@ApiModelProperty(position = 0)
  private String username;
  //@ApiModelProperty(position = 1)
  private String email;
  //@ApiModelProperty(position = 2)
  private String password;
  //@ApiModelProperty(position = 3)
  //List<AppUserRole> appUserRoles;

}
