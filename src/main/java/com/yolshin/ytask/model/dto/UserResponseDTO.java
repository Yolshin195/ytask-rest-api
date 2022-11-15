package com.yolshin.ytask.model.dto;

import com.yolshin.ytask.model.entity.AppUserRole;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponseDTO {

  //@ApiModelProperty(position = 0)
  private UUID id;
  //@ApiModelProperty(position = 1)
  private String username;
  //@ApiModelProperty(position = 2)
  private String email;
  //@ApiModelProperty(position = 3)
  List<AppUserRole> appRoles;

}
