
package com.crud.api.converter;

import com.crud.api.entity.Status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConvert implements AttributeConverter<Status,String>{

    @Override
    public String convertToDatabaseColumn(Status status) {
       return status != null ? status.getCode() : null;
    }

    @Override
    public Status convertToEntityAttribute(String code) {
       return code != null ? Status.fromCode(code) :  null;
    }

}
