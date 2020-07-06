package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class Photos {
    private int photoId;
    private String photoCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date photoTime;
    private String photoPerson;
    private String photoLocation;

}
