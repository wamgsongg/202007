package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categories {
    private int categoryId;
    private String categoryName;
}
