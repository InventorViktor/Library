package com.cartoon.dto.pageResoults;

import java.util.List;

public interface PagedResult<Info, Result> {

    Info getInfo();
    List<Result> getResults();
}
