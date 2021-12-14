package pl.bkobeszko.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class MongoTest {

    @Autowired
    TestRepository repository;

    @Test
    void test() {
        TestEntity entity = new TestEntity();
        entity.setName("test_name");

        repository.save(entity);

        List<TestEntity> found = repository.findAll();
        assertEquals(1, found.size());
        assertEquals("test_name", found.get(0).getName());
    }
}
