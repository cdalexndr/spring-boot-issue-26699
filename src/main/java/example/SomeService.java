package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.concurrent.Future;

@Service
public class SomeService {
    private static final Logger log = LoggerFactory.getLogger(SomeService.class);

    public static boolean isInsideTransaction() {
        return TransactionSynchronizationManager.isActualTransactionActive();
    }


    @Async
    @Transactional
    public Future<?> asyncTask() {
        if (!isInsideTransaction()) {
            log.error("Not inside transaction");
            throw new IllegalStateException("Not inside transaction");
        }
        return null;
    }
}
