package com.scaler.productservicemorningbatch.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.scaler.productservicemorningbatch.models.Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    Date createdAt;
    Date updatedAt;
    String title;
}