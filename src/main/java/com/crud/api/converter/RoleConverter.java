package com.crud.api.converter;

import com.crud.api.entity.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Convierte Role ↔ String en la base de datos usando Role.getCode().
 * autoApply = true aplica automáticamente a todos los campos de tipo Role
 * sin necesidad de anotar cada campo con @Convert.
 *
 * IMPORTANTE: en la entidad User usar @Convert(converter = RoleConverter.class)
 * en lugar de @Enumerated(EnumType.STRING) para que este converter tome precedencia.
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role != null ? role.getCode() : null;
    }

    @Override
    public Role convertToEntityAttribute(String code) {
       return code != null ? Role.fromCode(code) : null;
    }
}
