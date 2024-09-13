package com.dxc.accountservice.mapper;

import com.dxc.accountservice.dto.CustomerDtoRequest;
import com.dxc.accountservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(source = "customer", target = "customer"  )
    CustomerDtoRequest toCustomerDtoRequest(Customer customer);
}
