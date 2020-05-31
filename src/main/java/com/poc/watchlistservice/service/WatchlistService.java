package com.poc.watchlistservice.service;

import com.poc.watchlistservice.domain.Watchlist;

import java.util.List;

public interface WatchlistService {

    Watchlist createWatchlist(final Watchlist watchlist);

    Watchlist getWatchlistById(final Long id);

    List<Watchlist> getAllWatchLists();
}
