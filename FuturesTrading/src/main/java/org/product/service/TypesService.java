package org.product.service;

import org.product.domain.Types;

import java.util.List;

public interface TypesService {
    long selectNameid(String name);
    List selectSeName(long id);

    Types selectfindAll();
    List selectName();
    long[] selectSeid(long id);
}
