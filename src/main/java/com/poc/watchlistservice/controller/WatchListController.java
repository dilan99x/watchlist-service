package com.poc.watchlistservice.controller;

import com.poc.watchlistservice.domain.Watchlist;
import com.poc.watchlistservice.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/watchlists")
@RestController
public class WatchListController {

    @Autowired
    private WatchlistService watchlistService;

    @PostMapping
    public ResponseEntity<Watchlist> createWatchlist(@RequestBody Watchlist watchlist){
        Watchlist response = watchlistService.createWatchlist(watchlist);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watchlist> getWatchlistById(@PathVariable final Long id){
        Watchlist response = watchlistService.getWatchlistById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Watchlist>> getWatchlistById(){
        List<Watchlist> response = watchlistService.getAllWatchLists();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
