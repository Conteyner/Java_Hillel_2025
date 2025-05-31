package org.lessons.lesson39;

import org.lessons.lesson39.config.Config;
import org.lessons.lesson39.dao.CustomerDao;
import org.lessons.lesson39.model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);

        Customer customer = new Customer(1,"T1", "T2", "T3");
    }
}
