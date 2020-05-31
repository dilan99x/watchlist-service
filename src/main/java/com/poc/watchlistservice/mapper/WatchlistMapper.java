package com.poc.watchlistservice.mapper;

import com.poc.watchlistservice.domain.Watchlist;
import com.poc.watchlistservice.entity.WatchlistEntity;
import com.poc.watchlistservice.exception.ApiException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WatchlistMapper extends BaseMapper<WatchlistEntity, Watchlist> {
    @Override
    public Watchlist mapToDto(WatchlistEntity watchlistEntity, Watchlist watchlist) throws ApiException {
        watchlist.setId(watchlistEntity.getId());
        watchlist.setName(watchlistEntity.getName());
        watchlist.setUserId(watchlistEntity.getUserId());
        return watchlist;
    }

    @Override
    public List<Watchlist> mapToDto(List<WatchlistEntity> tSources, List<Watchlist> watchlists) {
        return tSources.stream().map(x-> mapToDto(x, new Watchlist())).collect(Collectors.toList());
    }
}
