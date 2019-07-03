package data.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import data.service.BmiRecordInstanceOf;
import data.service.BmiRecordService;
import data.service.impl.BmiRecordInstanceOfImpl;
import data.service.impl.BmiRecordServiceImpl;

public class BmiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BmiRecordInstanceOf.class).to(BmiRecordInstanceOfImpl.class).in(Scopes.SINGLETON);
        bind(BmiRecordService.class).to(BmiRecordServiceImpl.class).in(Scopes.SINGLETON);
    }
}
