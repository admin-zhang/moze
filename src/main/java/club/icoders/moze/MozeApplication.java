package club.icoders.moze;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "club.icoders.moze.mapper", annotationClass = Mapper.class)
public class MozeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MozeApplication.class, args);
    }
}
