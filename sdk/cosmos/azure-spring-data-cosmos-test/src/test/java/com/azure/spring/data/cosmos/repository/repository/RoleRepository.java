// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmos.repository.repository;

import com.azure.spring.data.cosmos.domain.Role;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends CosmosRepository<Role, String> {

    @Query(value = "select * from c where c.id = @id")
    List<Role> annotatedFindRoleById(@Param("id") String id);
}
