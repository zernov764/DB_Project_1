package zernov;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import zernov.dao.StudentDao;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(Main.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        /**
         * В качестве аргументов задаются id исходного курса и группы
         */
        System.out.println("Средняя оценка в группе по данному курсу:  " + studentDao.getCourseMarksInGroup(2, 2));

        Console.main(args);
    }
}
