package com.system.foodorder.Repository;

import java.util.List;
import java.util.Optional;

public interface ConfigurationParamsRepository {
    Optional<Integer> getTimeUpdateable();

    Optional<Double> getPrice();

    List<Integer> findValues();
}
