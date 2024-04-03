package com.scaler.productservicemorningbatch.inheritancerepresentation.tableperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
}
