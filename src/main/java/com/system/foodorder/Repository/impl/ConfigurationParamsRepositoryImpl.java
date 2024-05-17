package com.system.foodorder.Repository.impl;

import com.system.foodorder.Repository.ConfigurationParamsRepository;
import com.system.foodorder.Security.ConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConfigurationParamsRepositoryImpl implements ConfigurationParamsRepository {

    private final ConfigProperties configProperties;
    @Override
    public Optional<Integer> getTimeUpdateable() {
        return Optional.of(configProperties.getMinutes());
    }

    @Override
    public Optional<Double> getPrice() {
        return Optional.of(configProperties.getPilotesPrice());
    }

    @Override
    public List<Integer> findValues() {
        return configProperties.getPilotesPossibleValue();
    }
}
