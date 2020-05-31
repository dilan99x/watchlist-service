package com.poc.watchlistservice.service.impl;

import com.poc.watchlistservice.domain.Watchlist;
import com.poc.watchlistservice.entity.WatchlistEntity;
import com.poc.watchlistservice.exception.ApiException;
import com.poc.watchlistservice.mapper.WatchlistMapper;
import com.poc.watchlistservice.repository.WatchRepository;
import com.poc.watchlistservice.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    private WatchRepository watchRepository;

    @Autowired
    private WatchlistMapper watchlistMapper;

    @Override
    public Watchlist createWatchlist(Watchlist watchlist) {
        WatchlistEntity entity = new WatchlistEntity();
        entity.setId(watchlist.getId());
        entity.setName(watchlist.getName());
        entity.setUserId(watchlist.getUserId());
        entity = watchRepository.save(entity);
        return watchlistMapper.mapToDto(entity, new Watchlist());
    }

    @Override
    public Watchlist getWatchlistById(Long id) {
        Optional<WatchlistEntity> byId = watchRepository.findById(id);
        if(byId.isPresent()){
            return watchlistMapper.mapToDto(byId.get(), new Watchlist());
        }

        return new Watchlist();
    }

    @Override
    public List<Watchlist> getAllWatchLists() {
        List<WatchlistEntity> all = watchRepository.findAll();
        return (watchlistMapper.mapToDto(all, new ArrayList<>()));
    }
}
