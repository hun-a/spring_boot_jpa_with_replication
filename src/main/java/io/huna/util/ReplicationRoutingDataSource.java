package io.huna.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;

import static java.util.stream.Collectors.toList;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    private CircularList<String> dataSourceNameList;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        dataSourceNameList = new CircularList<>(
                targetDataSources.keySet()
                        .stream()
                        .filter(key -> key.toString().contains("slave"))
                        .map(key -> key.toString())
                        .collect(toList())
        );
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return  TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? dataSourceNameList.getOne() : "master";
    }
}
