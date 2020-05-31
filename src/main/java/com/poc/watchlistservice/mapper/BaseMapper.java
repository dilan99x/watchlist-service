package com.poc.watchlistservice.mapper;
import com.poc.watchlistservice.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.List;

public abstract class BaseMapper<Source, Target> {

    public abstract Target mapToDto(Source source, Target target) throws ApiException;

    public abstract List<Target> mapToDto(List<Source> tSources, List<Target> targets);

    public void validate(Source source, Target target) throws ApiException {
        if (source == null || target == null) {
            throw new ApiException("INVALID_SOURCE_AND_TARGET", HttpStatus.BAD_REQUEST);
        }
    }

    public void validateList(List<Source> source, List<Target> target) throws ApiException {
        if (source == null || target == null) {
            throw new ApiException("INVALID_SOURCE_AND_TARGET", HttpStatus.BAD_REQUEST);
        }
    }


}
