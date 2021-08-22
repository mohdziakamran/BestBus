package com.example.bestbus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import com.example.bestbus.model.RememberMeToken;
import com.example.bestbus.repository.RememberMeTokenReopsitory;

@Component
public class RememberMeTokenRepositoryService implements PersistentTokenRepository {

    @Autowired
    RememberMeTokenReopsitory repository;

    //need to clear db there may ber redudndency
    
    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        repository.save(new RememberMeToken(null,
                token.getUsername(),
                token.getSeries(),
                token.getTokenValue(),
                token.getDate()));
    }

    @Override
    public void updateToken(String series, String tokenValue, java.util.Date lastUsed) {
    	RememberMeToken token = repository.findBySeries(series);
        repository.save(new RememberMeToken(token.getId(), token.getUsername(), series, tokenValue, lastUsed));
    }
    
    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return repository.findBySeries(seriesId);
    }

    @Override
    public void removeUserTokens(String username) {
    	repository.deleteByUsername(username);
    }
}
